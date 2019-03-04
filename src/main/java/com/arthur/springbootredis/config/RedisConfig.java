package com.arthur.springbootredis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        JedisConnectionFactory jedisConnectionFactory = null;

        try {
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setDatabase(0);
            redisStandaloneConfiguration.setHostName("localhost");
            redisStandaloneConfiguration.setPort(6379);

            jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);

            jedisConnectionFactory.getPoolConfig().setMaxTotal(50);
            jedisConnectionFactory.getPoolConfig().setMaxIdle(50);
        } catch (RedisConnectionFailureException e) {
            e.getMessage();
        }

        return jedisConnectionFactory;
    }


    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setEnableTransactionSupport(true);

        return template;
    }
}