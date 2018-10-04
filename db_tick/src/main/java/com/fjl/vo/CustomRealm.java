package com.fjl.vo;

import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.fjl.dao.AuthorityMapper;
import com.fjl.dao.UserMapper;
import com.fjl.entity.User;

public class CustomRealm extends AuthorizingRealm {
	
	@Autowired
	private UserMapper userDao;
	


	// 授权相关
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
//		String no = (String) principals.getPrimaryPrincipal();
//
//		SqlSession session = sessionFactory.openSession();
//		UserMapper userDao = session.getMapper(UserMapper.class);
//
//		List<String> roleList = userDao.findRoleByNo(no);
//		List<String> titleList = userDao.findTitleByNo(no);
//
//		Set<String> roleSet = new HashSet<>(roleList);
//		Set<String> titleSet = new HashSet<>(titleList);
//
//		session.close();
//
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//		info.setRoles(roleSet);
//
//		info.setStringPermissions(titleSet);

		return null;
	}

	// 认证相关
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// 获得主体信息
		String no = (String) token.getPrincipal();

		User user = userDao.findByNo(no);
		
		if (user == null) {
			throw new UnknownAccountException();
		}
		String password = user.getPassword();

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(no, password, this.getName());

		return info;
	}

}
