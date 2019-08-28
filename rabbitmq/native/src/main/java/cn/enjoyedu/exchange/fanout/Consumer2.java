package cn.enjoyedu.exchange.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@author Marvin
 *
 *类说明：存放到延迟队列的元素，对业务数据进行了包装
 */
public class Consumer2 {

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");


        // 打开连接和创建频道，与发送端一样
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.exchangeDeclare(FanoutProducer.EXCHANGE_NAME,
                BuiltinExchangeType.FANOUT);
        // 声明一个随机队列
        String queueName = channel.queueDeclare().getQueue();

        //只关注error级别的日志，然后记录到文件中去
        //只关注error级别的日志，然后记录到文件中去。
        String severity="test";
        channel.queueBind(queueName, FanoutProducer.EXCHANGE_NAME,
                severity);

        System.out.println(" [*] Waiting for messages......");

        // 创建队列消费者
        final Consumer consumerB = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                //记录日志到文件：
                System.out.println( "Received ["+ envelope.getRoutingKey()
                        + "] "+message);
            }
        };
        channel.basicConsume(queueName, true, consumerB);
    }

}
