package com.lau.wechatmessage.entity;

/**
 * <p>
 *
 * </p>
 *
 * @author lau
 * @since 2021/10/28
 */

public class Data {
    public String getValue() {
        return value;
    }

    public Data(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public Data() {
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String value;
    private String color;
}
