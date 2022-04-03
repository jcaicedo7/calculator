package com.appgate.calculator.service;

import javax.ws.rs.NotFoundException;
public interface ICalculateService {
	public void save(String id);
	public void update(String id,String values) throws NotFoundException;
	public void delete(String id);
	public String findById(String id) throws NotFoundException;
}
