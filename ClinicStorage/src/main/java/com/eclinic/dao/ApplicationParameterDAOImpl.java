package com.eclinic.dao;

import com.eclinic.domain.ApplicationParameter;

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
 * DAO to manage ApplicationParameter entities.
 * 
 */
@Repository("ApplicationParameterDAO")
@Transactional
public class ApplicationParameterDAOImpl extends AbstractJpaDao<ApplicationParameter>
		implements ApplicationParameterDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { ApplicationParameter.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ApplicationParameterDAOImpl
	 *
	 */
	public ApplicationParameterDAOImpl() {
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
	 * JPQL Query - findApplicationParameterByValueNumber
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueNumber(Integer valueNumber) throws DataAccessException {

		return findApplicationParameterByValueNumber(valueNumber, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByValueNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueNumber(Integer valueNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findApplicationParameterByValueNumber", startResult, maxRows, valueNumber);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findApplicationParameterById
	 *
	 */
	@Transactional
	public ApplicationParameter findApplicationParameterById(Integer id) throws DataAccessException {

		return findApplicationParameterById(id, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterById
	 *
	 */

	@Transactional
	public ApplicationParameter findApplicationParameterById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findApplicationParameterById", startResult, maxRows, id);
			return (com.eclinic.domain.ApplicationParameter) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findApplicationParameterByKey
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByKey(String key) throws DataAccessException {

		return findApplicationParameterByKey(key, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByKey
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByKey(String key, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findApplicationParameterByKey", startResult, maxRows, key);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findApplicationParameterByPrimaryKey
	 *
	 */
	@Transactional
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id) throws DataAccessException {

		return findApplicationParameterByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByPrimaryKey
	 *
	 */

	@Transactional
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findApplicationParameterByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.ApplicationParameter) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findApplicationParameterByValueString
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueString(String valueString) throws DataAccessException {

		return findApplicationParameterByValueString(valueString, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByValueString
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueString(String valueString, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findApplicationParameterByValueString", startResult, maxRows, valueString);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findApplicationParameterByValueStringContaining
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueStringContaining(String valueString) throws DataAccessException {

		return findApplicationParameterByValueStringContaining(valueString, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByValueStringContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByValueStringContaining(String valueString, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findApplicationParameterByValueStringContaining", startResult, maxRows, valueString);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllApplicationParameters
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findAllApplicationParameters() throws DataAccessException {

		return findAllApplicationParameters(-1, -1);
	}

	/**
	 * JPQL Query - findAllApplicationParameters
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findAllApplicationParameters(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllApplicationParameters", startResult, maxRows);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findApplicationParameterByKeyContaining
	 *
	 */
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByKeyContaining(String key) throws DataAccessException {

		return findApplicationParameterByKeyContaining(key, -1, -1);
	}

	/**
	 * JPQL Query - findApplicationParameterByKeyContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<ApplicationParameter> findApplicationParameterByKeyContaining(String key, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findApplicationParameterByKeyContaining", startResult, maxRows, key);
		return new LinkedHashSet<ApplicationParameter>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(ApplicationParameter entity) {
		return true;
	}
}
