package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Grade;

public interface IGradeService {
	
	public List<Map<String,Object>> showGrade();
	
	public List<Grade> gradeAll();
	
	public void addGrade(Map<String, Object> map);
	
	public long count();
	
	public void updateGrade(Map<String,Object> map);
	
	public void delete(Integer id);
}
