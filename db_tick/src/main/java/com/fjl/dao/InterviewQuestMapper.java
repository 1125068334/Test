package com.fjl.dao;

import com.fjl.entity.InterviewQuest;

public interface InterviewQuestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InterviewQuest record);

    int insertSelective(InterviewQuest record);

    InterviewQuest selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InterviewQuest record);

    int updateByPrimaryKeyWithBLOBs(InterviewQuest record);

    int updateByPrimaryKey(InterviewQuest record);
}