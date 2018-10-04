package com.fjl.dao;

import com.fjl.entity.UserRoleKey;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
    
    public void deleteByUid(Integer uid);
}