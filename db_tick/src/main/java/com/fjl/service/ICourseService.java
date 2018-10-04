package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Course;

public interface ICourseService {
	
	public List<Map<String,Object>> showCourse();
	
	public List<Course> courseAll();
	
	public long count();
	
	public void addCourse(Map<String, Object> map);
	
	public void updateCourse(Map<String,Object> map);
	
	public void deleteById(Integer id);
}
