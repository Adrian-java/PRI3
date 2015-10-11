package com.eclinic.dao;

import com.eclinic.domain.StatusOfVisit;

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
 * DAO to manage StatusOfVisit entities.
 * 
 */
@Repository("StatusOfVisitDAO")
@Transactional
public class StatusOfVisitDAOImpl extends AbstractJpaDao<StatusOfVisit>
		implements StatusOfVisitDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { StatusOfVisit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new StatusOfVisitDAOImpl
	 *
	 */
	public StatusOfVisitDAOImpl() {
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
	 * JPQL Query - findStatusOfVisitByType
	 *
	 */
	@Transactional
	public Set<StatusOfVisit> findStatusOfVisitByType(String type) throws DataAccessException {

		return findStatusOfVisitByType(type, -1, -1);
	}

	/**
	 * JPQL Query - findStatusOfVisitByType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StatusOfVisit> findStatusOfVisitByType(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusOfVisitByType", startResult, maxRows, type);
		return new LinkedHashSet<StatusOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusOfVisitById
	 *
	 */
	@Transactional
	public StatusOfVisit findStatusOfVisitById(Integer id) throws DataAccessException {

		return findStatusOfVisitById(id, -1, -1);
	}

	/**
	 * JPQL Query - findStatusOfVisitById
	 *
	 */

	@Transactional
	public StatusOfVisit findStatusOfVisitById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStatusOfVisitById", startResult, maxRows, id);
			return (com.eclinic.domain.StatusOfVisit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllStatusOfVisits
	 *
	 */
	@Transactional
	public Set<StatusOfVisit> findAllStatusOfVisits() throws DataAccessException {

		return findAllStatusOfVisits(-1, -1);
	}

	/**
	 * JPQL Query - findAllStatusOfVisits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StatusOfVisit> findAllStatusOfVisits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllStatusOfVisits", startResult, maxRows);
		return new LinkedHashSet<StatusOfVisit>(query.getResultList());
	}

	/**
	 * JPQL Query - findStatusOfVisitByPrimaryKey
	 *
	 */
	@Transactional
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id) throws DataAccessException {

		return findStatusOfVisitByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findStatusOfVisitByPrimaryKey
	 *
	 */

	@Transactional
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findStatusOfVisitByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.StatusOfVisit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findStatusOfVisitByTypeContaining
	 *
	 */
	@Transactional
	public Set<StatusOfVisit> findStatusOfVisitByTypeContaining(String type) throws DataAccessException {

		return findStatusOfVisitByTypeContaining(type, -1, -1);
	}

	/**
	 * JPQL Query - findStatusOfVisitByTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<StatusOfVisit> findStatusOfVisitByTypeContaining(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findStatusOfVisitByTypeContaining", startResult, maxRows, type);
		return new LinkedHashSet<StatusOfVisit>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(StatusOfVisit entity) {
		return true;
	}
}
