package com.jian.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
/*
 * 一、hiberbate工具类，用于获得session或sessionFactory。
 * 二、获取session有两个方法，openSession()和getgetCurrentSession()。
 * 	1、
 * 	2、采用getCurrentSession()需要在Hibernate.cfg.xml配置文件中加入如下配置：
 * 		如果是本地事物，及JDBC一个数据库：
 * 			<propety name=”Hibernate.current_session_context_class”>thread</propety>
 * 		如果是全局事物，及jta事物、多个数据库资源或事物资源：
 * 			<propety name=”Hibernate.current_session_context_class”>jta</propety>
 */
public class HibernateUtil {
	public static SessionFactory sessionFactory;
	public static Session session;
	static{
		Configuration config = new AnnotationConfiguration().configure();
		sessionFactory = config.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	public static Session getSession(){
		session = getSessionFactory().getCurrentSession();
		return session;
	}
	
	public static void closeSession(Session session){
		if(session !=null){
			session.close();
		}
	}
}
