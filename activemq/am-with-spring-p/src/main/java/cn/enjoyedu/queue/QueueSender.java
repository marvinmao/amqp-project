package cn.enjoyedu.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

/**
 *@author Marvin
 *
 *类说明：queue模式发送
 */
@Component("queueSender")
public class QueueSender {

	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	private GetResponse getResponse;

	public void send(String queueName,final String message){
/*		jmsTemplate.send(queueName, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(message);

				//配置消费者应答相关内容
				Destination tempDest = session.createTemporaryQueue();
				MessageConsumer responseConsumer = session.createConsumer(tempDest);
				responseConsumer.setMessageListener(getResponse);
				msg.setJMSReplyTo(tempDest);
				//消费者应答的id，发送出的消息和应答消息进行匹配
				String uid = System.currentTimeMillis()+"";
				msg.setJMSCorrelationID(uid);

				return msg;
			}
		});*/

		//发送MapMessage
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage map = session.createMapMessage();
                map.setString("id", "10000");
                map.setString("name", "享学学员");
                return map;
            }
        });

		/*发送ObjectMessage，被发送的实体类必须实现Serializable 接口
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	User user = new User(10000,"享学学员");
                ObjectMessage objectMessage
                 = session.createObjectMessage(user);
                return objectMessage;
            }
        });
		* */

		/*发送BytesMessage
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes("BytesMessage类型消息".getBytes());
                return bytesMessage;
            }
        });
		* */

		/*发送StreamMessage
        jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                StreamMessage streamMessage = session.createStreamMessage();
                streamMessage.writeString("享学学员");
                streamMessage.writeInt(10000);
                return streamMessage;
            }
        });
		* */
	}
	

}
