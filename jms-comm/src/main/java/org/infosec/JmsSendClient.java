package org.infosec;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JmsSendClient {

	private Destination destination;
    private int messageCount = 10;
    private long sleepTime;
    private boolean verbose = true;
    private int messageSize = 255;
    private long timeToLive;
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String subject = "TOOL.DEFAULT";
    private boolean topic = true;
    private boolean transacted;
    private boolean persistent;

    public static void main(String[] args) {
    	JmsSendClient client = new JmsSendClient();
    	client.run();
    }
    public void run() {
        Connection connection = null;
        try {
            System.out.println("Connecting to URL: " + url);
            System.out.println("Publishing a Message with size " + messageSize + " to " + (topic ? "topic" : "queue") + ": " + subject);
            System.out.println("Using " + (persistent ? "persistent" : "non-persistent") + " messages");
            System.out.println("Sleeping between publish " + sleepTime + " ms");
            if (timeToLive != 0) {
                System.out.println("Messages time to live " + timeToLive + " ms");
            }

            // Create the connection.
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();
//
            // Create the session
            Session session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
            if (topic) {
                destination = session.createTopic(subject);
            } else {
                destination = session.createQueue(subject);
            }
//
            // Create the producer.
            MessageProducer producer = session.createProducer(destination);
            if (persistent) {
                producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            } else {
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            }
            if (timeToLive != 0) {
                producer.setTimeToLive(timeToLive);
            }

            // Start sending messages
            sendLoop(session, producer);

            System.out.println("Done.");

//            // Use the ActiveMQConnection interface to dump the connection
//            // stats.
//            ActiveMQConnection c = (ActiveMQConnection)connection;
//            c.getConnectionStats().dump(new IndentPrinter());
//
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Throwable ignore) {
            }
        }
    }

    protected void sendLoop(Session session, MessageProducer producer) throws Exception {

        for (int i = 0; i < messageCount || messageCount == 0; i++) {

            TextMessage message = session.createTextMessage(createMessageText(i));


            if (verbose) {
                String msg = message.getText();
                if (msg.length() > 50) {
                    msg = msg.substring(0, 50) + "...";
                }
                System.out.println("Sending message: " + msg);
            }

            producer.send(message);
            if (transacted) {
                session.commit();
            }

            Thread.sleep(sleepTime);

        }

    }

    private String createMessageText(int index) {
        StringBuffer buffer = new StringBuffer(messageSize);
//        buffer.append("Message: " + index + " sent at: " + new Date());
//        //<syslog id="" name="" severity=""/>
//         
//        if (buffer.length() > messageSize) {
//            return buffer.substring(0, messageSize);
//        }
//        for (int i = buffer.length(); i < messageSize; i++) {
//            buffer.append(' ');
//        }
        buffer.append("<syslog index=\""+index);
        buffer.append("\" message=\"test\"");
        buffer.append(" />");
        return buffer.toString();
    }

    

}
