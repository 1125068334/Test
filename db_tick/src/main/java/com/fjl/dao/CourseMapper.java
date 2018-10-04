package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Course;

public interface CourseMapper {
   
	public List<Course> courseList();
	
	public Course findByName(String name);
	
	public String findName(int id);
	
	public long count();
	
	public void addCourse(Map<String,Object> map);
	
	public void updateById(Map<String,Object> map);
	
	public void delete(Integer id);
	
}