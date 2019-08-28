package cn.enjoyedu.service.busi;

import org.springframework.stereotype.Service;

/**
 *@author Marvin
 *
 *
 *
 *类说明：发送短信的服务
 */
@Service
public class SendSms {

    public void sendSms(String phoneNumber){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-------------Already Send Sms to "+phoneNumber);
    }

}
