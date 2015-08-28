package com.g04.o2o.tools;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JMSUtil {
	static ConnectionFactory factory = null;
	static Queue queue = null;
	static Connection conn = null;
	static Session session = null;
	static {
		factory = new ActiveMQConnectionFactory(
				"failover://tcp://10.222.29.153:61616");
		try {
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public JMSUtil(String queueName) {
		queue = new ActiveMQQueue(queueName);
	}

	public void sendMsg(String msg) {
		MessageProducer producer = null;
		try {
			producer = session.createProducer(queue);
			TextMessage newmsg = session.createTextMessage(msg);
			producer.send(newmsg);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (producer != null) {
					producer.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> receiveMsg() {
		MessageConsumer consumer = null;
		List<String> list = new ArrayList<String>();
		try {
			consumer = session.createConsumer(queue);
			conn.start();
			Message msg = null;
			while ((msg = consumer.receive(200)) != null) {
				TextMessage tmsg = (TextMessage) msg;
				String str = tmsg.getText();
				list.add(str);
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (consumer != null) {
					consumer.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void free() {
		try {
			if (session != null) {
				session.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
