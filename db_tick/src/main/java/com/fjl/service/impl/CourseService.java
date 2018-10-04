package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.CourseMapper;
import com.fjl.entity.Course;
import com.fjl.service.ICourseService;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private CourseMapper courseDao;

	@Override
	public List<Map<String, Object>> showCourse() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		List<Course> list1 = new ArrayList<>();

		try {
			list1 = courseDao.courseList();

			for (Course c : list1) {
				Map<String, Object> map = new HashMap<>();

				map.put("id", c.getId());
				map.put("name", c.getName());
				map.put("week", c.getWeek());
				map.put("createdate", c.getCreatedate());
				map.put("type", c.getType());

				list.add(map);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Course> courseAll() {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<>();

		try {
			list = courseDao.courseList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return list;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = courseDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return count;
	}

	@Override
	public void addCourse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String name = (String) map.get("name");
		if (courseDao.findByName(name) != null) {
			throw new RuntimeException("存在同名课程");
		}
		try {
			courseDao.addCourse(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	
	@Override
	public void updateCourse(Map<String, Object> map) {
		// TODO Auto-generated method stub
		if(map == null) {
			throw new RuntimeException("数据为空");
		}
		try {
			courseDao.updateById(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		if(id == null) {
			throw new RuntimeException("id不能为空");
		}
		try {
			courseDao.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
}
