package com.jian.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jian.dao.BaseDao;
import com.jian.dao.HibernateUtil;
import com.jian.moble.ParamConfig;

public class TestService {

	public void rollback(ParamConfig paramConfig){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		BaseDao baseDao = new BaseDao();
		baseDao.save(paramConfig);
		ParamConfig pc =(ParamConfig) baseDao.findById(ParamConfig.class, "1");
		baseDao.delete(pc);
		tx.commit();
	}
}
