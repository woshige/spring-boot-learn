package com.qianxin.config;

import com.qianxin.pojo.User;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * SimpleKeyGenerator 当不使用key的时候，使用此类来生成key
 * 但是存在两个方法的方法的参数一样，可以自己自定义这样的一个key生成器
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder builder = new StringBuilder();
                if (o == null) {
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

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(new ConcurrentMapCache("simpleCache")));
        return manager;
    }
}
