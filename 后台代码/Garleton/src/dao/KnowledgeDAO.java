package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Knowledge;

/**
 * A data access object (DAO) providing persistence and search support for
 * Knowledge entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Knowledge
 * @author MyEclipse Persistence Tools
 */

public class KnowledgeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(KnowledgeDAO.class);
	// property constants
	public static final String COVERIMAGE = "coverimage";
	public static final String NAME = "name";
	public static final String CLASSIFICATION = "classification";
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String REMARKS = "remarks";

	protected void initDao() {
		// do nothing
	}

	public void save(Knowledge transientInstance) {
		log.debug("saving Knowledge instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Knowledge persistentInstance) {
		log.debug("deleting Knowledge instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Knowledge findById(java.lang.Integer id) {
		log.debug("getting Knowledge instance with id: " + id);
		try {
			Knowledge instance = (Knowledge) getHibernateTemplate().get(
					"entity.Knowledge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Knowledge instance) {
		log.debug("finding Knowledge instance by example");
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
		log.debug("finding Knowledge instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Knowledge as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByCoverimage(Object coverimage) {
		return findByProperty(COVERIMAGE, coverimage);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByClassification(Object classification) {
		return findByProperty(CLASSIFICATION, classification);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Knowledge instances");
		try {
			String queryString = "from Knowledge";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Knowledge merge(Knowledge detachedInstance) {
		log.debug("merging Knowledge instance");
		try {
			Knowledge result = (Knowledge) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Knowledge instance) {
		log.debug("attaching dirty Knowledge instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Knowledge instance) {
		log.debug("attaching clean Knowledge instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static KnowledgeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KnowledgeDAO) ctx.getBean("KnowledgeDAO");
	}
}