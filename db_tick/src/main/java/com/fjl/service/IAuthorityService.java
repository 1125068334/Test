package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Authority;

public interface IAuthorityService {
	
	public List<Authority> findByName(String name);
	
	public List<Authority> findByParentid(int parentid);
	
	public List<Map<String,Object>> findByParentid1(int parentid);
	
	public List<String> findTitleByParentid(int parentid);
	
	public List<Integer> findIdByParentid(int parentid);
	
	public List<Authority> findAuListByNo(Map<String,Object> map);
	
	public long countByNo(Map<String,Object> map);
	
}
