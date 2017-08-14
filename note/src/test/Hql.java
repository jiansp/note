package test;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jian.dao.HibernateUtil;


public class Hql {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("select p.id,displayName from ParamConfig p where p.id = '555af11ce83345b397f14a2bb80193e5'");
		Object[] ret = (Object[]) query.uniqueResult();
		for(Object str : ret){
			System.out.println(str.toString());
		}
		
		
	}
}
