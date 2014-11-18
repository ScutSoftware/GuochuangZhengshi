package com.lis.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lis.dao.Method1Dao;
import com.lis.model.Method1;
import com.lis.util.HQLConditionQuery;
import com.lis.util.HQLOrderBy;

@SuppressWarnings("unchecked")
@Repository
public class Method1DaoImpl extends BaseDaoImpl<Method1, Integer> implements Method1Dao{
	
}
