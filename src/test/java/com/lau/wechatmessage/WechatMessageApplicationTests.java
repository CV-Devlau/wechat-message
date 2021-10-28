package com.lau.wechatmessage;

import com.lau.wechatmessage.service.ScheduledMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WechatMessageApplicationTests {

    @Autowired
    ScheduledMessage scheduledMessage;
    @Test
    void contextLoads() {

        scheduledMessage.goodNight();
    }

}
