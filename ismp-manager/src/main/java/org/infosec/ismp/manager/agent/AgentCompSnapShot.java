package org.infosec.ismp.manager.agent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.infosec.ismp.eventd.sender.EventSender;
import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;
import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.util.ThreadCategory;

class AgentCompSnapShot implements Externalizable {
	// 标识Agent是否重启，重启后uuid不一样
	private final String agentId;
	private String uuid;

	protected InetAddress ipAddr;
	protected int port;

	private boolean active = false;

	private final AgentComponent m_agent;
	/**
	 * 需要发送到远端的工作
	 */
	private List<AgentTodoTask> m_todoTasks = new LinkedList<AgentTodoTask>();

	/**
	 * 已经发送到远程Agent的工作
	 */
	private List<AgentTodoTask> m_doneTasks = new LinkedList<AgentTodoTask>();

	private final File tempFile;

	/**
	 * 
	 * @param agentComponent
	 */
	public AgentCompSnapShot(AgentComponent agentComponent, File file) {
		m_agent = agentComponent;
		this.agentId = agentComponent.getAgentId();
		this.tempFile = file;
		if (tempFile.exists()) {
			read();
		}
	}

	private void checkFile() {
		if (tempFile != null) {
			File file = tempFile.getParentFile();
			if (!file.exists()) {
				boolean flag = file.mkdir();
				log().warn("创建文件:" + flag);
			}
		}
	}

