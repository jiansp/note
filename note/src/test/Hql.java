package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Hql {
	public Configuration configuration = new AnnotationConfiguration().configure();
	public SessionFactory sessionFactory = this.configuration.buildSessionFactory();
	public Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Test
	public void main(){
		
	}
}
