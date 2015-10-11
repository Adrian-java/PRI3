package com.eclinic.dao;

import com.eclinic.domain.SpecalVisitField;

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
 * DAO to manage SpecalVisitField entities.
 * 
 */
@Repository("SpecalVisitFieldDAO")
@Transactional
public class SpecalVisitFieldDAOImpl extends AbstractJpaDao<SpecalVisitField>
		implements SpecalVisitFieldDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { SpecalVisitField.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SpecalVisitFieldDAOImpl
	 *
	 */
	public SpecalVisitFieldDAOImpl() {
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
	 * JPQL Query - findSpecalVisitFieldByTypeOfValueContaining
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValueContaining(String typeOfValue) throws DataAccessException {

		return findSpecalVisitFieldByTypeOfValueContaining(typeOfValue, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValueContaining(String typeOfValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByTypeOfValueContaining", startResult, maxRows, typeOfValue);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValue
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValue(String typeOfValue) throws DataAccessException {

		return findSpecalVisitFieldByTypeOfValue(typeOfValue, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValue(String typeOfValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByTypeOfValue", startResult, maxRows, typeOfValue);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByPrimaryKey
	 *
	 */
	@Transactional
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id) throws DataAccessException {

		return findSpecalVisitFieldByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByPrimaryKey
	 *
	 */

	@Transactional
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSpecalVisitFieldByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.SpecalVisitField) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllSpecalVisitFields
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findAllSpecalVisitFields() throws DataAccessException {

		return findAllSpecalVisitFields(-1, -1);
	}

	/**
	 * JPQL Query - findAllSpecalVisitFields
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findAllSpecalVisitFields(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSpecalVisitFields", startResult, maxRows);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByValueContaining
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByValueContaining(String value) throws DataAccessException {

		return findSpecalVisitFieldByValueContaining(value, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByValueContaining(String value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByValueContaining", startResult, maxRows, value);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByName
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByName(String name) throws DataAccessException {

		return findSpecalVisitFieldByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByName", startResult, maxRows, name);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByNameContaining
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByNameContaining(String name) throws DataAccessException {

		return findSpecalVisitFieldByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecalVisitFieldById
	 *
	 */
	@Transactional
	public SpecalVisitField findSpecalVisitFieldById(Integer id) throws DataAccessException {

		return findSpecalVisitFieldById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldById
	 *
	 */

	@Transactional
	public SpecalVisitField findSpecalVisitFieldById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSpecalVisitFieldById", startResult, maxRows, id);
			return (com.eclinic.domain.SpecalVisitField) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByValue
	 *
	 */
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByValue(String value) throws DataAccessException {

		return findSpecalVisitFieldByValue(value, -1, -1);
	}

	/**
	 * JPQL Query - findSpecalVisitFieldByValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SpecalVisitField> findSpecalVisitFieldByValue(String value, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecalVisitFieldByValue", startResult, maxRows, value);
		return new LinkedHashSet<SpecalVisitField>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(SpecalVisitField entity) {
		return true;
	}
}
