package org.infosec.ismp.eventd.processor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.infosec.ismp.model.event.Event;
import org.infosec.ismp.model.event.Header;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;

/**
 * EventWriter loads the information in each 'Event' into the database.
 * TODO:将事件数据写入数据库
 * 
 */
public final class JdbcEventWriter extends AbstractJdbcPersister implements
		EventProcessor, InitializingBean {
	/**
	 * The method that inserts the event into the database
	 * 
	 * @param eventHeader
	 *            the event header
	 * @param event
	 *            the actual event to be inserted
	 */
	@Override
	public void process(Header eventHeader, Event event) throws SQLException,
			DataAccessException {
		if (!checkEventSanityAndDoWeProcess(event, "JdbcEventWriter")) {
			return;
		}

		if (log().isDebugEnabled()) {
			log().debug(
					"JdbcEventWriter: processing " + event.getUei()
							+ " uuid: " + event.getUuid() + " ipaddr: "
							+ event.getIpAddr());
		}

		Connection connection = getDataSource().getConnection();

		try {
			connection.setAutoCommit(false);

			try {
				insertEvent(eventHeader, event, connection);

				connection.commit();
			} catch (SQLException e) {
				log().warn(
						"JdbcEventWriter: Error inserting event into the datastore: "
								+ e, e);
				try {
					connection.rollback();
				} catch (Exception e2) {
					log().warn(
							"JdbcEventWriter: Rollback of transaction failed: "
									+ e2, e2);
				}

				throw e;
			} catch (DataAccessException e) {
				log().warn(
						"JdbcEventWriter: Error inserting event into the datastore: "
								+ e, e);
				try {
					connection.rollback();
				} catch (Exception e2) {
					log().warn(
							"JdbcEventWriter: Rollback of transaction failed: "
									+ e2, e2);
				}

				throw e;
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				log().warn(
						"JdbcEventWriter: SQLException while closing database connection: "
								+ e, e);
			}
		}

		if (log().isDebugEnabled()) {
			log().debug(
					"JdbcEventWriter: EventWriter finished for : "
							+ event.getUei());
		}
	}

	/**
	 * Insert values into the EVENTS table
	 * 
	 * @exception java.sql.SQLException
	 *                Thrown if there is an error adding the event to the
	 *                database.
	 * @exception java.lang.NullPointerException
	 *                Thrown if a required resource cannot be found in the
	 *                properties file.
	 */
	private void insertEvent(Header eventHeader, Event event,
			Connection connection) throws SQLException {
		// Execute the statement to get the next event id
		int eventID = getNextId();

		if (log().isDebugEnabled()) {
			log().debug("EventWriter: DBID: " + eventID);
		}

		try {
			PreparedStatement insStmt = null;
			// TODO
			// connection
			// .prepareStatement(EventdConstants.SQL_DB_INS_EVENT);

			// execute
			insStmt.executeUpdate();
		} finally {
			// TODO
		}

		if (log().isDebugEnabled()) {
			log().debug(
					"SUCCESSFULLY added " + event.getUei()
							+ " related  data into the EVENTS table");
		}
	}

}
