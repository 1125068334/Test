package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Check;

public interface CheckMapper {
   
	public List<Check> findAllCheck();
	
	public void addCheck(Map<String,Object> map); 
	
	public long count();
}