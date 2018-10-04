package com.fjl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.entity.Depart;
import com.fjl.service.IDepartService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class DepartController {
	
	@Autowired
	private IDepartService departService;
	
	@RequestMapping("/departList")
	@ResponseBody
	public JsonBean departList() {
		JsonBean bean = new JsonBean();
		List<Map<String,Object>> list = new ArrayList<>();
		
		try {
			list = departService.departList();
			long count = departService.count();
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
	
	@RequestMapping("/addDepart")
	@ResponseBody
	public JsonBean departAdd(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			departService.add(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/departall")
	@ResponseBody
	public JsonBean selectDepart() {
		JsonBean bean = new JsonBean();
		List<Depart> list = new ArrayList<>();
		try {
			list = departService.departAll();
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	@RequestMapping("/updateDepart")
	@ResponseBody
	public JsonBean updateDepart(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			departService.update(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
}
