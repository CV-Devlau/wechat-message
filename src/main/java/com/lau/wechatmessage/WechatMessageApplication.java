package com.lau.wechatmessage;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;

@EnableScheduling
@SpringBootApplication
public class WechatMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatMessageApplication.class, args);


    }

}
