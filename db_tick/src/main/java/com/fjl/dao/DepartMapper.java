package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Depart;


public interface DepartMapper {
   
	public List<Depart> departList();
	
	public void add(Map<String,Object> map);
	
	public void updateDepart(Map<String, Object> map);
	
	public long count();
	
}