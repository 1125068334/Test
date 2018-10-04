package com.fjl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.entity.Course;
import com.fjl.service.ICourseService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class CourseController {

	@Autowired
	private ICourseService cService;
	
	@RequestMapping("/courseList")
	@ResponseBody
	public JsonBean courserList() {
		JsonBean bean = new JsonBean();
		List<Map<String,Object>> list = new ArrayList<>();
		long count = 0;
		try {
			list = cService.showCourse();
			count = cService.count();
			bean.setCode(0);
			bean.setCount(count);
			bean.setData(list);
			bean.setMsg("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/courseall")
	@ResponseBody
	public JsonBean couserAll() {
		JsonBean bean = new JsonBean();
		List<Course> list = new ArrayList<>();
		try {
			list = cService.courseAll();
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	@RequestMapping("/addCourse")
	@ResponseBody
	public JsonBean addCourse(@RequestParam Map<String, Object> map) {
		JsonBean bean = new JsonBean();
		try {
			cService.addCourse(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/updateCourse")
	@ResponseBody
	public JsonBean updateCourse(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			cService.updateCourse(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/deleteCourse")
	@ResponseBody
	public JsonBean deleteCourse(Integer id) {
		JsonBean bean = new JsonBean();
		
		try {
			cService.deleteById(id);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
}
