package org.infosec.ismp.manager.agent;

import java.io.Serializable;

import org.infosec.ismp.manager.agent.task.AgentTodoTask;
import org.infosec.ismp.manager.agent.task.AgentTodoTask.AgentTodoType;

public interface AgentTaskNode extends Serializable{
	 /**
	  * 将节点变成任务
	  * @return
	  */
     public AgentTodoTask convertToTask();
     /**
 	 * 返回任务的唯一标识
 	 * @return
 	 */
     public String getNodeid();
     /**
      * 返回任务的类型
      * @return
      */
     public AgentTodoType getType();
     
}
