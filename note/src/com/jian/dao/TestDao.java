package com.jian.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.jian.moble.ParamConfig;

public class TestDao {
	
	public void save(ParamConfig paranConfig){
		Session session = HibernateUtil.getSession();
		session.save(paranConfig);
	}
	
	public void delete(ParamConfig paramConfig){
		Session session = HibernateUtil.getSession();
		session.delete(paramConfig);
	}
	
	public Object findById(Class clazz, Serializable id){
		Session session = HibernateUtil.getSession();
		return session.get(clazz, id);
	}
}
