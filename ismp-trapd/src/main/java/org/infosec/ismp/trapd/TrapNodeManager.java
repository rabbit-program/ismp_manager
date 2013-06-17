package org.infosec.ismp.trapd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.infosec.ismp.util.ThreadCategory;
import org.springframework.stereotype.Component;

@Component
public class TrapNodeManager {
	private Map<String, TrapNode> m_trapNodes = Collections
			.synchronizedMap(new HashMap<String, TrapNode>());

	public void addTrapNode(TrapNode node) {
		if (node.getNodeid() != null) {
			m_trapNodes.put(node.getNodeid(), node);
			log().debug("添加一个新的Trap源节点: " + node);
		} else {
			log().warn("无法添加Trap源，因为Nodeid 是null，请检查 :" + node);
		}
	}

	public void removeTrapNode(String nodeid) {
		synchronized (m_trapNodes) {
			if (m_trapNodes.containsKey(nodeid)) {
				m_trapNodes.remove(nodeid);
				log().debug("删除一个Trap源节点,节点nodeid是 :" + nodeid);
			} else {
				log().debug("该Trap源不存在，无法删除，请检查nodeid :" + nodeid);
			}
		}
	}

	public List<TrapNode> getAllTrapNodes() {
		List<TrapNode> nodeList = new ArrayList<TrapNode>(m_trapNodes.size());
		Collection<TrapNode> nodeCollection = m_trapNodes.values();
		for (TrapNode node : nodeCollection) {
			nodeList.add(node);
		}
		return nodeList;
	}

	ThreadCategory log() {
		return ThreadCategory.getInstance(getClass());
	}
}
