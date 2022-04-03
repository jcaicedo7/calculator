package com.appgate.calculator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableRedisRepositories
@ComponentScan
@Configuration
public class RedisInitial {

	@Value(value = "${redis.hostname}")
	private String redisHostname;

	@Value(value = "${redis.port}")
	private int redisPort;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostname, redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	public RedisTemplate<String, String> valuesTemplate() {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		return template;
	}	
}
