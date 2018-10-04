package com.fjl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.service.ILoginLogService;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class LoginLogController {

	@Autowired
	private ILoginLogService lService;

	@RequestMapping("/loginloglist")
	@ResponseBody
	public JsonBean loginLog(HttpServletRequest request) {

		JsonBean bean = new JsonBean();
		List<Map<String, Object>> list = new ArrayList<>();
		HttpSession session = request.getSession();

		String no = (String) session.getAttribute("no");
		try {
			list = lService.showLog(no);
			bean.setCode(0);
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
}
