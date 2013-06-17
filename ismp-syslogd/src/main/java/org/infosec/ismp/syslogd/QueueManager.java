package org.infosec.ismp.syslogd;

import org.infosec.ismp.model.syslog.RawSyslog;
import org.infosec.ismp.model.syslog.SyslogWrapper;
import org.infosec.ismp.util.ThreadCategory;
import org.infosec.ismp.util.queue.FifoQueue;
import org.infosec.ismp.util.queue.FifoQueueException;
import org.infosec.ismp.util.queue.FifoQueueImpl;

/**
 * 
 */
public class QueueManager {

	FifoQueue<RawSyslog> m_backlogQ = new FifoQueueImpl<RawSyslog>();

	RawSyslog ret;

	public synchronized void putInQueue(RawSyslog re) {
		// This synchronized method places a message in the queue
		// Category log = ThreadCategory.getInstance(this.getClass());

		ret = re;

		try {
			m_backlogQ.add(ret);

		} catch (FifoQueueException e) {
			// log.debug("Caught an exception adding to queue");
		} catch (InterruptedException e) {
			// Error handling by ignoring the problem.
		}
		// wake up getByteFromQueue() if it has invoked wait().
		notify();
	}// end method putByteInQueue()

	// -----------------------------------------------------//

	public synchronized RawSyslog getFromQueue() {
		// This synchronized method removes a message from the queue
		ThreadCategory log = ThreadCategory.getInstance(this.getClass());

		try {
			while (m_backlogQ.isEmpty()) {
				wait();
			}// end while
		} catch (InterruptedException E) {
			log.info("InterruptedException: " + E, E);
		}// end catch block

		// get the byte from the queue

		try {
			ret = m_backlogQ.remove();
		} catch (FifoQueueException e) {
			log.debug("FifoQueue exception " + e);
		} catch (InterruptedException e) {
			log.debug("Interrupted exception " + e);
		}

		// wake up putByteInQueue() if it has invoked wait().
		notify();
		return ret;
	}// end getByteFromQueue()

}
