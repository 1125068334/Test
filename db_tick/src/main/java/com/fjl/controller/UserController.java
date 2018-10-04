package com.fjl.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fjl.entity.LoginLog;
import com.fjl.entity.Role;
import com.fjl.entity.User;
import com.fjl.service.ILoginLogService;
import com.fjl.service.IUserService;
import com.fjl.utils.AddressUtils;
import com.fjl.utils.CheckIp;
import com.fjl.vo.JsonBean;

@RequestMapping("/Ticktack_Office")
@Controller
public class UserController {

	@Autowired
	private ILoginLogService loginLogService;

	@Autowired
	private IUserService userService;

	// 用户登录
	@RequestMapping("/userlogin")
	@ResponseBody
	public JsonBean login(HttpServletRequest request, String no, String password) {
		JsonBean bean = new JsonBean();
		HttpSession session = request.getSession();

		UsernamePasswordToken token = new UsernamePasswordToken(no, password);

		session.setAttribute("no", no);

		Subject subject = SecurityUtils.getSubject();

		LoginLog loginLog = new LoginLog();

		String ipAddr = CheckIp.getIpAddr(request);

		String addresses;
		try {
			addresses = AddressUtils.getAddresses(ipAddr, "UTF-8");
			loginLog.setNo(no);
			loginLog.setIp(ipAddr);
			loginLog.setLocation(addresses);
			loginLog.setCreatetime(new Date());
			System.out.println(addresses);
			loginLogService.addLoginLog(loginLog);

			try {
				subject.login(token);
				bean.setCode(1);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				bean.setCode(0);
				bean.setMsg(e.getMessage());
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bean;
	}

	@RequestMapping("/logout")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		if (session == null) {
			return;
		}

		session.removeAttribute("user");
		// 从定向到index.jsp
		response.sendRedirect("/tick/Ticktack_Office/login.html");
	}

	// 展示用户信息
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	@ResponseBody
	public JsonBean findAllUR(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		List<Map<String, Object>> list = new ArrayList<>();
		long count = 0;
		try {
			list = userService.userList(map);
			if(map.get("no") == null || map.get("no").equals(null)) {
				count = userService.countAll();
			}else {
				count = userService.countSearch(map);
			}
			bean.setCount(count);
			bean.setCode(0);
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}

	// 展示用户角色
	@RequestMapping(value = "/rolelist", method = RequestMethod.GET)
	@ResponseBody
	public JsonBean findRole() {
		JsonBean bean = new JsonBean();
		List<Role> list = null;

		try {
			list = userService.findRoles();
			bean.setCode(0);
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

	@RequestMapping(value = "/showAllAu", method = RequestMethod.GET)
	@ResponseBody
	public JsonBean showMenu() {
		String no = (String) SecurityUtils.getSubject().getPrincipal();
		JsonBean bean = new JsonBean();
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			list = userService.showMenu(no);
			bean.setCode(1);
			bean.setMsg(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}

		return bean;
	}

	@RequestMapping("/findAllUser")
	@ResponseBody
	public JsonBean findAllUser(HttpServletRequest request) {

		JsonBean bean = new JsonBean();

		HttpSession session = request.getSession(false);

		try {
			String no = (String) session.getAttribute("no");
			User user = userService.findByNo(no);
			bean.setMsg(user);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setCode(0);
			bean.setMsg(e.getMessage());
		}
		return bean;
	}

	@RequestMapping("/userdelete")
	@ResponseBody
	public JsonBean deleteUser(Integer id) {
		JsonBean bean = new JsonBean();

		try {
			userService.deleteUserById(id);
			bean.setCode(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
