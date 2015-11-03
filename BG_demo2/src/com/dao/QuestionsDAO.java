package com.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.Questions;

/**
 * A data access object (DAO) providing persistence and search support for
 * Questions entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.domain.Questions
 * @author MyEclipse Persistence Tools
 */

public class QuestionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(QuestionsDAO.class);
	// property constants
	public static final String CONTENT = "content";
	public static final String DES = "des";
	private Transaction tx = getSession().beginTransaction();
	
	public void save(Questions transientInstance) {
		Session sess= getSession();
		Transaction tx = sess.beginTransaction();
		log.debug("saving Questions instance");
		try {
//			System.out.println("1");
			sess.save(transientInstance);
//			System.out.println("2");
			tx.commit();
			
			System.out.println("--操作结果:新增导航问题成功");
			log.debug("save successful");
		} catch (RuntimeException re) {
			System.out.println("--操作结果:新增导航问题失败");
			System.out.println(re.fillInStackTrace());
			log.error("save failed", re);
			throw re;
		}finally{
			sess.clear();
			sess.flush();
			sess.close();
		}
	}

	public void delete(Questions persistentInstance) {
		Session sess= getSession();
		Transaction tx = sess.beginTransaction();
		log.debug("deleting Questions instance");
		try {
			sess.delete(persistentInstance);
			tx.commit();
			
			System.out.println("--操作结果:删除导航问题成功");
			log.debug("delete successful");
		} catch (RuntimeException re) {
			System.out.println("--操作结果:新增导航问题失败");
			System.out.println(re.fillInStackTrace());
			log.error("delete failed", re);
			throw re;
		}finally{
			sess.clear();
			sess.flush();
			sess.close();
		}
	}

	public Questions findById(java.lang.Integer id) {
		log.debug("getting Questions instance with id: " + id);
		try {
			Questions instance = (Questions) getSession().get(
					"com.domain.Questions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Questions instance) {
		log.debug("finding Questions instance by example");
		try {
			List results = getSession().createCriteria("com.domain.Questions")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Questions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Questions as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByDes(Object des) {
		return findByProperty(DES, des);
	}

	public List findAll() {
		Session sess= getSession();
		Transaction tx = sess.beginTransaction();
		log.debug("finding all Questions instances");
		try {
			String queryString = "from Questions";
			Query queryObject = sess.createQuery(queryString);
			
			return queryObject.list();
		} catch (RuntimeException re) {
			System.out.println("--操作结果:查询导航问题失败");
			log.error("find all failed", re);
			throw re;
		}finally{
			tx.commit();
//			System.out.println("3");
			sess.clear();
			sess.flush();
			sess.close();
		}
	}

	public Questions merge(Questions detachedInstance) {
		log.debug("merging Questions instance");
		try {
			Questions result = (Questions) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Questions instance) {
		Session sess= getSession();
		Transaction tx = sess.beginTransaction();
		
		log.debug("attaching dirty Questions instance");
		try {
			sess.saveOrUpdate(instance);
		tx.commit();
		System.out.println("--操作结果：修改导航问题成功");
			log.debug("attach successful");
		} catch (RuntimeException re) {
			System.out.println("--操作结果：修改导航问题失败");
			log.error("attach failed", re);
			throw re;
		}finally{
			sess.clear();
			sess.flush();
			sess.close();
		}
	}

	public void attachClean(Questions instance) {
		log.debug("attaching clean Questions instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}