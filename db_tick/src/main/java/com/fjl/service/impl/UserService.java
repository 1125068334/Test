package com.fjl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjl.dao.AuthorityMapper;
import com.fjl.dao.UserMapper;
import com.fjl.dao.UserRoleMapper;
import com.fjl.entity.Authority;
import com.fjl.entity.Role;
import com.fjl.entity.User;
import com.fjl.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserMapper userDao;

	@Autowired
	private AuthorityMapper auDao;

	@Autowired
	private UserRoleMapper urDao;

	@Override
	public User LoginUser(String no, String password) {
		// TODO Auto-generated method stub
		if (no == null) {
			throw new RuntimeException("用户名为空");
		}
		if (password == null) {
			throw new RuntimeException("密码为空");
		}
		User user = null;

		try {
			user = userDao.findByNo(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (user == null) {
			throw new RuntimeException("该用户不存在");
		}
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("密码错误");
		}
		return user;
	}

	@Override
	public List<Map<String, Object>> userList(Map<String,Object> maps) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		List<Map<String, Object>> list1 = new ArrayList<>();
		try {
			String page1 = (String) maps.get("page");
			String limit1 = (String)maps.get("limit");
			int limit = Integer.parseInt(limit1);
			int page = Integer.parseInt(page1);
			page = (page - 1) * limit;
			maps.put("page", page);
			maps.put("limit", limit);
			
			
			if (maps.get("no") == null || ((String) maps.get("no")).isEmpty()) {
				list1 = userDao.findAll(maps);
			} else {
				list1 = userDao.searchUR(maps);
			}
			for (Map<String, Object> map : list1) {
				String no = (String) map.get("no");
				Integer id = (Integer) map.get("id");
				String name = (String) map.get("name");
				Integer flag = (Integer) map.get("flag");
				List<Map<String, Object>> list2 = userDao.findRoleByNo(no);
				List<String> list3 = new ArrayList<>();
				for (Map<String, Object> map2 : list2) {
					String info = (String) map2.get("info");
					list3.add(info);
				}
				Map<String, Object> map1 = new HashMap<>();
				map1.put("id", id);
				map1.put("no", no);
				map1.put("name", name);
				map1.put("flag", flag);
				map1.put("info", list3);
				list.add(map1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("展示用户角色失败");
		}

		return list;
	}

	@Override
	public List<Role> findRoles() {
		// TODO Auto-generated method stub
		List<Role> list = null;

		try {
			list = userDao.findRoles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User findByNo(String no) {
		// TODO Auto-generated method stub
		User u = new User();
		if (no == null) {
			throw new RuntimeException("工号不能为空");
		}
		try {
			u = userDao.findByNo(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List<Map<String, Object>> showMenu(String no) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		List<Authority> list1 = new ArrayList<>();

		try {
			list1 = auDao.findAuByNo1(no);

			for (Authority au : list1) {
				Integer id = au.getId();
				Integer parentid = au.getParentid();

				if (parentid == 0) {
					Map<String, Object> map = new HashMap<>();
					List<Authority> list2 = new ArrayList<>();

					list2 = auDao.findByParentid(id);

					map.put("amenu", au.getTitle());

					map.put("bmenu", list2);

					list.add(map);
				} else {
					break;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("展示失败service");
		}

		return list;
	}

	@Override
	public void deleteUserById(Integer id) {
		// TODO Auto-generated method stub
		try {
			urDao.deleteByUid(id);

			userDao.deleteUserById(id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public long countAll() {
		// TODO Auto-generated method stub
		long count = 0;
		
		try {
			count = userDao.countAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public long countSearch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		long count = 0;
		
		try {
			count = userDao.countSearch(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
