package com.fjl.service;

import java.util.List;
import java.util.Map;

public interface IStudentService {
	
	public List<Map<String,Object>> showStu();
	
	public void addStu(Map<String,Object> map);
	
	public long count();
	
	public void delete(String no);
}
