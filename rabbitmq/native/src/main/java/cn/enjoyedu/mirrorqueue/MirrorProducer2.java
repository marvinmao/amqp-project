package cn.enjoyedu.mirrorqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *@author Marvin
 *
 *类说明：direct类型交换器的生产者
 */
public class MirrorProducer2 {

    public final static String EXCHANGE_NAME = "mirror_queue_test";

    public static void main(String[] args)
            throws IOException, TimeoutException {
        /* 创建连接,连接到RabbitMQ*/
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.56.102");
        connectionFactory.setVirtualHost("enjoyedu");
        connectionFactory.setUsername("mark");
        connectionFactory.setPassword("123456");
        Connection connection = connectionFactory.newConnection();

        /*创建信道*/
        Channel channel = connection.createChannel();
        /*创建交换器*/
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //channel.exchangeDeclare(EXCHANGE_NAME,BuiltinExchangeType.DIRECT);

        /*日志消息级别，作为路由键使用*/
        String[] serverities = {"error","info","warning"};
        for(int i=0;i<10000;i++){
            String severity = serverities[i%3];
            String msg = "Hellol,RabbitMq"+(i+1);
            /*发布消息，需要参数：交换器，路由键，其中以日志消息级别为路由键*/
            channel.basicPublish(EXCHANGE_NAME,severity,null,
                    msg.getBytes());
            System.out.println("Sent "+severity+":"+msg);

        }
        channel.close();
        connection.close();

    }

}
