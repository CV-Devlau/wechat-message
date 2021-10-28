package com.lau.wechatmessage.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.lau.wechatmessage.entity.Config;
import com.lau.wechatmessage.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * <p>
 *
 * </p>
 *
 * @author lau
 * @since 2021/10/27
 */
@Component
public class ScheduledMessage {

    @Autowired
    Config config;
    static String access_token ;
    static Long expiresIn = System.currentTimeMillis();

    @Scheduled(cron = "0 0 23 * * ? ")
    public void goodNight(){
        long now = System.currentTimeMillis();
        extracted(now);

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm:ss");
        String time = sdf.format(now);

        String json="{\n" +
                "    \"touser\": \""+ config.getTouser()+"\",\n" +
                "    \"template_id\": \"jBn3d5BnGzEpnwGfs8bfBhYufJcJAVfpe8m_tC5QTrQ\",\n" +
                "    \"topcolor\": \"#FF0000\",\n" +
                "    \"data\": {\n" +
                "        \"dateTime\": {\n" +
                "            \"value\": \""+time+"\",\n" +
                "            \"color\": \"#173177\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        // 发送新消息

        String post = HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token, json);
        System.out.println(post);

    }


    private void extracted(long now) {
        if(access_token == null || expiresIn > now){
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("grant_type", "client_credential");
            paramMap.put("appid",config.getAppid());
            paramMap.put("secret",config.getSecret());
            // 获取 token
            String res = HttpUtil.get("https://api.weixin.qq.com/cgi-bin/token", paramMap);
            System.out.println(res);
            access_token = (String) JSONUtil.parseObj(res).get("access_token");
            expiresIn = (int) JSONUtil.parseObj(res).get("expires_in") + now * 1000 -3000;
            System.out.println(access_token);
            System.out.println(expiresIn);
        }
    }

    @Scheduled(cron = "0 0 7 * * ? ")
    public void morning(){
        long now = System.currentTimeMillis();
        extracted(now);

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 hh:mm:ss");
        String time = sdf.format(now);

        HashMap<String, Object> map = new HashMap<>();
        map.put("touser",config.getTouser());
        map.put("template_id","vXYGLvrY3vQv5Bt6ow96WyfNouwcLqtGCLGg6OwxcRc");
        map.put("topcolor","#FF0000");


        HashMap<String, Object> data = new HashMap<>();
        long birthay = getBirthay();
        JSONObject weather = getWeather();
        JSONObject message = getMessage();
        map.put("data",data);
        data.put("dateTime",new Data(time,"#173177"));
        data.put("love",new Data(String.valueOf(getLove()),"#cc33cc"));
        data.put("birthday",new Data(String.valueOf(birthay),"#91C34B"));
        data.put("wea",new Data(weather.getStr("wea"),"#40BFBF"));
        data.put("tem",new Data(weather.getStr("tem"), "#0066ff"));
        data.put("tem1",new Data(weather.getStr("tem_day"), "#ff0033"));
        data.put("tem2",new Data(weather.getStr("tem_night"), "6ECFB8"));
        data.put("airLevel",new Data(weather.getStr("air"), "#ff0000"));
        data.put("win",new Data(weather.getStr("win"), "#858AD6"));
        data.put("message",new Data(message.getStr("hitokoto"),"#8C8C8C"));

        String jsonStr = JSONUtil.toJsonStr(map);
        String post = HttpUtil.post("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token, jsonStr);
        System.out.println(post);

    }

     public JSONObject getWeather(){
         HashMap<String, Object> data = new HashMap<>();
         data.put("appid",config.getWeaAppid());
         data.put("appsecret",config.getWeaAppsecret());
         data.put("unescape",1);
         data.put("city",config.getCity());

         String resp = HttpUtil.get("https://www.tianqiapi.com/free/day", data);

         return JSONUtil.parseObj(resp);

     }

     public JSONObject getMessage(){
         String s = HttpUtil.get("https://v1.hitokoto.cn/");
         return JSONUtil.parseObj(s);
     }

     public long getLove(){
         LocalDateTime time = LocalDateTime.of(2019, 1, 4, 0, 0);
         Duration duration = Duration.between(time, LocalDateTime.now());
         return duration.toDays();
     }

     public long getBirthay(){
         LocalDateTime now = LocalDateTime.now();
         LocalDateTime time = LocalDateTime.of(2001,9,26,0,0);
         int year = now.getYear();
         if(now.getDayOfYear()>time.getDayOfYear()){
             year++;
         }
         LocalDateTime nextBirthday = LocalDateTime.of(year, 9, 26, 0, 0);
         Duration duration = Duration.between(now, nextBirthday);
         return duration.toDays();
     }


}