	protected void saveToFile() {
		checkFile();
		ObjectOutputStream out = null;
		try {
			FileOutputStream fout = new FileOutputStream(tempFile);
			out = new ObjectOutputStream(new BufferedOutputStream(fout));
			writeExternal(out);
			out.flush();
		} catch (Throwable e) {
			log().error("序列化AgentSnapShot出错 ：", e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void readImage() {
		if (tempFile.exists() && !tempFile.isDirectory()) {
			read();
		}
	}

	/**
	 * 初始化从序列化文件读取内容
	 */
	protected void read() {
		ObjectInputStream in = null;
		try {
			FileInputStream fin = new FileInputStream(tempFile);
			in = new ObjectInputStream(new BufferedInputStream(fin));
			readExternal(in);
		} catch (Throwable e) {
			log().error("反序列化AgentSnapShot出错 ：", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 序列化时使用
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		log().info("快照存盘前信息：uuid is : " + uuid);
		log().info("存盘前已完成任务数: " + m_doneTasks.size());
		log().info("存盘前未完成任务数: " + m_todoTasks.size());
		out.writeUTF(agentId);
		out.writeUTF(uuid);

		out.writeObject(m_todoTasks);
		out.writeObject(m_doneTasks);

	}

	/**
	 * 反序列化使用
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		String agentId = in.readUTF();
		if (!this.agentId.equals(agentId)) {
			throw new RuntimeException("文件内容中AgentId发生变化,文件中agentId是" + agentId
					+ "数据库中agentId是" + this.agentId);
		}
		uuid = in.readUTF();

		List<AgentTodoTask> tasks = (List<AgentTodoTask>) in.readObject();
		m_todoTasks.addAll(tasks);

		tasks = (List<AgentTodoTask>) in.readObject();
		m_doneTasks.addAll(tasks);

	}

	// public String getUuid() {
	// return this.uuid;
	// }

	public void register(String uuid, String ipaddr, int port) {
		boolean flag = true;
		try {
			ipAddr = InetAddress.getByName(ipaddr);
		} catch (UnknownHostException e) {
			flag = false;
			log().fatal("agent注册的地址信息错误,注册地址是:" + ipaddr, e);
		}
		if (port < 0 || port > 65535) {
			flag = false;
			log().fatal("agent注册的端口信息错误,注册端口是:" + port);
		} else {
			this.port = port;
		}

		String trimUuid = StringUtils.trimToNull(uuid);

		if (trimUuid == null) {
			flag = false;
			log().fatal("agent注册的UUID信息错误,注册UUID是:" + uuid);
		}

		if (flag) {// 注册成功
			setActive(true);
			if (uuid.equals(this.uuid)) {// 相同UUID
				log().info("发送未完成工作");
				sendTodoTask();// 将发送未完成的工作
			} else {// 不相同UUID,远程Agent重启
				log().info("重置服务器工作");
				this.uuid = uuid;
				reset();
				sendTodoTask();
			}
		}
		saveToFile();

	}

	private void sendTodoTask() {
		log().info("未发送任务个数为:" + m_todoTasks.size());
		synchronized (m_todoTasks) {
			Iterator<AgentTodoTask> it = m_todoTasks.iterator();
			while (it.hasNext()) {
				AgentTodoTask task = it.next();
				boolean flag = sendToRemoteAgent(task);
				if (flag) {
					// m_todoTasks.remove(task);
					it.remove();
					m_doneTasks.add(task);
				}
			}
			// for (AgentTodoTask task : m_todoTasks) {
			// boolean flag = sendToRemoteAgent(task);
			// if (flag) {
			// m_todoTasks.remove(task);
			// m_doneTasks.add(task);
			// }
			// }
		}

	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * 远端Agent重启，需要重新分配任务
	 */
	protected void reset() {
		resetDo();
		saveToFile();
	}

	private void resetDo() {
		m_doneTasks.clear();// 清除所有已完成任务
		m_todoTasks.clear();// 清除所有未完成任务
		List<AgentTodoTask> tasks = getTodoTaskFromAgent(m_agent);
		log().info("全部工作是：" + tasks);
		m_todoTasks.addAll(tasks);
	}

	/**
	 * 获得所有需要完成的任务
	 * 
	 * @param agent
	 * @return
	 */
	private List<AgentTodoTask> getTodoTaskFromAgent(AgentComponent agent) {
		List<AgentTodoTask> tasks = new ArrayList<AgentTodoTask>();
		List<AgentTaskNode> nodes = agent.getAllTaskNodes();
		for (AgentTaskNode node : nodes) {
			AgentTodoTask task = node.convertToTask();
			tasks.add(task);
		}
		return tasks;
	}

	/**
	 * 添加任务
	 * 
	 * @param task
	 */
	public void addAgentTask(AgentTodoTask task) {
		addAgentTaskDo(task);
		saveToFile();
	}

	private void addAgentTaskDo(AgentTodoTask task) {
		if (task.isDelete()) {// 如果是删除任务，先看该任务是否发出
			AgentTodoType type = task.getType();
			synchronized (m_todoTasks) {
				Iterator<AgentTodoTask> it = m_todoTasks.iterator();
				while(it.hasNext()){
					AgentTodoTask todoTask = it.next();
					if (type == todoTask.getType()
							&& task.getNodeid().equals(todoTask.getNodeid())) {// 找到了
						it.remove();
						return;
					}
				}
//				for (AgentTodoTask todoTask : m_todoTasks) {
//					if (type == todoTask.getType()
//							&& task.getNodeid().equals(todoTask.getNodeid())) {// 找到了
//						m_todoTasks.remove(todoTask);
//						return;
//					}
//				}
			}

			boolean flag = sendToRemoteAgent(task);
			if (flag) {// 发送成功
				m_doneTasks.add(task);
			} else {// 没有发送成功
				m_todoTasks.add(task);
			}
		} else {

			if (active) {
				boolean flag = sendToRemoteAgent(task);
				if (flag) {
					m_doneTasks.add(task);
				} else {
					m_todoTasks.add(task);
				}
			} else {
				m_todoTasks.add(task);
			}
		}

		log().info("已完成任务数:" + m_doneTasks.size());
		log().info("未完成任务数:" + m_todoTasks.size());
	}

	/**
	 * 将任务发送到远程Agent上
	 * 
	 * @param task
	 * @return
	 */
	private boolean sendToRemoteAgent(AgentTodoTask task) {
		Event event = task.convertToEvent();
		boolean flag = EventSender.sendEvent(ipAddr, port, event);
		log().info(
				"向远程Agent : nodeid is " + event.getNodeid() + ",uei is " + event.getUei()
						+ "发送事件，发送 ：" + flag);
		log().info(
				"向远程Agent : ipaddr is " + ipAddr + ",port is " + port
						+ "发送事件，发送 ：" + flag);
		return flag;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}

	public String getAgentAddress() {
		return ipAddr.getHostAddress();
	}

	public int getAgentPort() {
		return port;
	}

}
