package com.lis.dao.impl;

import org.springframework.stereotype.Repository;

import com.lis.dao.UserDao;
import com.lis.model.User;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao{

}
