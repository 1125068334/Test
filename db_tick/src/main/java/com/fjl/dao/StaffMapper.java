package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Staff;

public interface StaffMapper {
   
	public List<Object> findAllStaff();
	
	public long findDepartStaff(String name);
	
	public List<Staff> staffall();
	
	public Staff findByName(String name);
	
	public Staff findByNo(String no);
	
	public void addStaff(Map<String,Object> map);
	
	public long count();
	
	public void updateStaff(Map<String,Object> map);
	
	public void delete(String no);
	
}