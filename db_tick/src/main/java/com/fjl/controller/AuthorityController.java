package com.fjl.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.entity.Authority;
import com.fjl.service.IAuthorityService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class AuthorityController {

	@Autowired
	private IAuthorityService authorityService;

	@RequestMapping(value = "/showAuList", method = RequestMethod.GET)
	@ResponseBody
	public JsonBean showAll(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		String no = (String) SecurityUtils.getSubject().getPrincipal();
		map.put("no", no);
		List<Authority> list = new ArrayList<>();
		long count = 0;
		try {
			list = authorityService.findAuListByNo(map);
			count = authorityService.countByNo(map);
			bean.setCode(0);
			bean.setCount(count);
			bean.setData(list);
			bean.setMsg("");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(1);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
}
