package com.fjl.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fjl.entity.Staff;
import com.fjl.service.IStaffService;
import com.fjl.utils.ExcelUtils;
import com.fjl.vo.JsonBean;
@RequestMapping("/Ticktack_Office")
@Controller
public class StaffController {

	@Autowired
	private IStaffService staffService;

	@RequestMapping("/staffList")
	@ResponseBody
	public JsonBean showStaff() {
		JsonBean bean = new JsonBean();
		List<Object> list = new ArrayList<>();
		long count = 0;
		try {
			list = staffService.findAllStaff();
			count = staffService.count();
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

	@RequestMapping("/staffall")
	@ResponseBody
	public JsonBean staffall() {
		JsonBean bean = new JsonBean();
		List<Staff> list = new ArrayList<>();

		try {
			list = staffService.staffAll();
			bean.setData(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}

	@RequestMapping("/photoupload")
	@ResponseBody
	public JsonBean photoUpload(@RequestParam MultipartFile file) {
		JsonBean bean = new JsonBean();

		String fname = file.getOriginalFilename();

		String path = "E:\\eclipse-jee-oxygen-3-win32-x86_64\\eclipse-jee-oxygen-workspace\\db_tick\\src\\main\\webapp\\Ticktack_Office\\upload";
		System.out.println(path);
		File f = new File(path);

		if (!f.exists()) {
			f.mkdirs();
		}

		File f1 = new File(path, fname);

		try {
			file.transferTo(f1);
			bean.setCode(0);
			bean.setMsg(fname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}

		return bean;
	}

	@RequestMapping("/addStaff")
	@ResponseBody
	public JsonBean staffAdd(@RequestParam Map<String, Object> map) {
		JsonBean bean = new JsonBean();

		try {
			staffService.addStaff(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}

	@RequestMapping("/importStaExcel")
	@ResponseBody
	// 必须是@RequestParam MultipartFile
	public JsonBean upload(@RequestParam MultipartFile stafffile) {
		JsonBean bean = new JsonBean();
		// 获取上传的文件的文件名
		String filename = stafffile.getOriginalFilename();

		try {
			// 获取文件的输入流
			InputStream inputStream = stafffile.getInputStream();

			// 解析exel文件，进行导入操作
			List<Map<String, Object>> list = ExcelUtils.importStaExcel(filename, inputStream);
			for (Map<String, Object> map : list) {
				staffService.addStaff(map);
			}
			bean.setCode(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg("含有工号相同员工不能导入");
		}
		return bean;
	}
	@RequestMapping("/updateStaff")
	@ResponseBody
	public JsonBean updateStaff(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			staffService.update(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	
	@RequestMapping("/staffdelete")
	@ResponseBody
	public JsonBean delete(String no) {
		JsonBean bean = new JsonBean();
		
		try {
			staffService.delete(no);
			bean.setCode(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	@RequestMapping("/countStaff")
	@ResponseBody
	public JsonBean countStaff() {
		JsonBean bean = new JsonBean();
		long  count = 0;
		try {
			count = staffService.count();
			bean.setData(count);
			bean.setCode(1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
}
