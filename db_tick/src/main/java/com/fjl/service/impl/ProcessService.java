package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.CheckMapper;
import com.fjl.entity.Check;
import com.fjl.service.IProcessService;
@Service
public class ProcessService implements IProcessService {

	@Autowired
	private CheckMapper checkDao;
	
	@Override
	public List<Map<String, Object>> showAllCheck() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		List<Check> list1 = new ArrayList<>();
		
		try {
			list1 = checkDao.findAllCheck();
			for (Check check : list1) {
				Map<String,Object> map = new HashMap<>();
				map.put("id", check.getId());
				map.put("startname", check.getStartname());
				map.put("type", check.getType());
				map.put("startDate", check.getStartdate());
				map.put("endDate", check.getEnddate());
				map.put("days", check.getDays());
				map.put("pid", check.getPid());
				map.put("flag", check.getFlag());
						
				list.add(map);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void addProcess(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			checkDao.addCheck(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		
		try {
			count = checkDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}
}
