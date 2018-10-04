package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.StaffMapper;
import com.fjl.entity.Staff;
import com.fjl.service.IStaffService;

@Service
public class StaffService implements IStaffService {
	
	@Autowired
	private StaffMapper staffDao;
	
	@Override
	public List<Object> findAllStaff() {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<>();
		try {
			list = staffDao.findAllStaff();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Staff> staffAll() {
		// TODO Auto-generated method stub
		List<Staff> list = new ArrayList<>();
		
		try {
			list = staffDao.staffall();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void addStaff(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String no = (String) map.get("no");
		if(staffDao.findByNo(no) != null) {
			throw new RuntimeException("该工号已存在");
		}
		
		try {
			staffDao.addStaff(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		
		try {
			count = staffDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}

	@Override
	public void update(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			staffDao.updateStaff(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改员工信息失败");
		}
	}
	
	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		
		try {
			staffDao.delete(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}
	}
}
