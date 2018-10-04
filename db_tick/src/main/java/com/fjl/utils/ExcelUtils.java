package com.fjl.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// 导入
	public static List<Map<String, Object>> importStuExcel(String fileName, InputStream inputStream) throws Exception {

		boolean ret = isXls(fileName);
		// 根据不同的后缀，创建不同的对象
		Workbook workBook = null;
		if (ret) {
			workBook = new HSSFWorkbook(inputStream);// xls
		} else {
			workBook = new XSSFWorkbook(inputStream);// xlsx
		}

		Sheet sheet = workBook.getSheetAt(0);
		int num = sheet.getLastRowNum();
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			Map<String, Object> map = new HashMap<>();
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			if (cell != null) {
				map.put("no", cell.getStringCellValue());
			}
			cell = row.getCell(1);
			if (cell != null) {
				map.put("name", cell.getStringCellValue());
			}
			cell = row.getCell(2);
			if (cell != null) {
				map.put("gid", cell.getStringCellValue());
			}
			cell = row.getCell(3);
			if (cell != null) {
				map.put("sex", cell.getStringCellValue());
			}
			cell = row.getCell(4);
			if (cell != null) {
				map.put("phone", cell.getStringCellValue());
			}
			cell = row.getCell(5);
			if (cell != null) {
				map.put("qq", cell.getStringCellValue());
			}
			cell = row.getCell(6);
			if (cell != null) {
				map.put("email", cell.getStringCellValue());
			}
			cell = row.getCell(7);
			if (cell != null) {
				map.put("cardno", cell.getStringCellValue());
			}
			cell = row.getCell(8);
			if (cell != null) {
				map.put("school", cell.getStringCellValue());
			}
			cell = row.getCell(9);
			if (cell != null) {
				map.put("education", cell.getStringCellValue());
			}
			cell = row.getCell(10);
			if (cell != null) {
				map.put("introno", cell.getStringCellValue());
			}
			cell = row.getCell(11);
			if (cell != null) {
				map.put("birthday", cell.getStringCellValue());
			}
			cell = row.getCell(12);
			if (cell != null) {
				map.put("createdate", cell.getStringCellValue());
			}
			
			list.add(map);
		}

		workBook.close();

		return list;
	}
	public static List<Map<String, Object>> importStaExcel(String fileName, InputStream inputStream) throws Exception {
		
		boolean ret = isXls(fileName);
		// 根据不同的后缀，创建不同的对象
		Workbook workBook = null;
		if (ret) {
			workBook = new HSSFWorkbook(inputStream);// xls
		} else {
			workBook = new XSSFWorkbook(inputStream);// xlsx
		}
		
		Sheet sheet = workBook.getSheetAt(0);
		int num = sheet.getLastRowNum();
		List<Map<String, Object>> list = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			Map<String, Object> map = new HashMap<>();
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("no", cell.getStringCellValue());
			}
			cell = row.getCell(1);
			if (cell != null) {
				map.put("name", cell.getStringCellValue());
			}
			cell = row.getCell(2);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("did", cell.getStringCellValue());
			}
			cell = row.getCell(3);
			if (cell != null) {
				map.put("sex", cell.getStringCellValue());
			}
			cell = row.getCell(4);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("phone", cell.getStringCellValue());
			}
			cell = row.getCell(5);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("email", cell.getStringCellValue());
			}
			cell = row.getCell(6);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("qq", cell.getStringCellValue());
			}
			cell = row.getCell(7);
			cell.setCellType(CellType.STRING);
			if (cell != null) {
				map.put("createdate", cell.getStringCellValue());
			}
			
			list.add(map);
		}
		
		workBook.close();
		
		return list;
	}

	public static boolean isXls(String fileName) {
		// js /^.+\.(xls)$/i
		// (?i) 右边的内容，忽略大小写
		if (fileName.matches("^.+\\.(?i)(xls)$")) {
			return true;
		} else if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			return false;
		} else {
			throw new RuntimeException("文件格式不对");
		}
		// Pattern p = Pattern.compile("^.+\\.(xls)$", )

	}
}
