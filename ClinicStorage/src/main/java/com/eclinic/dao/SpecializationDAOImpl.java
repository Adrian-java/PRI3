package com.eclinic.dao;

import com.eclinic.domain.Specialization;

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
 * DAO to manage Specialization entities.
 * 
 */
@Repository("SpecializationDAO")
@Transactional
public class SpecializationDAOImpl extends AbstractJpaDao<Specialization>
		implements SpecializationDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Specialization.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SpecializationDAOImpl
	 *
	 */
	public SpecializationDAOImpl() {
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
	 * JPQL Query - findSpecializationByNameContaining
	 *
	 */
	@Transactional
	public Set<Specialization> findSpecializationByNameContaining(String name) throws DataAccessException {

		return findSpecializationByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findSpecializationByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Specialization> findSpecializationByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecializationByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Specialization>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecializationByPrimaryKey
	 *
	 */
	@Transactional
	public Specialization findSpecializationByPrimaryKey(Integer id) throws DataAccessException {

		return findSpecializationByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSpecializationByPrimaryKey
	 *
	 */

	@Transactional
	public Specialization findSpecializationByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSpecializationByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Specialization) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllSpecializations
	 *
	 */
	@Transactional
	public Set<Specialization> findAllSpecializations() throws DataAccessException {

		return findAllSpecializations(-1, -1);
	}

	/**
	 * JPQL Query - findAllSpecializations
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Specialization> findAllSpecializations(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSpecializations", startResult, maxRows);
		return new LinkedHashSet<Specialization>(query.getResultList());
	}

	/**
	 * JPQL Query - findSpecializationById
	 *
	 */
	@Transactional
	public Specialization findSpecializationById(Integer id) throws DataAccessException {

		return findSpecializationById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSpecializationById
	 *
	 */

	@Transactional
	public Specialization findSpecializationById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSpecializationById", startResult, maxRows, id);
			return (com.eclinic.domain.Specialization) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSpecializationByName
	 *
	 */
	@Transactional
	public Set<Specialization> findSpecializationByName(String name) throws DataAccessException {

		return findSpecializationByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findSpecializationByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Specialization> findSpecializationByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSpecializationByName", startResult, maxRows, name);
		return new LinkedHashSet<Specialization>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Specialization entity) {
		return true;
	}
}
