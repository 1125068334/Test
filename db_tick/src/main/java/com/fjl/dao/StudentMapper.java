package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Student;

public interface StudentMapper {
   
	public long findGradeStu(int id);
	
	public List<Student> findStu();
	
	public void addStu(Map<String,Object> map);
	
	public Student findStuByNo(String no);
	
	public long count();
	
	public void delete(String no);
	
}