package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Resource;

/**
 * A data access object (DAO) providing persistence and search support for
 * Resource entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Resource
 * @author MyEclipse Persistence Tools
 */

public class ResourceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(ResourceDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String HOTDEGREE = "hotdegree";
	public static final String FILE = "file";
	public static final String SOURCE = "source";
	public static final String STATEMENT = "statement";
	public static final String COMMENT = "comment";

	protected void initDao() {
		// do nothing
	}

	public void save(Resource transientInstance) {
		log.debug("saving Resource instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Resource persistentInstance) {
		log.debug("deleting Resource instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Resource findById(java.lang.Integer id) {
		log.debug("getting Resource instance with id: " + id);
		try {
			Resource instance = (Resource) getHibernateTemplate().get(
					"entity.Resource", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Resource instance) {
		log.debug("finding Resource instance by example");
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
		log.debug("finding Resource instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Resource as model where model."
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

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByHotdegree(Object hotdegree) {
		return findByProperty(HOTDEGREE, hotdegree);
	}

	public List findByFile(Object file) {
		return findByProperty(FILE, file);
	}

	public List findBySource(Object source) {
		return findByProperty(SOURCE, source);
	}

	public List findByStatement(Object statement) {
		return findByProperty(STATEMENT, statement);
	}

	public List findByComment(Object comment) {
		return findByProperty(COMMENT, comment);
	}

	public List findAll() {
		log.debug("finding all Resource instances");
		try {
			String queryString = "from Resource";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Resource merge(Resource detachedInstance) {
		log.debug("merging Resource instance");
		try {
			Resource result = (Resource) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Resource instance) {
		log.debug("attaching dirty Resource instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Resource instance) {
		log.debug("attaching clean Resource instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ResourceDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ResourceDAO) ctx.getBean("ResourceDAO");
	}
}