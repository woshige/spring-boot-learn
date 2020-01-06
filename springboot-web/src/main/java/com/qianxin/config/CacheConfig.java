package com.qianxin.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * SimpleKeyGenerator 当不使用key的时候，使用此类来生成key
 * 但是存在两个方法的方法的参数一样，可以自己自定义这样的一个key生成器
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder builder = new StringBuilder();
                if(o == null){
                    throw new RuntimeException("o为空");
                }
                builder.append(o.getClass().getName()).append(method.getName());
                for (Object object : objects) {
                    builder.append(objects.toString());
                }
                return builder.toString();
            }
        };
    }
}
