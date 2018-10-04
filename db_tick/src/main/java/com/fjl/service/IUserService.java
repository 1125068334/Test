package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Role;
import com.fjl.entity.User;

public interface IUserService {
	
	public User LoginUser(String no,String password);
	
	public List<Map<String, Object>> userList(Map<String,Object> map);
	
	public List<Role> findRoles();
	
	public User findByNo(String no);
	
	public List<Map<String, Object>> showMenu(String no);
	
	public void deleteUserById(Integer id);
	
	public long countAll();
	
	public long countSearch(Map<String,Object> map);
}
