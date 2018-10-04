package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.DepartMapper;
import com.fjl.dao.StaffMapper;
import com.fjl.entity.Depart;
import com.fjl.service.IDepartService;

@Service
public class DepartService implements IDepartService {

	@Autowired
	private DepartMapper departDao;
	
	@Autowired
	private StaffMapper staffDao;

	@Override
	public List<Map<String,Object>> departList() {
		// TODO Auto-generated method stub
		
		List<Depart> list = new ArrayList<>();
		List<Map<String, Object>> list1 = new ArrayList<>();
		
		list = departDao.departList();
		
		for (Depart dp : list) {
			Map<String,Object> map = new HashMap<>();
			String name = dp.getName();
			map.put("id", dp.getId());
			map.put("name", dp.getName());
			map.put("createtime", dp.getCreatetime());
			
			long num = staffDao.findDepartStaff(name);
			map.put("dcount", num);
			
			list1.add(map);
		}
		return list1;
	}
	
	@Override
	public void add(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			departDao.add(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加部门失败");
		}
	}
	
	@Override
	public List<Depart> departAll() {
		// TODO Auto-generated method stub
		List<Depart> list = new ArrayList<>();
		
		try {
			list = departDao.departList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return list;
	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			departDao.updateDepart(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改员工失败");
		}
	}
	
	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = departDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询数量失败");
		}
		return count;
	}
}
