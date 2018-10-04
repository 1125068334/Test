package com.fjl.service;

import java.util.List;
import java.util.Map;

import com.fjl.entity.LoginLog;

public interface ILoginLogService {
	
	public List<Map<String,Object>> showLog(String no);
	
	public void addLoginLog(LoginLog loginLog);
}
