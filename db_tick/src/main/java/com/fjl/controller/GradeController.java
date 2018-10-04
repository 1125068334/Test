package com.fjl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.entity.Grade;
import com.fjl.service.IGradeService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class GradeController {
	
	@Autowired
	private IGradeService gradeService;
	
	@RequestMapping("/gradepage")
	@ResponseBody
	public JsonBean showGrade() {
		JsonBean bean = new JsonBean();
		List<Map<String,Object>> list = new ArrayList<>();
		long count = 0;
		try {
			list = gradeService.showGrade();
			count = gradeService.count();
			bean.setCode(0);
			bean.setCount(count);
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/gradeall")
	@ResponseBody
	public JsonBean gradeAll() {
		JsonBean bean = new JsonBean();
		
		List<Grade> list = new ArrayList<>();
		
		try {
			list = gradeService.gradeAll();
			bean.setData(list);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/addGrade")
	@ResponseBody
	public JsonBean addGrade(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		try {
			gradeService.addGrade(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/updateGrade")
	@ResponseBody
	public JsonBean updateGrade(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		try {
			gradeService.updateGrade(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/gradedelete")
	@ResponseBody
	public JsonBean gradedelete(Integer id) {
		JsonBean bean = new JsonBean();
		
		try {
			gradeService.delete(id);
			bean.setCode(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
}
