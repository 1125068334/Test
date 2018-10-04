package com.fjl.controller;

import java.io.IOException;
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

import com.fjl.service.IStudentService;
import com.fjl.utils.ExcelUtils;
import com.fjl.vo.JsonBean;

@RequestMapping("/Ticktack_Office")
@Controller
public class StudentController {

	@Autowired
	private IStudentService stuService;
	
	@RequestMapping("/studentpage")
	@ResponseBody
	public JsonBean showStudent() {
		JsonBean bean = new JsonBean();
		List<Map<String,Object>> list = new ArrayList<>();
		long count = 0;
		try {
			list = stuService.showStu();
			count = stuService.count();
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
	
	@RequestMapping("/addStudent")
	@ResponseBody
	public JsonBean addStu(@RequestParam Map<String,Object> map) {
		JsonBean bean = new JsonBean();
		
		try {
			stuService.addStu(map);
			bean.setCode(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		return bean;
	}
	
	@RequestMapping("/importStuExcel")
	@ResponseBody
	// 必须是@RequestParam MultipartFile
	public JsonBean upload(@RequestParam MultipartFile upfile) {
		JsonBean bean = new JsonBean();
		// 获取上传的文件的文件名
		String filename = upfile.getOriginalFilename();

		try {
			// 获取文件的输入流
			InputStream inputStream = upfile.getInputStream();

			// 解析exel文件，进行导入操作
			List<Map<String, Object>> list = ExcelUtils.importStuExcel(filename, inputStream);
			
			for (Map<String, Object> map : list) {
				stuService.addStu(map);
			}
			
			bean.setCode(1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}

		return bean;
	}
	
	@RequestMapping("/studentdelete")
	@ResponseBody
	public JsonBean deleteStu(String no) {
		JsonBean bean = new JsonBean();
		
		try {
			stuService.delete(no);
			bean.setCode(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bean.setMsg(e.getMessage());
		}
		
		return bean;
	}
	
	
}
