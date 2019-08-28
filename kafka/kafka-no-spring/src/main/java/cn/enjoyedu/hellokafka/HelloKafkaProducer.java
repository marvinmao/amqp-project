package cn.enjoyedu.hellokafka;

import cn.enjoyedu.config.BusiConst;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author Marvin
 *
 * 类说明：kafak生产者
 */
public class HelloKafkaProducer {

    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("bootstrap.servers","127.0.0.1:9092");
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String,String> producer
                = new KafkaProducer<String, String>(properties);
        try {
            ProducerRecord<String,String> record;
            try {
                record = new ProducerRecord<String,String>(BusiConst.HELLO_TOPIC,
                        "teacher02","lison");
                producer.send(record);
                System.out.println("message is sent.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            producer.close();
        }
    }


}
