package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Institution;

/**
 * A data access object (DAO) providing persistence and search support for
 * Institution entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see entity.Institution
 * @author MyEclipse Persistence Tools
 */

public class InstitutionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(InstitutionDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String TYPE = "type";
	public static final String SUPERIOR = "superior";
	public static final String DID = "did";
	public static final String LEVEL = "level";
	public static final String PIC = "pic";
	public static final String ADDRESS = "address";
	public static final String POSTCODE = "postcode";
	public static final String TEL = "tel";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String COMMENT = "comment";

	protected void initDao() {
		// do nothing
	}

	public void save(Institution transientInstance) {
//		log.debug("saving Institution instance");
//		try {
//			getHibernateTemplate().save(transientInstance);
//			log.debug("save successful");
//		} catch (RuntimeException re) {
//			log.error("save failed", re);
//			throw re;
//		}
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		session.save(transientInstance);
		tx.commit();
	}

	public void delete(Institution persistentInstance) {
//		log.debug("deleting Institution instance");
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

	public Institution findById(java.lang.Integer id) {
		log.debug("getting Institution instance with id: " + id);
		try {
			Institution instance = (Institution) getHibernateTemplate().get(
					"entity.Institution", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Institution instance) {
		log.debug("finding Institution instance by example");
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
		log.debug("finding Institution instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Institution as model where model."
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

	public List findBySuperior(Object superior) {
		return findByProperty(SUPERIOR, superior);
	}

	public List findByDid(Object did) {
		return findByProperty(DID, did);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByPic(Object pic) {
		return findByProperty(PIC, pic);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByFax(Object fax) {
		return findByProperty(FAX, fax);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByComment(Object comment) {
		return findByProperty(COMMENT, comment);
	}

	public List findAll() {
		log.debug("finding all Institution instances");
		try {
			String queryString = "from Institution";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Institution merge(Institution detachedInstance) {
		log.debug("merging Institution instance");
		try {
			Institution result = (Institution) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Institution instance) {
		log.debug("attaching dirty Institution instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Institution instance) {
		log.debug("attaching clean Institution instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static InstitutionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (InstitutionDAO) ctx.getBean("InstitutionDAO");
	}
}