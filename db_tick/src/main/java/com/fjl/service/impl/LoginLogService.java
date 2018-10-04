package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.LoginLogMapper;
import com.fjl.entity.LoginLog;
import com.fjl.service.ILoginLogService;

@Service
public class LoginLogService implements ILoginLogService {
	
	@Autowired
	private LoginLogMapper loginLogDao;
	
	@Override
	public List<Map<String, Object>> showLog(String no) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		List<LoginLog> list1 = new ArrayList<>();
		
		try {
			list1 = loginLogDao.findAllLogByNo(no);
			for (LoginLog log : list1) {
				Map<String,Object> map = new HashMap<>();
				
				map.put("no", no);
				map.put("ip", log.getIp());
				map.put("location", log.getLocation());
				map.put("createtime", log.getCreatetime());
				
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void addLoginLog(LoginLog loginLog) {
		// TODO Auto-generated method stub
		if(loginLog == null) {
			throw new RuntimeException("数据为空");
		}
		try {
			loginLogDao.addLog(loginLog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
