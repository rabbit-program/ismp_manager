package org.infosec.ismp.situation.calculate.substep;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;

import org.infosec.ismp.situation.calculate.substep.callable.AttackCallable;
import org.infosec.ismp.situation.calculate.substep.callable.result.ResultExponential;
import org.infosec.ismp.situation.model.Event;
import org.infosec.ismp.situation.model.SituationEvent;

public class AttackReckon {

	private Map<String, int[]> map = new HashMap<String, int[]>();
	
	private List<SituationEvent> list = new ArrayList<SituationEvent>();

	private CompletionService<ResultExponential> completionService;

	public void setCompletionService(
			CompletionService<ResultExponential> completionService) {
		this.completionService = completionService;
	}

	public int mapSize() {
		return map.size();
	}
	///分析事件  参数是事件。
	public void analyzeEvent(Event event) {
		int[] count;
		int x = event.getPriority();///获得这个事件的优先级
		String ip = event.getDestAddress();///获得这个事件的目的IP
		SituationEvent situationEvent = new SituationEvent();///态势对应事件类
		situationEvent.setEventId(event.getId());///事件id
		situationEvent.setSrcmod(event.getSrcmod());///事件产生模块
		situationEvent.setEventIP(ip);
		list.add(situationEvent);
		if (ip != null && ip.length() > 0) {
			if (map.containsKey(ip)) {
				count = map.get(ip);///取得map里的ip赋给count
			} else {
				count = new int[] { 0, 0, 0, 0, 0 };///如果map里没有ip则新建一个。
			}
			if (x > 0) {///x 为优先级取值。
				switch (x) {
				case 1:
					count[0] = count[0] + 1;
					break;
				case 2:
					count[1] = count[1] + 1;
					break;
				case 3:
					count[2] = count[2] + 1;
					break;
				case 4:
					count[3] = count[3] + 1;
					break;
				case 5:
					count[4] = count[4] + 1;
					break;
				}
				map.put(ip, count);
			}
		}
	}
	///计算指数。
	public void reckonExponential(Timestamp endtime, int index) {
		synchronized (map) {
			Map<String, int[]> maps = new HashMap<String, int[]>(map);
			List<SituationEvent> lists = new ArrayList<SituationEvent>(list);
			completionService.submit(new AttackCallable(maps, index, endtime ,lists));///提交计算攻击事件态势的任务
			map.clear();
			list.clear();
		}
	}

}
