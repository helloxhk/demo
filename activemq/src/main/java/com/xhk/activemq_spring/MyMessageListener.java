package com.xhk.activemq_spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 消息监听器
 * @author xhk
 * @date 2018年3月2日
 */
@Component("messageListener")
public class MyMessageListener implements MessageListener {

	public void onMessage(Message message) {
		if(message instanceof TextMessage){
			try {
				System.out.println(((TextMessage) message).getText() + "11111111111");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
