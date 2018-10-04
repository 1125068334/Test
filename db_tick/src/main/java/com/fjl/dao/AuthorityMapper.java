package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Authority;

public interface AuthorityMapper {
   
    public List<Authority> findByName(String name);
    
    public List<String> findRoleByName(String name);
	
	public List<String> findTitleByName(String name);
	
	public List<String> findTitleByParentid(int parentid);
	
	public List<Integer> findIdByParentid(int parentid);
	
	public List<Authority> findByParentid(int parentid);
	
	public List<Authority> findAuByNo(Map<String,Object> map);
	
	public List<Map<String,Object>> findByParentid1(int parentid);
	
	public long countAu(Map<String,Object> map);

	public List<Authority> findAuByNo1(String no);
	
}