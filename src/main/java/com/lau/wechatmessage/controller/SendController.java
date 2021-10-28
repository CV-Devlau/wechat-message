package com.lau.wechatmessage.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *      发送消息
 * </p>
 *
 * @author lau
 * @since 2021/10/27
 */
@RestController
public class SendController {
    /**
     * 发送消息接口
     * @return
     */
    @PostMapping("send")
    public String sendMessage(){

//        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
//        HashMap<String, Object> paramMap = new HashMap<>();
//        paramMap.put("grant_type", "client_credential");
//        paramMap.put("appid","");
//        paramMap.put("secret","");
//        // 获取 token
//        String res = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token?", paramMap);
//        String access_token = (String) JSONUtil.parseObj(res).get("access_token");
//
//        // 发送新消息
//        HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token,);
        return null;
    }
}
