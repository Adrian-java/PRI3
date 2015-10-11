package com.eclinic.dao;

import com.eclinic.domain.SystemError;

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
 * DAO to manage SystemError entities.
 * 
 */
@Repository("SystemErrorDAO")
@Transactional
public class SystemErrorDAOImpl extends AbstractJpaDao<SystemError> implements
		SystemErrorDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { SystemError.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SystemErrorDAOImpl
	 *
	 */
	public SystemErrorDAOImpl() {
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
	 * JPQL Query - findSystemErrorById
	 *
	 */
	@Transactional
	public SystemError findSystemErrorById(Integer id) throws DataAccessException {

		return findSystemErrorById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSystemErrorById
	 *
	 */

	@Transactional
	public SystemError findSystemErrorById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSystemErrorById", startResult, maxRows, id);
			return (com.eclinic.domain.SystemError) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSystemErrorByPrimaryKey
	 *
	 */
	@Transactional
	public SystemError findSystemErrorByPrimaryKey(Integer id) throws DataAccessException {

		return findSystemErrorByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSystemErrorByPrimaryKey
	 *
	 */

	@Transactional
	public SystemError findSystemErrorByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSystemErrorByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.SystemError) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSystemErrorByDate
	 *
	 */
	@Transactional
	public Set<SystemError> findSystemErrorByDate(java.util.Calendar date) throws DataAccessException {

		return findSystemErrorByDate(date, -1, -1);
	}

	/**
	 * JPQL Query - findSystemErrorByDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemError> findSystemErrorByDate(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemErrorByDate", startResult, maxRows, date);
		return new LinkedHashSet<SystemError>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllSystemErrors
	 *
	 */
	@Transactional
	public Set<SystemError> findAllSystemErrors() throws DataAccessException {

		return findAllSystemErrors(-1, -1);
	}

	/**
	 * JPQL Query - findAllSystemErrors
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemError> findAllSystemErrors(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSystemErrors", startResult, maxRows);
		return new LinkedHashSet<SystemError>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(SystemError entity) {
		return true;
	}
}
