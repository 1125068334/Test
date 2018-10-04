package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Grade;

public interface GradeMapper {
    
	public List<Grade> showGrade();
	
	public Grade findById(int id);
	
	public Grade findByName(String name);
	
	public void addGrade(Map<String, Object> map);
	
	public long count();
	
	public void updateGrade(Map<String,Object> map);
	
	public void delete(Integer id);
	
}