package cn.enjoyedu;

import cn.enjoyedu.service.KafkaSender;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaWithSpringbootApplicationTests {

    @Autowired
    private KafkaSender kafkaSender;

}
