package com.lis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lis.dao.BaseDao;
import com.lis.dao.UserDao;
import com.lis.model.User;
import com.lis.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService{

	private UserDao userDao;
	
	@Autowired
	public void setBaseDao(BaseDao<User, String> userDao) {
		this.baseDao = userDao;
		this.userDao = (UserDao) userDao;
	}

}
