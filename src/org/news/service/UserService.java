package org.news.service;

import org.news.dao.UserDao;
import org.news.dao.impl.UserDaoImpl;
import org.news.entity.User;

public class UserService {
	private UserDao userDao = new UserDaoImpl();
	/**
	 * 登录验证
	 * 
	 * @return 登录成功返回true 否则返回false
	 */
	public boolean login(User user) {
		
		return userDao.findUser(user) != null;
	}
	
	public boolean register(User u) {
		if(userDao.findUser(u)==null) {
			userDao.add(u);
			return true;
		}
		
		return false;
	}

}
