package com.qianxin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 利用配置文件的属性进行配置
 */
@Component
public class Config {
    @Value("${config.url}")
    private String url;
    @Value("${config.maxNum}")
    private Integer maxNum;

    @Override
    public String toString() {
        return "Config{" +
                "url='" + url + '\'' +
                ", maxNum=" + maxNum +
                '}';
    }
}
