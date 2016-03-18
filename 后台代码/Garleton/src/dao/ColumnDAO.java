package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Column;

/**
 * A data access object (DAO) providing persistence and search support for
 * Column entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Column
 * @author MyEclipse Persistence Tools
 */

public class ColumnDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ColumnDAO.class);
	// property constants
	public static final String INSTITUTE = "institute";
	public static final String NAME = "name";
	public static final String ICON = "icon";
	public static final String DESCRIPTION = "description";
	public static final String KEYWORD = "keyword";
	public static final String PUBLISHER = "publisher";
	public static final String PUBLISHTIME = "publishtime";

	protected void initDao() {
		// do nothing
	}

	public void save(Column transientInstance) {
		// log.debug("saving Column instance");
		// try {
		// getHibernateTemplate().save(transientInstance);
		// log.debug("save successful");
		// } catch (RuntimeException re) {
		// log.error("save failed", re);
		// throw re;
		// }
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(transientInstance);
		tx.commit();
	}

	public void update(Column c) {

		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.update(c);
		tx.commit();
		
	}

	public void delete(Column persistentInstance) {
//		log.debug("deleting Column instance");
//		try {
//			getHibernateTemplate().delete(persistentInstance);
//			log.debug("delete successful");
//		} catch (RuntimeException re) {
//			log.error("delete failed", re);
//			throw re;
//		}
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.delete(persistentInstance);
		tx.commit();
	}

	public Column findById(java.lang.Integer id) {
		log.debug("getting Column instance with id: " + id);
		try {
			Column instance = (Column) getHibernateTemplate().get(
					"entity.Column", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Column instance) {
		log.debug("finding Column instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Column instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Column as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInsititute(Object institute) {
		return findByProperty(INSTITUTE, institute);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByIcon(Object icon) {
		return findByProperty(ICON, icon);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByKeyword(Object keyword) {
		return findByProperty(KEYWORD, keyword);
	}

	public List findByPublisher(Object publisher) {
		return findByProperty(PUBLISHER, publisher);
	}

	public List findByPublishtime(Object publishtime) {
		return findByProperty(PUBLISHTIME, publishtime);
	}

	public List findAll() {
		log.debug("finding all Column instances");
		try {
			String queryString = "from Column";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Column merge(Column detachedInstance) {
		log.debug("merging Column instance");
		try {
			Column result = (Column) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Column instance) {
		log.debug("attaching dirty Column instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Column instance) {
		log.debug("attaching clean Column instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ColumnDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ColumnDAO) ctx.getBean("ColumnDAO");
	}
}