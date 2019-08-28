package cn.enjoyedu.topic;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *@author Marvin
 *
 *类说明：
 */
@Component
public class TopicReceiver1 implements MessageListener {


	public void onMessage(Message message) {
		try {
			String textMsg = ((TextMessage)message).getText();
			System.out.println("TopicReceiver1 accept msg : "+textMsg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
