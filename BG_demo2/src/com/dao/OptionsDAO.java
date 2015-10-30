package com.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.domain.Options;

/**
 * A data access object (DAO) providing persistence and search support for
 * Options entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.domain.Options
 * @author MyEclipse Persistence Tools
 */

public class OptionsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OptionsDAO.class);
	// property constants
	public static final String QUESTION_ID = "questionId";
	public static final String OPT_INDEX = "optIndex";
	public static final String OPT_CONTENT = "optContent";
	public static final String NEXT_ID = "nextId";
	public static final String IS_BUSINESS = "isBusiness";
	public static final String DES = "des";

	private Transaction tx = getSession().beginTransaction();
	
	public void save(Options transientInstance) {
		Session sess= getSession();
		Transaction tx = sess.beginTransaction();
		System.out.println("选项内容:"+transientInstance.getOptContent());
		System.out.println("是否指向业务:"+transientInstance.getIsBusiness());
		System.out.println("指向id:"+transientInstance.getNextId());
		System.out.println("所属导航问题id:"+transientInstance.getQuestionId());
		
		
		log.debug("saving Options instance");
		try {
			sess.save(transientInstance);
			tx.commit();
			System.out.println("--操作结果:新增选项成功");
			
			log.debug("save successful");
			sess.clear();
			sess.flush();
			sess.close();
		} catch (RuntimeException re) {
			System.out.println("--操作结果:新增选项成功");
			log.error("save failed", re);
			throw re;
		}finally{
//			System.out.println("3");
			sess.clear();
			sess.flush();
			sess.close();
		}
	}

	public void delete(Options persistentInstance) {
		log.debug("deleting Options instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Options findById(java.lang.Integer id) {
		log.debug("getting Options instance with id: " + id);
		try {
			Options instance = (Options) getSession().get("com.domain.Options",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Options instance) {
		log.debug("finding Options instance by example");
		try {
			List results = getSession().createCriteria("com.domain.Options")
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
		log.debug("finding Options instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Options as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByQuestionId(Object questionId) {
		return findByProperty(QUESTION_ID, questionId);
	}

	public List findByOptIndex(Object optIndex) {
		return findByProperty(OPT_INDEX, optIndex);
	}

	public List findByOptContent(Object optContent) {
		return findByProperty(OPT_CONTENT, optContent);
	}

	public List findByNextId(Object nextId) {
		return findByProperty(NEXT_ID, nextId);
	}

	public List findByIsBusiness(Object isBusiness) {
		return findByProperty(IS_BUSINESS, isBusiness);
	}

	public List findByDes(Object des) {
		return findByProperty(DES, des);
	}

	public List findAll() {
		log.debug("finding all Options instances");
		try {
			String queryString = "from Options";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Options merge(Options detachedInstance) {
		log.debug("merging Options instance");
		try {
			Options result = (Options) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Options instance) {
		log.debug("attaching dirty Options instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Options instance) {
		log.debug("attaching clean Options instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}