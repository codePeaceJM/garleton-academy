package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Expert;
import entity.Question;

/**
 * A data access object (DAO) providing persistence and search support for
 * Expert entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Expert
 * @author MyEclipse Persistence Tools
 */

public class ExpertDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ExpertDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String PHOTO = "photo";
	public static final String DESCRIPTION = "description";
	public static final String ACHIVEMENTS = "achivements";
	public static final String REMARKS = "remarks";
	public static final String TYPE = "type";
	public static final String STRATEGY = "strategy";
	public static final String PUBLIC_ = "public_";

	protected void initDao() {
		// do nothing
	}

	public void save(Expert transientInstance) {
		log.debug("saving Expert instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Expert persistentInstance) {
		log.debug("deleting Expert instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void update(Expert e){
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(e);
		tx.commit();
	}

	public Expert findById(java.lang.Integer id) {
		log.debug("getting Expert instance with id: " + id);
		try {
			Expert instance = (Expert) getHibernateTemplate().get(
					"entity.Expert", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public List findByName(Object value) {
		Session session = getSession();
		Transaction tx=session.beginTransaction(); 
		String hql="from Expert as expert where expert.name like ? ";
		Query query = session.createQuery(hql); 
		query.setString(0,"%"+value+"%");
		
		List list=query.list(); 
		tx.commit(); 
	    return list;
	}

//	public List findByExample(Expert instance) {
//		log.debug("finding Expert instance by example");
//		try {
//			List results = getHibernateTemplate().findByExample(instance);
//			log.debug("find by example successful, result size: "
//					+ results.size());
//			return results;
//		} catch (RuntimeException re) {
//			log.error("find by example failed", re);
//			throw re;
//		}
//	}
//
//	public List findByProperty(String propertyName, Object value) {
//		log.debug("finding Expert instance with property: " + propertyName
//				+ ", value: " + value);
//		try {
//			String queryString = "from Expert as model where model."
//					+ propertyName + "= ?";
//			return getHibernateTemplate().find(queryString, value);
//		} catch (RuntimeException re) {
//			log.error("find by property name failed", re);
//			throw re;
//		}
//	}
//
//	public List findByName(Object name) {
//		return findByProperty(NAME, name);
//	}
//
//	public List findByPhoto(Object photo) {
//		return findByProperty(PHOTO, photo);
//	}
//
//	public List findByDescription(Object description) {
//		return findByProperty(DESCRIPTION, description);
//	}
//
//	public List findByAchivements(Object achivements) {
//		return findByProperty(ACHIVEMENTS, achivements);
//	}
//
//	public List findByRemarks(Object remarks) {
//		return findByProperty(REMARKS, remarks);
//	}
//
//	public List findByType(Object type) {
//		return findByProperty(TYPE, type);
//	}
//
//	public List findByStrategy(Object strategy) {
//		return findByProperty(STRATEGY, strategy);
//	}
//
//	public List findByPublic_(Object public_) {
//		return findByProperty(PUBLIC_, public_);
//	}

	public List findAll() {
		log.debug("finding all Expert instances");
		try {
			String queryString = "from Expert";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Expert merge(Expert detachedInstance) {
		log.debug("merging Expert instance");
		try {
			Expert result = (Expert) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Expert instance) {
		log.debug("attaching dirty Expert instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Expert instance) {
		log.debug("attaching clean Expert instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ExpertDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ExpertDAO) ctx.getBean("ExpertDAO");
	}
}