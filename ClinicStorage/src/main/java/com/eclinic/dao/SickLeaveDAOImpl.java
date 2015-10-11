package com.eclinic.dao;

import com.eclinic.domain.SickLeave;

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
 * DAO to manage SickLeave entities.
 * 
 */
@Repository("SickLeaveDAO")
@Transactional
public class SickLeaveDAOImpl extends AbstractJpaDao<SickLeave> implements
		SickLeaveDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { SickLeave.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SickLeaveDAOImpl
	 *
	 */
	public SickLeaveDAOImpl() {
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
	 * JPQL Query - findSickLeaveByDateFromAfter
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFromAfter(java.util.Calendar dateFrom) throws DataAccessException {

		return findSickLeaveByDateFromAfter(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateFromAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFromAfter(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateFromAfter", startResult, maxRows, dateFrom);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findSickLeaveByPrimaryKey
	 *
	 */
	@Transactional
	public SickLeave findSickLeaveByPrimaryKey(Integer id) throws DataAccessException {

		return findSickLeaveByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByPrimaryKey
	 *
	 */

	@Transactional
	public SickLeave findSickLeaveByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSickLeaveByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.SickLeave) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSickLeaveByDateFromBefore
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFromBefore(java.util.Calendar dateFrom) throws DataAccessException {

		return findSickLeaveByDateFromBefore(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateFromBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFromBefore(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateFromBefore", startResult, maxRows, dateFrom);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findSickLeaveById
	 *
	 */
	@Transactional
	public SickLeave findSickLeaveById(Integer id) throws DataAccessException {

		return findSickLeaveById(id, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveById
	 *
	 */

	@Transactional
	public SickLeave findSickLeaveById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSickLeaveById", startResult, maxRows, id);
			return (com.eclinic.domain.SickLeave) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSickLeaveByDateToBefore
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateToBefore(java.util.Calendar dateTo) throws DataAccessException {

		return findSickLeaveByDateToBefore(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateToBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateToBefore(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateToBefore", startResult, maxRows, dateTo);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findSickLeaveByDateTo
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateTo(java.util.Calendar dateTo) throws DataAccessException {

		return findSickLeaveByDateTo(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateTo
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateTo(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateTo", startResult, maxRows, dateTo);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllSickLeaves
	 *
	 */
	@Transactional
	public Set<SickLeave> findAllSickLeaves() throws DataAccessException {

		return findAllSickLeaves(-1, -1);
	}

	/**
	 * JPQL Query - findAllSickLeaves
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findAllSickLeaves(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSickLeaves", startResult, maxRows);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findSickLeaveByDateToAfter
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateToAfter(java.util.Calendar dateTo) throws DataAccessException {

		return findSickLeaveByDateToAfter(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateToAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateToAfter(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateToAfter", startResult, maxRows, dateTo);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * JPQL Query - findSickLeaveByDateFrom
	 *
	 */
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFrom(java.util.Calendar dateFrom) throws DataAccessException {

		return findSickLeaveByDateFrom(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findSickLeaveByDateFrom
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SickLeave> findSickLeaveByDateFrom(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSickLeaveByDateFrom", startResult, maxRows, dateFrom);
		return new LinkedHashSet<SickLeave>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(SickLeave entity) {
		return true;
	}
}
