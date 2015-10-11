package com.eclinic.dao;

import com.eclinic.domain.TypeOfVisit;

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
 * DAO to manage TypeOfVisit entities.
 * 
 */
@Repository("TypeOfVisitDAO")
@Transactional
public class TypeOfVisitDAOImpl extends AbstractJpaDao<TypeOfVisit> implements
		TypeOfVisitDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TypeOfVisit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TypeOfVisitDAOImpl
	 *
	 */
	public TypeOfVisitDAOImpl() {
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
	 * JPQL Query - findTypeOfVisitByDuration
	 *
	 */
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByDuration(Integer duration) throws DataAccessException {

		return findTypeOfVisitByDuration(duration, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfVisitByDuration
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByDuration(Integer duration, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTypeOfVisitByDuration", startResult, maxRows, duration);
		return new LinkedHashSet<TypeOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfVisitById
	 *
	 */
	@Transactional
	public TypeOfVisit findTypeOfVisitById(Integer id) throws DataAccessException {

		return findTypeOfVisitById(id, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfVisitById
	 *
	 */

	@Transactional
	public TypeOfVisit findTypeOfVisitById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTypeOfVisitById", startResult, maxRows, id);
			return (com.eclinic.domain.TypeOfVisit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTypeOfVisitByNameContaining
	 *
	 */
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByNameContaining(String name) throws DataAccessException {

		return findTypeOfVisitByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfVisitByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTypeOfVisitByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<TypeOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTypeOfVisits
	 *
	 */
	@Transactional
	public Set<TypeOfVisit> findAllTypeOfVisits() throws DataAccessException {

		return findAllTypeOfVisits(-1, -1);
	}

	/**
	 * JPQL Query - findAllTypeOfVisits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfVisit> findAllTypeOfVisits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTypeOfVisits", startResult, maxRows);
		return new LinkedHashSet<TypeOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfVisitByName
	 *
	 */
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByName(String name) throws DataAccessException {

		return findTypeOfVisitByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfVisitByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfVisit> findTypeOfVisitByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTypeOfVisitByName", startResult, maxRows, name);
		return new LinkedHashSet<TypeOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfVisitByPrimaryKey
	 *
	 */
	@Transactional
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id) throws DataAccessException {

		return findTypeOfVisitByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfVisitByPrimaryKey
	 *
	 */

	@Transactional
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTypeOfVisitByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.TypeOfVisit) query.getSingleResult();
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
	public boolean canBeMerged(TypeOfVisit entity) {
		return true;
	}
}
