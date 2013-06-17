package org.infosec.ismp.poller.pollable;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.poller.PollStatus;
import org.infosec.ismp.util.ThreadCategory;

/**
 * Represents a PollableElement 
 *
 * @author <a href="mailto:brozow@opennms.org">Mathew Brozowski</a>
 */
abstract public class PollableElement {

	private final Scope m_scope;

	private volatile PollableContainer m_parent;
	private volatile PollStatus m_status = PollStatus.unknown();
	private volatile boolean m_statusChanged = false;
	private volatile PollEvent m_cause;
	private volatile boolean m_deleted;

	protected PollableElement(PollableContainer parent, Scope scope) {
		m_parent = parent;
		if (parent != null) {
			m_cause = parent.getCause();
		}
		m_scope = scope;
	}

	public PollableContainer getParent() {
		return m_parent;
	}

	protected void setParent(PollableContainer newParent) {
		m_parent = newParent;
	}

	public Scope getScope() {
		return m_scope;
	}

	public void visit(PollableVisitor v) {
		visitThis(v);
	}

	protected void visitThis(PollableVisitor v) {
		v.visitElement(this);
	}

	public PollStatus getStatus() {
		return m_status;
	}

	private void setStatus(PollStatus status) {
		m_status = status;
	}

	public boolean isStatusChanged() {
		return m_statusChanged;
	}

	private void setStatusChanged(boolean statusChanged) {
		m_statusChanged = statusChanged;
	}

	public void updateStatus(PollStatus newStatus) {
		PollStatus oldStatus = getStatus();
		if (!oldStatus.equals(newStatus)) {

			ThreadCategory.getInstance(getClass()).info(
					"Changing status of PollableElement " + this + " from "
							+ oldStatus + " to " + newStatus);
			setStatus(newStatus);
			setStatusChanged(true);
		}
	}

	public void resetStatusChanged() {
		setStatusChanged(false);
	}

	public void recalculateStatus() {
		// do nothing for just an element
	}

	public abstract PollContext getContext();

	/**
	 * @param service
	 * @return
	 */
	public PollStatus doPoll(PollableElement elem) {
		if (getParent() == null) {
			resetStatusChanged();
			return poll(elem);
		} else
			return getParent().doPoll(elem);
	}

	public PollableElement getLockRoot() {
		PollableContainer parent = getParent();
		return (parent == null ? this : parent.getLockRoot());
	}

	public boolean isTreeLockAvailable() {
		return getLockRoot().isTreeLockAvailable();
	}

	public void obtainTreeLock(long timeout) {
		getLockRoot().obtainTreeLock(timeout);
	}

	public void releaseTreeLock() {
		getLockRoot().releaseTreeLock();
	}

	public void withTreeLock(Runnable r) {
		withTreeLock(r, 0);
	}

	public <T> T withTreeLock(Callable<T> c) {
		return withTreeLock(c, 0);
	}

	public void withTreeLock(Runnable r, long timeout) {
		withTreeLock(Executors.callable(r), timeout);
	}

	public <T> T withTreeLock(Callable<T> c, long timeout) {
		try {
			obtainTreeLock(timeout);
			return c.call();
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			releaseTreeLock();
		}
	}

	/**
	 * 
	 */
	abstract public PollStatus poll();

	protected PollStatus poll(PollableElement elem) {
		if (elem != this)
			throw new IllegalArgumentException("Invalid parameter to poll on "
					+ this + ": " + elem);

		return poll();
	}

	/**
	 * @return
	 */
	public PollableElement selectPollElement() {
		return this;
	}

	/**
	 * @param date
	 * @return
	 */
	public abstract Event createDownEvent(Date date);

	/**
	 * @param date
	 * @return
	 */
	public abstract Event createUpEvent(Date date);

	/**
	 * @param cause TODO
	 */
	protected void createOutage(PollEvent cause) {
		setCause(cause);
	}

	public boolean hasOpenOutage() {
		return m_cause != null;
	}

	public void setCause(PollEvent cause) {
		m_cause = cause;
	}

	public PollEvent getCause() {
		return m_cause;
	}

	/**
	 * @param date
	 * 
	 */
	public void processStatusChange(Date date) {
		if (getStatus().isDown() && isStatusChanged()) {
			processGoingDown(date);
		} else if (getStatus().isUp() && isStatusChanged()) {
			processComingUp(date);
		}
	}

	protected void processComingUp(Date date) {
		if (getCause() != null) {
			PollEvent resolution = getContext().sendEvent(createUpEvent(date));
			processResolution(getCause(), resolution);
		}
	}

	protected void processResolution(PollEvent cause, PollEvent resolution) {
		// resolveOutage(resolution);
	}

	protected void processGoingDown(Date date) {
		PollEvent cause = getContext().sendEvent(createDownEvent(date));
		processCause(cause);
	}

	protected void processCause(PollEvent cause) {
		// if (!hasOpenOutage())
		createOutage(cause);
	}

	protected void resolveAllOutages(PollEvent resolvedCause,
			PollEvent resolution) {
		// if (resolvedCause.equals(getCause()))
		// resolveOutage(resolution);
	}

	public boolean isDeleted() {
		return m_deleted;
	}

	public void delete() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				m_deleted = true;
				if (m_parent != null) {
					getParent().deleteMember(PollableElement.this);
					getParent().recalculateStatus();
				}
			}
		};
		withTreeLock(r);
	}

	protected void processLingeringCauses(PollEvent resolvedCause,
			PollEvent resolution) {
		if (getStatus().isDown() && resolvedCause.equals(getCause())) {
			resolveAllOutages(resolvedCause, resolution);
			processGoingDown(resolution.getDate());
		} else if (getStatus().isUp() && resolvedCause.equals(getCause())) {
			processResolution(resolvedCause, resolution);
		} else if (getStatus().isUp() && !resolvedCause.equals(getCause())) {
			processComingUp(resolution.getDate());
		}
	}

	public PollEvent extrapolateCause() {
		return withTreeLock(new Callable<PollEvent>() {
			@Override
			public PollEvent call() throws Exception {
				return doExtrapolateCause();
			}
		});
	}

	protected PollEvent doExtrapolateCause() {
		return getCause();
	}

	public void inheritParentalCause() {
		withTreeLock(new Runnable() {

			@Override
			public void run() {
				doInheritParentalCause();
			}

		});
	}

	protected void doInheritParentalCause() {
		if (getParent() == null)
			return;

		PollEvent parentalCause = getParent().getCause();
		PollStatus parentalStatus = getParent().getStatus();
		if (parentalCause == null) {
			// parent has no cause so no need to do anything here
			return;
		}

		if (getCause() == null || getCause().hasScopeLargerThan(getScope())) {
			// I have no cause but my parent is down.. mark me as down as well
			// I already have a cause that's larger than myself then inherit as
			// well
			setCause(parentalCause);
			updateStatus(parentalStatus);
		}

	}

}
