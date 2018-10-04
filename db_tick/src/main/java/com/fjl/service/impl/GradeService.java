package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.CourseMapper;
import com.fjl.dao.GradeMapper;
import com.fjl.dao.StudentMapper;
import com.fjl.entity.Grade;
import com.fjl.service.IGradeService;
@Service
public class GradeService implements IGradeService {

	@Autowired
	private GradeMapper gradeDao;
	@Autowired
	private CourseMapper courseDao;
	@Autowired
	private StudentMapper stuDao;
	
	
	@Override
	public List<Map<String, Object>> showGrade() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = new ArrayList<>();
		List<Grade> list1 = new ArrayList<>();
		
		try {
			list1 = gradeDao.showGrade();
			for (Grade grade : list1) {
				Map<String,Object> map = new HashMap<>();
				map.put("id", grade.getId());
				map.put("name", grade.getName());
				map.put("cname", courseDao.findName(grade.getId()));
				map.put("count", stuDao.findGradeStu(grade.getId()));
				map.put("week", grade.getWeek());
				map.put("location", grade.getLocation());
				map.put("createdate", grade.getCreatedate());
				
				list.add(map);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Grade> gradeAll() {
		// TODO Auto-generated method stub
		
		List<Grade> list = new ArrayList<>();
		
		try {
			list = gradeDao.showGrade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addGrade(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String name = (String) map.get("name");
		if(gradeDao.findByName(name) != null) {
			throw new RuntimeException("存在同名班级不能添加");
		}
		try {
			gradeDao.addGrade(map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加班级失败");
		}
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count= gradeDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}
	
	@Override
	public void updateGrade(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		try {
			gradeDao.updateGrade(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("班级信息修改失败");
		}
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		if(-1 == id || id.equals(null)) {
			throw new RuntimeException("id为空");
		}
		try {
			gradeDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	
	
	
	
}
