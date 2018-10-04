package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Staff;

public interface IStaffService {
	
	public List<Object> findAllStaff();
	
	public List<Staff> staffAll();
	
	public void addStaff(Map<String,Object> map);
	
	public long count();
	
	public void update(Map<String,Object> map);
	
	public void delete(String no);
}
