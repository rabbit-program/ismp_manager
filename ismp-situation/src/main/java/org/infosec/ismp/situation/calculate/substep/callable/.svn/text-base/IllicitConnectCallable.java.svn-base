package org.infosec.ismp.situation.calculate.substep.callable;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import org.infosec.ismp.situation.calculate.substep.callable.result.ResultExponential;
import org.infosec.ismp.situation.model.SituationEvent;
import org.infosec.ismp.situation.util.SituationUtils;

public class IllicitConnectCallable implements Callable<ResultExponential> {

	private Map<String, int[]> counts;

	private int index;

	private Timestamp time;
	
	private List<SituationEvent> list;

	public IllicitConnectCallable(Map<String, int[]> counts, int vindex, Timestamp vtime,List<SituationEvent> list) {
		this.counts = counts;
		this.index = vindex;
		this.time = vtime;
		this.list = list;
	}

	@SuppressWarnings("unchecked")
	public ResultExponential call() throws Exception {
		Map<String, Float> map = new HashMap<String, Float>();
		if(null != list && list.size() > 0){
			for (SituationEvent situationevent : list) {
				situationevent.setTime(time);///将非法连接态势的生成时间保存进situationevent对象
			}
		}
		ResultExponential res = new ResultExponential();
		if (counts != null && counts.size() > 0) {
			Iterator<Entry<String, int[]>> it = counts.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = it.next();
				String ip = (String) entry.getKey();///ip地址
				int[] count = (int[]) entry.getValue();
				float value = SituationUtils.exponentialCalculate(count);///计算态势指数。
				map.put(ip, value);
			}
		}
		res.setExp(map);
		res.setIndex(index);
		res.setTime(time);
		res.setType(3);///类型为3，表示 非法连接。
		res.setList(list);
		return res;///任务的返回值
	}

}
