package com.fjl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.service.IProcessService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class ProcessController {
	
	@Autowired
	private IProcessService processService;
	
	@RequestMapping("/prolist")
	@ResponseBody
	public JsonBean processList() {
		JsonBean bean = new JsonBean();
		List<Map<String,Object>> list = new ArrayList<>();
		long count = 0;
		try {
			list = processService.showAllCheck();
			count = processService.count();
			bean.setCode(0);
			bean.setCount(count);
			bean.setData(list);
			bean.setMsg("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping("/addProcess")
	@ResponseBody
	public JsonBean processAdd(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			processService.addProcess(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
		
	}
	
	
	
	
}
