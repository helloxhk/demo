package com.xhk.activemq_spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * 生产方
 * @author xhk
 * @date 2018年3月2日
 */
public class Provider {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		ActiveMQTopic topic = context.getBean(ActiveMQTopic.class);
		jmsTemplate.send(topic,new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("xxxxxxxxxxxxx");
			}
		});
		System.out.println("------------发送消息成功-----------");
	}

}
