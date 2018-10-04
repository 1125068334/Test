package com.fjl.dao;

import com.fjl.entity.Papers;

public interface PapersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Papers record);

    int insertSelective(Papers record);

    Papers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Papers record);

    int updateByPrimaryKey(Papers record);
}