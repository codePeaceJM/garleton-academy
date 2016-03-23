package dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Cases;

/**
 * A data access object (DAO) providing persistence and search support for Cases
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see entity.Cases
 * @author MyEclipse Persistence Tools
 */

public class CasesDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(CasesDAO.class);
	// property constants
	public static final String RESOURCENAME = "resourcename";
	public static final String RESOURCETYPE = "resourcetype";
	public static final String RESOURCESOURCE = "resourcesource";
	public static final String DESCRIPTION = "description";
	public static final String OCCURPLACE = "occurplace";
	public static final String THEINJUREDNAME = "theinjuredname";
	public static final String ENCLOSURE = "enclosure";
	public static final String OCCURTIME = "occurtime";
	public static final String OCCURDATE = "occurdate";
	public static final String DEGREE = "degree";
	public static final String COPYRIGHTHOLDER = "copyrightholder";
	public static final String OPENDEGREE = "opendegree";
	public static final String LABER = "laber";
	public static final String PROCESS = "process";
	public static final String CAUSE = "cause";
	public static final String HANDLING = "handling";
	public static final String ACCOUNTABILITY = "accountability";
	public static final String REMEDIALMEASURES = "remedialmeasures";
	public static final String IMPROVEMENT = "improvement";

	protected void initDao() {
		// do nothing
	}

	public void save(Cases transientInstance) {
		log.debug("saving Cases instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cases persistentInstance) {
		log.debug("deleting Cases instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cases findById(java.lang.Integer id) {
		log.debug("getting Cases instance with id: " + id);
		try {
			Cases instance = (Cases) getHibernateTemplate().get("entity.Cases",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cases instance) {
		log.debug("finding Cases instance by example");
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
		log.debug("finding Cases instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cases as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByResourcename(Object resourcename) {
		return findByProperty(RESOURCENAME, resourcename);
	}

	public List findByResourcetype(Object resourcetype) {
		return findByProperty(RESOURCETYPE, resourcetype);
	}

	public List findByResourcesource(Object resourcesource) {
		return findByProperty(RESOURCESOURCE, resourcesource);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByOccurplace(Object occurplace) {
		return findByProperty(OCCURPLACE, occurplace);
	}

	public List findByTheinjuredname(Object theinjuredname) {
		return findByProperty(THEINJUREDNAME, theinjuredname);
	}

	public List findByEnclosure(Object enclosure) {
		return findByProperty(ENCLOSURE, enclosure);
	}

	public List findByOccurtime(Object occurtime) {
		return findByProperty(OCCURTIME, occurtime);
	}

	public List findByOccurdate(Object occurdate) {
		return findByProperty(OCCURDATE, occurdate);
	}

	public List findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List findByCopyrightholder(Object copyrightholder) {
		return findByProperty(COPYRIGHTHOLDER, copyrightholder);
	}

	public List findByOpendegree(Object opendegree) {
		return findByProperty(OPENDEGREE, opendegree);
	}

	public List findByLaber(Object laber) {
		return findByProperty(LABER, laber);
	}

	public List findByProcess(Object process) {
		return findByProperty(PROCESS, process);
	}

	public List findByCause(Object cause) {
		return findByProperty(CAUSE, cause);
	}

	public List findByHandling(Object handling) {
		return findByProperty(HANDLING, handling);
	}

	public List findByAccountability(Object accountability) {
		return findByProperty(ACCOUNTABILITY, accountability);
	}

	public List findByRemedialmeasures(Object remedialmeasures) {
		return findByProperty(REMEDIALMEASURES, remedialmeasures);
	}

	public List findByImprovement(Object improvement) {
		return findByProperty(IMPROVEMENT, improvement);
	}

	public List findAll() {
		log.debug("finding all Cases instances");
		try {
			String queryString = "from Cases";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cases merge(Cases detachedInstance) {
		log.debug("merging Cases instance");
		try {
			Cases result = (Cases) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cases instance) {
		log.debug("attaching dirty Cases instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cases instance) {
		log.debug("attaching clean Cases instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CasesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CasesDAO) ctx.getBean("CasesDAO");
	}
}