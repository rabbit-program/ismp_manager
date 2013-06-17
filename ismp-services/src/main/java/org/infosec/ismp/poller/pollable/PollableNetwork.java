package org.infosec.ismp.poller.pollable;

import java.net.InetAddress;
import java.util.Date;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.poller.PollStatus;

/**
 * Represents a PollableNetwork 
 *
 */
public class PollableNetwork extends PollableContainer {

	private final PollContext m_context;

	public PollableNetwork(PollContext context) {
		super(null, Scope.NETWORK);
		m_context = context;
	}

	@Override
	public PollContext getContext() {
		return m_context;
	}

	public PollableNode createNode(int nodeId, String nodeLabel) {
		PollableNode node = new PollableNode(this, nodeId, nodeLabel);
		addMember(node);
		return node;
	}

	public PollableNode createNodeIfNecessary(int nodeId, String nodeLabel) {
		synchronized (this) {
			PollableNode node = getNode(nodeId);
			return (node != null ? node : createNode(nodeId, nodeLabel));
		}

	}

	public PollableNode getNode(int nodeId) {
		return (PollableNode) getMember(new Integer(nodeId));
	}

	public int getNodeCount() {
		return getMemberCount();
	}

	public PollableInterface createInterface(int nodeId, String nodeLabel,
			InetAddress addr) {
		return createNodeIfNecessary(nodeId, nodeLabel).createInterface(addr);
	}

	public PollableInterface getInterface(int nodeId, InetAddress addr) {
		PollableNode node = getNode(nodeId);
		return (node == null ? null : node.getInterface(addr));
	}

	public PollableService createService(int nodeId, String nodeLabel,
			InetAddress addr, String svcName) {
		return createNodeIfNecessary(nodeId, nodeLabel).createService(addr,
				svcName);
	}

	public PollableService getService(int nodeId, InetAddress addr,
			String svcName) {
		PollableNode node = getNode(nodeId);
		return (node == null ? null : node.getService(addr, svcName));
	}

	@Override
	protected Object createMemberKey(PollableElement member) {
		PollableNode node = (PollableNode) member;
		return new Integer(node.getNodeId());
	}

	@Override
	protected void visitThis(PollableVisitor v) {
		super.visitThis(v);
		v.visitNetwork(this);
	}

	@Override
	public PollStatus pollRemainingMembers(PollableElement member) {
		return getMemberStatus();
	}

	@Override
	public Event createDownEvent(Date date) {
		throw new UnsupportedOperationException("No down event for the network");
	}

	@Override
	public Event createUpEvent(Date date) {
		throw new UnsupportedOperationException("No up event for the network");
	}

	// class DumpVisitor extends PollableVisitorAdaptor {
	//
	// private final ThreadCategory m_log;
	//
	// public DumpVisitor(ThreadCategory log) {
	// m_log = log;
	// }
	//
	// @Override
	// public void visitNode(PollableNode pNode) {
	// m_log.debug(" nodeid=" + pNode.getNodeId() + " status="
	// + getStatusString(pNode));
	// }
	//
	// @Override
	// public void visitInterface(PollableInterface pIf) {
	// ;
	// m_log.debug("     interface=" + pIf.getIpAddr() + " status="
	// + getStatusString(pIf));
	// }
	//
	// @Override
	// public void visitService(PollableService pSvc) {
	// m_log.debug("         service=" + pSvc.getSvcName() + " status="
	// + getStatusString(pSvc));
	// }
	//
	// private String getStatusString(PollableElement e) {
	// PollStatus status = e.getStatus();
	// boolean up = status.isUp();
	// String statusDesc = status.toString();
	// PollEvent cause = e.getCause();
	// int eventId = cause == null ? 0 : cause.getEventId();
	// return (up ? statusDesc : statusDesc + "(" + eventId + ")");
	// }
	// }
	//
	// public void dump() {
	// final ThreadCategory log = ThreadCategory.getInstance(getClass());
	//
	// DumpVisitor dumper = new DumpVisitor(log);
	// visit(dumper);
	//
	// }

	@Override
	public void delete() {
		throw new UnsupportedOperationException(
				"Can't delete the entire network");
	}

	@Override
	public PollStatus poll(PollableElement elem) {
		PollableElement member = findMemberWithDescendent(elem);
		return member.poll(elem);
	}

	@Override
	public void processStatusChange(Date date) {
		// no need to process status changes for the network itself
		processMemberStatusChanges(date);
	}

	@Override
	public void recalculateStatus() {
		Iter iter = new Iter() {
			@Override
			public void forEachElement(PollableElement elem) {
				elem.recalculateStatus();
			}
		};
		forEachMember(iter);
	}

	@Override
	public void resetStatusChanged() {
		super.resetStatusChanged();
		Iter iter = new Iter() {
			@Override
			public void forEachElement(PollableElement elem) {
				elem.resetStatusChanged();
			}
		};
		forEachMember(iter);
	}

	@Override
	public PollableElement getLockRoot() {
		return this;
	}

	@Override
	public void obtainTreeLock(long timeout) {
	}

	@Override
	public void releaseTreeLock() {
	}

	@Override
	public PollEvent extrapolateCause() {

		Iter iter = new Iter() {
			@Override
			public void forEachElement(PollableElement elem) {
				elem.extrapolateCause();
			}
		};
		forEachMember(iter);
		return null;

	}

	public void propagateInitialCause() {
		extrapolateCause();
		inheritParentalCause();
	}

}
