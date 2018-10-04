package com.fjl.service;

import java.util.List;
import java.util.Map;

public interface IProcessService {
	
	public List<Map<String,Object>> showAllCheck();
	
	public void addProcess(Map<String,Object> map);
	
	public long count();
}
