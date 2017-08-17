package com.jian.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.FinderException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.jian.moble.ParamConfig;

public class TestDao {
	
	@Test
	public void test() {
		String ql = "select p.id,p.typeName from ParamConfig p where p.id='555af11ce83345b397f14a2bb80193e5'";
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Object[] ret = findArrayByHql(ql);
		for(Object str : ret){
			System.out.println(str);
		}
		
	}
	/*
	 * 创建Query对象时
	 * 1、sql使用session.createSQLQuery方法
	 * 2、hql使用session.createQuery方法
	 */
	public List findBySql(String sql){
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql);
		return query.list();
	}
	
	public List findByHql(String hql){
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
	/*
	 * 当hql中选择查询字段时，返回的不是实例的集合，而是数组
	 */
	public Object[] findArrayByHql(String hql){
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);
		return (Object[])query.uniqueResult();
	}
	
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
