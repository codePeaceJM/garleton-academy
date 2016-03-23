package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Statute;


/**
 * A data access object (DAO) providing persistence and search support for
 * Statute entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Statute
 * @author MyEclipse Persistence Tools
 */

public class StatuteDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(StatuteDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String STATEMENT = "statement";
	public static final String TYPE = "type";
	public static final String SOURCE = "source";
	public static final String TOP = "top";
	public static final String UPLOAD = "upload";
	public static final String PDF = "pdf";
	public static final String REMARKS = "remarks";

	protected void initDao() {
		// do nothing
	}

	public void save(Statute transientInstance) {
		log.debug("saving Statute instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Statute persistentInstance) {
		log.debug("deleting Statute instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Statute findById(java.lang.Integer id) {
		log.debug("getting Statute instance with id: " + id);
		try {
			Statute instance = (Statute) getHibernateTemplate().get(
					"entity.Statute", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Statute instance) {
		log.debug("finding Statute instance by example");
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
		log.debug("finding Statute instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Statute as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByStatement(Object statement) {
		return findByProperty(STATEMENT, statement);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List findByTop(Object top) {
		return findByProperty(TOP, top);
	}

	public List findByUpload(Object upload) {
		return findByProperty(UPLOAD, upload);
	}

	public List findByPdf(Object pdf) {
		return findByProperty(PDF, pdf);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Statute instances");
		try {
			String queryString = "from Statute";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Statute merge(Statute detachedInstance) {
		log.debug("merging Statute instance");
		try {
			Statute result = (Statute) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Statute instance) {
		log.debug("attaching dirty Statute instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Statute instance) {
		log.debug("attaching clean Statute instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StatuteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StatuteDAO) ctx.getBean("StatuteDAO");
	}
}