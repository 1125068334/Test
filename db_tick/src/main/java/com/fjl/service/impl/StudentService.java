package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.GradeMapper;
import com.fjl.dao.StudentMapper;
import com.fjl.entity.Grade;
import com.fjl.entity.Student;
import com.fjl.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentMapper stuDao;
	@Autowired
	private GradeMapper gradeDao;

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long count = 0;
		
		try {
			count = stuDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<Map<String, Object>> showStu() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		List<Map<String, Object>> list1 = new ArrayList<>();

		try {
			list = stuDao.findStu();
			for (Student stu : list) {
				Map<String, Object> map = new HashMap<>();

				Integer gid = stu.getGid();
				
				Grade grade = null;
				
				String name = null;
				if (-1 == gid || null == gid) {
					grade = null;
					name = null;
				} else {
					grade = gradeDao.findById(gid);
					name = grade.getName();
				}
				map.put("gname", name);

				map.put("no", stu.getNo());
				map.put("name", stu.getName());
				map.put("sex", stu.getSex());
				map.put("phone", stu.getPhone());
				map.put("email", stu.getEmail());
				map.put("school", stu.getSchool());
				map.put("education", stu.getEducation());
				map.put("birthday", stu.getBirthday());
				map.put("createdate", stu.getCreatedate());

				list1.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list1;
	}

	@Override
	public void addStu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String no = (String) map.get("no");
		if (stuDao.findStuByNo(no) != null) {
			throw new RuntimeException("重复学号不能添加");
		}
		try {
			stuDao.addStu(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("添加学生失败");
		}
	}
	
	@Override
	public void delete(String no) {
		// TODO Auto-generated method stub
		if(no == null) {
			throw new RuntimeException("学号为空");
		}
		try {
			stuDao.delete(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除失败");
		}
	}

}
