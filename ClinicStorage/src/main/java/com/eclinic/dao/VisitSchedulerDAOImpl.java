package com.eclinic.dao;

import com.eclinic.domain.VisitScheduler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage VisitScheduler entities.
 * 
 */
@Repository("VisitSchedulerDAO")
@Transactional
public class VisitSchedulerDAOImpl extends AbstractJpaDao<VisitScheduler>
		implements VisitSchedulerDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { VisitScheduler.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new VisitSchedulerDAOImpl
	 *
	 */
	public VisitSchedulerDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAllVisitSchedulers
	 *
	 */
	@Transactional
	public Set<VisitScheduler> findAllVisitSchedulers() throws DataAccessException {

		return findAllVisitSchedulers(-1, -1);
	}

	/**
	 * JPQL Query - findAllVisitSchedulers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitScheduler> findAllVisitSchedulers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllVisitSchedulers", startResult, maxRows);
		return new LinkedHashSet<VisitScheduler>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfDay
	 *
	 */
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByNumberOfDay(Integer numberOfDay) throws DataAccessException {

		return findVisitSchedulerByNumberOfDay(numberOfDay, -1, -1);
	}

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfDay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByNumberOfDay(Integer numberOfDay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitSchedulerByNumberOfDay", startResult, maxRows, numberOfDay);
		return new LinkedHashSet<VisitScheduler>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfMonth
	 *
	 */
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByNumberOfMonth(Integer numberOfMonth) throws DataAccessException {

		return findVisitSchedulerByNumberOfMonth(numberOfMonth, -1, -1);
	}

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfMonth
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByNumberOfMonth(Integer numberOfMonth, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitSchedulerByNumberOfMonth", startResult, maxRows, numberOfMonth);
		return new LinkedHashSet<VisitScheduler>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitSchedulerByTimeOfVisit
	 *
	 */
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByTimeOfVisit(java.util.Calendar timeOfVisit) throws DataAccessException {

		return findVisitSchedulerByTimeOfVisit(timeOfVisit, -1, -1);
	}

	/**
	 * JPQL Query - findVisitSchedulerByTimeOfVisit
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<VisitScheduler> findVisitSchedulerByTimeOfVisit(java.util.Calendar timeOfVisit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitSchedulerByTimeOfVisit", startResult, maxRows, timeOfVisit);
		return new LinkedHashSet<VisitScheduler>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitSchedulerById
	 *
	 */
	@Transactional
	public VisitScheduler findVisitSchedulerById(Integer id) throws DataAccessException {

		return findVisitSchedulerById(id, -1, -1);
	}

	/**
	 * JPQL Query - findVisitSchedulerById
	 *
	 */

	@Transactional
	public VisitScheduler findVisitSchedulerById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findVisitSchedulerById", startResult, maxRows, id);
			return (com.eclinic.domain.VisitScheduler) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findVisitSchedulerByPrimaryKey
	 *
	 */
	@Transactional
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id) throws DataAccessException {

		return findVisitSchedulerByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findVisitSchedulerByPrimaryKey
	 *
	 */

	@Transactional
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findVisitSchedulerByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.VisitScheduler) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(VisitScheduler entity) {
		return true;
	}
}
