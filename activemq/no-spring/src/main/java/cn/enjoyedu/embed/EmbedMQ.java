package cn.enjoyedu.embed;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.jmx.ManagementContext;

/**
 * @author Marvin
 *
 * 类说明：
 */
public class EmbedMQ {
    public static void main(String[] args) throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName("EmbedMQ");
        brokerService.addConnector("tcp://localhost:62000");
        brokerService.setManagementContext(new ManagementContext());
        brokerService.start();
    }
}
