package org.infosec.ismp.situation.manager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.infosec.ismp.situation.calculate.substep.callable.result.ResultExponential;
import org.infosec.ismp.situation.model.SituationEvent;

public class AcquireExponential extends Thread {

	private int readIndex = 1;///读取的组号
	
	protected final Log log = LogFactory.getLog(getClass());

	private SituationSaveToDB saveToDB;

	public void setSaveToDB(SituationSaveToDB saveToDB) {
		this.saveToDB = saveToDB;
	}

	private ExecutorService execPool;

	public void setExecPool(ExecutorService execPool) {
		this.execPool = execPool;
	}

	private CompletionService<ResultExponential> completionService;

	public void setCompletionService(CompletionService<ResultExponential> completionService) {
		this.completionService = completionService;
	}

	private SurroundingsInit surroundingsInit;

	public void setSurroundingsInit(SurroundingsInit surroundingsInit) {
		this.surroundingsInit = surroundingsInit;
	}

	private Map<Integer, Integer> count = new HashMap<Integer, Integer>();

	private Map<Integer, Timestamp> time = new HashMap<Integer, Timestamp>();

	private Map<Integer, Map<String, Float>> attackMap = new HashMap<Integer, Map<String, Float>>();

	private Map<Integer, Map<String, Float>> virusMap = new HashMap<Integer, Map<String, Float>>();

	private Map<Integer, Map<String, Float>> illconnMap = new HashMap<Integer, Map<String, Float>>();
	
	private List<SituationEvent> list = new ArrayList<SituationEvent>();

	private boolean flag = true;

	public void run() {
		while (true) {
			try {
				while (flag) {
					if (count.containsKey(readIndex) && time.containsKey(readIndex)) {
						if (count.get(readIndex) == 3) {///该组记录已经是3，这说明该组的数据已经接收全了(攻击map，病毒map，非法连接map都收到)
							Map<String, Float> am = new HashMap<String, Float>(attackMap.get(readIndex));
							Map<String, Float> vm = new HashMap<String, Float>(virusMap.get(readIndex));
							Map<String, Float> im = new HashMap<String, Float>(illconnMap.get(readIndex));
							List<SituationEvent> tempList = new ArrayList<SituationEvent>(list);
							///态势结果计算
							SituationResultCalculate sc = new SituationResultCalculate(
									readIndex, time.get(readIndex), am, vm, im,saveToDB, 
									surroundingsInit.getMaMap(),///获取全部主机信息
									surroundingsInit.getMcMap(),///获取全部机柜信息
									surroundingsInit.getMrMap(),///获取全部机房信息
									surroundingsInit.getSaMap(),///获取全部安全域信息
									tempList);
							log.info("第" + readIndex + "次enter thread pool");
							execPool.execute(sc);///执行任务(在线程池中)
							attackMap.remove(readIndex);
							virusMap.remove(readIndex);
							illconnMap.remove(readIndex);
							count.remove(readIndex);
							time.remove(readIndex);
							list.clear();
							readIndex++;
						} else {
							flag = false;
						}
					}else {
						flag = false;
					}
				}
				Future<ResultExponential> future = completionService.take();///取出一个任务
				ResultExponential res = future.get();///得到结果集
				if (res != null && res.getIndex() > 0 && res.getTime() != null && res.getType() > 0) {
					int index = res.getIndex();///属于第几组
					int type = res.getType();///类型
					switch (type) {
					case 1:
						attackMap.put(index, res.getExp());///1为攻击事件
						break;
					case 2:
						virusMap.put(index, res.getExp());///2为病毒事件
						break;
					case 3:
						illconnMap.put(index, res.getExp());///3为非法连接事件
						break;
					}
					if(null != res.getList() && res.getList().size() > 0 ){
						list.addAll(res.getList());
					}
					if (count.containsKey(index)) {///组计数器中已经存在该组的记录
						int value = count.get(index);///取出该组的记录数
						value++;///加1
						count.put(index, value);///更新本组的记录数
						time.put(index, res.getTime());///更新本组的时间
					} else {
						count.put(index, 1);///组计数器中没有该组的记录，则增加，该组收到1种map
						time.put(index, res.getTime());///增加该组的起始判断时间
					}
					flag = true;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
