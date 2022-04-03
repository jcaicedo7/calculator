package com.appgate.calculator.service.impl;

import java.util.UUID;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.appgate.calculator.service.ICalculateService;

@Service
public class CalculateServiceImpl implements ICalculateService{
	@Autowired
    private RedisTemplate<String, String> valuesTemplate;

	private static final String REDIS_PREFIX_VALUES = "values";
	private static final String REDIS_KEYS_SEPARATOR = ":";	

	public void save(String id) {
		getValueOperations().set(getRedisKey(id), "");
	}
	
	public void update(String id,String values)  throws NotFoundException{
		findById(id);
		getValueOperations().set(getRedisKey(id), values);		
	}
	
	public void delete(String id) {
		if(!valuesTemplate.delete(getRedisKey(UUID.fromString(id).toString()))) {
			throw new NotFoundException("Identificador no existe en BD");
		}
	}
	
	public String findById(final String id) throws NotFoundException {
		final String values = getValueOperations().get(getRedisKey(UUID.fromString(id).toString()));
		if(values == null) {
			throw new NotFoundException("User does not exist in the DB");
		}
		return values;
	}
	
	private String getRedisKey(final String id) {
        return REDIS_PREFIX_VALUES + REDIS_KEYS_SEPARATOR + id;
    }

	private ValueOperations<String, String> getValueOperations() {
		return valuesTemplate.opsForValue();
	}	
}
