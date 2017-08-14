package com.jian.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import test.TransactionTest;

import com.jian.dao.HibernateUtil;
import com.jian.dao.TestDao;
import com.jian.moble.ParamConfig;

public class TestService {

	public void rollback(ParamConfig paramConfig){
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		TestDao testDao = new TestDao();
		testDao.save(paramConfig);
		ParamConfig pc =(ParamConfig) testDao.findById(ParamConfig.class, "1");
		testDao.delete(pc);
		tx.commit();
	}
}
