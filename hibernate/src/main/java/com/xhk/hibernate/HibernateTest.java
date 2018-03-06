package com.xhk.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class HibernateTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*User user = new User();
		user.setId(100000010L);
		user.setCurrentissuesource(111L);
		user.setLastupdate(new Date().toLocaleString());
		user.setPseudonym("张三feng");
		user.setRealname("张三丰");
		
		session.update(user);*/
		/*String hql = "from User";
		Query query = session.createQuery(hql);*/
		/*String sql = "select new User(pseudonym,realname) from User where name = :uname";
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(5);*/
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("realname", "一叶草"));
		List<User> list = criteria.list();
		for (User user : list) {
			System.out.println(user.getRealname());
		}
		
		
		tx.commit();
		session.close();
		sessionFactory.close();
		
	}
	
}
