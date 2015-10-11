package com.eclinic.dao;

import com.eclinic.domain.Worker;

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
 * DAO to manage Worker entities.
 * 
 */
@Repository("WorkerDAO")
@Transactional
public class WorkerDAOImpl extends AbstractJpaDao<Worker> implements WorkerDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Worker.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new WorkerDAOImpl
	 *
	 */
	public WorkerDAOImpl() {
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
	 * JPQL Query - findWorkerById
	 *
	 */
	@Transactional
	public Worker findWorkerById(Integer id) throws DataAccessException {

		return findWorkerById(id, -1, -1);
	}

	/**
	 * JPQL Query - findWorkerById
	 *
	 */

	@Transactional
	public Worker findWorkerById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findWorkerById", startResult, maxRows, id);
			return (com.eclinic.domain.Worker) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllWorkers
	 *
	 */
	@Transactional
	public Set<Worker> findAllWorkers() throws DataAccessException {

		return findAllWorkers(-1, -1);
	}

	/**
	 * JPQL Query - findAllWorkers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Worker> findAllWorkers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllWorkers", startResult, maxRows);
		return new LinkedHashSet<Worker>(query.getResultList());
	}

	/**
	 * JPQL Query - findWorkerByPrimaryKey
	 *
	 */
	@Transactional
	public Worker findWorkerByPrimaryKey(Integer id) throws DataAccessException {

		return findWorkerByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findWorkerByPrimaryKey
	 *
	 */

	@Transactional
	public Worker findWorkerByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findWorkerByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Worker) query.getSingleResult();
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
	public boolean canBeMerged(Worker entity) {
		return true;
	}
}
