package com.example.RedisDataInfluxDump.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

}

//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//    private static final String REDIS_HOST = "localhost";
//    private static final int REDIS_PORT = 6379;
//
//    public StringRedisTemplate createRedisTemplate() {
//        StringRedisTemplate redisTemplate = new StringRedisTemplate();
//        redisTemplate.setConnectionFactory(new LettuceConnectionFactory(REDIS_HOST, REDIS_PORT));
//        return redisTemplate;
//    }

