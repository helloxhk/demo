package com.xhk.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费方
 * @author xhk
 * @date 2018年3月2日
 */
public class Consumer {

	public static void main(String[] args) {
		try {
//			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(userName, password, brokerURL)
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin","admin","tcp://172.16.5.74:61616/");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue("myqueue");
			MessageConsumer consumer = session.createConsumer(queue);
			
			
			/*while(true){
				Message message = consumer.receive(1000000);
				if(message != null){
					System.out.println(message);
				} else {
					break;
				}
			}*/
			consumer.setMessageListener(new MessageListener() {
				
				public void onMessage(Message message) {
					String text = "";
					if(message instanceof TextMessage){
						try {
							text = ((TextMessage)message).getText();
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
					System.out.println(text);
				}
			});
			System.in.read();
			
			consumer.close();
			session.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
