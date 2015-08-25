package com.frasierding.jmsDemo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc-servlet.xml");
//		ctx.refresh();
		JmsTemplate template = ctx.getBean("jmsTemplate",JmsTemplate.class);
		for(int i=0;i<5;i++){
			template.send(new MessageCreator() {
				
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage("hello this is the msg send to server");
				}
			});
			System.out.println("发送消息");
		}
		
		System.out.println("successful");
	}
}
