package com.jian.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class BaseDao {

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
	
	public List findBySql(String sql, Object[] paramValue){
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql);
		if(paramValue != null){
			for(int i=0;i<paramValue.length;i++){
				query.setParameter(i, paramValue[i]);
			}
		}
		return query.list();
	}
	
	public List findBySql(String sql, String[] paramName, Object[] paramValue){
		Session session = HibernateUtil.getSession();
		Query query = session.createSQLQuery(sql);
		if(paramValue != null){
			for(int i=0;i<paramValue.length;i++){
				query.setParameter(paramName[i], paramValue[i]);
			}
		}
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
	
	public void save(Object object){
		Session session = HibernateUtil.getSession();
		session.save(object);
	}
	
	public void update(Object object){
		Session session = HibernateUtil.getSession();
		session.update(object);
	}
	
	public void delete(Object object){
		Session session = HibernateUtil.getSession();
		session.delete(object);
	}
	
	public Object findById(Class clazz, Serializable id){
		Session session = HibernateUtil.getSession();
		return session.get(clazz, id);
	}
}
