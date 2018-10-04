package com.fjl.dao;

import com.fjl.entity.RoleAuthorityKey;

public interface RoleAuthorityMapper {
    int deleteByPrimaryKey(RoleAuthorityKey key);

    int insert(RoleAuthorityKey record);

    int insertSelective(RoleAuthorityKey record);
}