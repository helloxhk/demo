package com.xhk.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

/**
 * 生产方
 * @author xhk
 * @date 2018年3月2日
 */
public class Provider {
	
	public static void main(String[] args) {
		try {
			//ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerURL)
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://172.16.5.74:61616/");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("myqueue");
			MessageProducer producer = session.createProducer(queue);
			TextMessage message = new ActiveMQTextMessage();
			message.setText("value");
			System.out.println("--------------");
			producer.send(message);
			producer.close();
			session.close();
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
