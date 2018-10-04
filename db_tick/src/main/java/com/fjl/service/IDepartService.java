package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Depart;

public interface IDepartService {
	
	public List<Map<String,Object>> departList();
	
	public void add(Map<String,Object> map);
	
	public List<Depart> departAll();
	
	public void update(Map<String,Object> map);
	
	public long count();
}
