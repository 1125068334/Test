package com.fjl.dao;

import java.util.List;

import com.fjl.entity.LoginLog;

public interface LoginLogMapper {
    
	public List<LoginLog> findAllLogByNo(String no);
	
	public void addLog(LoginLog loginLog);
}