package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.AuthorityMapper;
import com.fjl.entity.Authority;
import com.fjl.service.IAuthorityService;
@Service
public class AuthorityService implements IAuthorityService {
	
	@Autowired
	private AuthorityMapper authorityDao;
	
	@Override
	public List<Authority> findByName(String name) {
		// TODO Auto-generated method stub
		
		List<Authority> list = null;
		
		try {
			list = authorityDao.findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<String> findTitleByParentid(int parentid) {
		// TODO Auto-generated method stub
		List<String> list = null;
		
		try {
			list = authorityDao.findTitleByParentid(parentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Integer> findIdByParentid(int parentid) {
		// TODO Auto-generated method stub
		List<Integer> list = null;
		
		try {
			list = authorityDao.findIdByParentid(parentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Authority> findByParentid(int parentid) {
		// TODO Auto-generated method stub
		List<Authority> list = null;
		
		try {
			list = authorityDao.findByParentid(parentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findByParentid1(int parentid) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = null;
		
		try {
			list = authorityDao.findByParentid1(parentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Authority> findAuListByNo(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Authority> list = new ArrayList<>();
		String no = (String) map.get("no");
		if(no == null) {
			throw new RuntimeException("工号为空");
		}
		String page1 = (String) map.get("page");
		String limit1 = (String)map.get("limit");
		
		int page = Integer.parseInt(page1);
		int limit = Integer.parseInt(limit1);
		
		page = (page - 1) * limit;
		
		map.put("page", page);

		try {
			list = authorityDao.findAuByNo(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public long countByNo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		long count = 0;
		try {
			count = authorityDao.countAu(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
