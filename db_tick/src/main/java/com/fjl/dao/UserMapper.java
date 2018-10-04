package com.fjl.dao;

import java.util.List;
import java.util.Map;

import com.fjl.entity.Role;
import com.fjl.entity.User;

public interface UserMapper {
    
    public User findByName(String name);
    
    public User findByNo(String no);
    
    public List<Map<String,Object>> searchUR(Map<String,Object> map); 
   
    public List<Map<String,Object>> findAll(Map<String,Object> map);
    
    public List<Role> findRoles();
    
    public List<Map<String,Object>> findRoleByNo(String no);
    
    public List<String> findTitleByNo(String no);
    
    public void deleteUserById(Integer id);
    
    public long countSearch(Map<String,Object> map);
    
    public long countAll();
}