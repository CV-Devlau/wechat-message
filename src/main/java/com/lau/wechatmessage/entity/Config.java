package com.lau.wechatmessage.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author lau
 * @since 2021/10/28
 */
@Component
@ConfigurationProperties(prefix = "send")
public class Config {

    /**
     * 微信appid
     */
    private String appid;

    /**
     * 微信appSecret
     */
    private String secret;

    /**
     * 发送用户
     */
    private String touser;

    /**
     * 天气接口
     */
    private String weaAppid;
    private String weaAppsecret;
    /**
     * 城市名
     */
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeaAppid() {
        return weaAppid;
    }

    public void setWeaAppid(String weaAppid) {
        this.weaAppid = weaAppid;
    }

    public String getWeaAppsecret() {
        return weaAppsecret;
    }

    public void setWeaAppsecret(String weaAppsecret) {
        this.weaAppsecret = weaAppsecret;
    }



    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }
}
