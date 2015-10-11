package com.eclinic.dao;

import com.eclinic.domain.Visit;

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
 * DAO to manage Visit entities.
 * 
 */
@Repository("VisitDAO")
@Transactional
public class VisitDAOImpl extends AbstractJpaDao<Visit> implements VisitDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Visit.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new VisitDAOImpl
	 *
	 */
	public VisitDAOImpl() {
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
	 * JPQL Query - findVisitByIsLeave
	 *
	 */
	@Transactional
	public Set<Visit> findVisitByIsLeave(Boolean isLeave) throws DataAccessException {

		return findVisitByIsLeave(isLeave, -1, -1);
	}

	/**
	 * JPQL Query - findVisitByIsLeave
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findVisitByIsLeave(Boolean isLeave, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitByIsLeave", startResult, maxRows, isLeave);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitByDateOfVisit
	 *
	 */
	@Transactional
	public Set<Visit> findVisitByDateOfVisit(java.util.Calendar dateOfVisit) throws DataAccessException {

		return findVisitByDateOfVisit(dateOfVisit, -1, -1);
	}

	/**
	 * JPQL Query - findVisitByDateOfVisit
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findVisitByDateOfVisit(java.util.Calendar dateOfVisit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitByDateOfVisit", startResult, maxRows, dateOfVisit);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitByPrimaryKey
	 *
	 */
	@Transactional
	public Visit findVisitByPrimaryKey(Integer id) throws DataAccessException {

		return findVisitByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findVisitByPrimaryKey
	 *
	 */

	@Transactional
	public Visit findVisitByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findVisitByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Visit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findVisitById
	 *
	 */
	@Transactional
	public Visit findVisitById(Integer id) throws DataAccessException {

		return findVisitById(id, -1, -1);
	}

	/**
	 * JPQL Query - findVisitById
	 *
	 */

	@Transactional
	public Visit findVisitById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findVisitById", startResult, maxRows, id);
			return (com.eclinic.domain.Visit) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findVisitByDateOfVisitAfter
	 *
	 */
	@Transactional
	public Set<Visit> findVisitByDateOfVisitAfter(java.util.Calendar dateOfVisit) throws DataAccessException {

		return findVisitByDateOfVisitAfter(dateOfVisit, -1, -1);
	}

	/**
	 * JPQL Query - findVisitByDateOfVisitAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findVisitByDateOfVisitAfter(java.util.Calendar dateOfVisit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitByDateOfVisitAfter", startResult, maxRows, dateOfVisit);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllVisits
	 *
	 */
	@Transactional
	public Set<Visit> findAllVisits() throws DataAccessException {

		return findAllVisits(-1, -1);
	}

	/**
	 * JPQL Query - findAllVisits
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findAllVisits(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllVisits", startResult, maxRows);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitBySpecial
	 *
	 */
	@Transactional
	public Set<Visit> findVisitBySpecial(Boolean special) throws DataAccessException {

		return findVisitBySpecial(special, -1, -1);
	}

	/**
	 * JPQL Query - findVisitBySpecial
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findVisitBySpecial(Boolean special, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitBySpecial", startResult, maxRows, special);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * JPQL Query - findVisitByDateOfVisitBefore
	 *
	 */
	@Transactional
	public Set<Visit> findVisitByDateOfVisitBefore(java.util.Calendar dateOfVisit) throws DataAccessException {

		return findVisitByDateOfVisitBefore(dateOfVisit, -1, -1);
	}

	/**
	 * JPQL Query - findVisitByDateOfVisitBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Visit> findVisitByDateOfVisitBefore(java.util.Calendar dateOfVisit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findVisitByDateOfVisitBefore", startResult, maxRows, dateOfVisit);
		return new LinkedHashSet<Visit>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Visit entity) {
		return true;
	}

	public Set<Visit> findVisitByPesel(String pesel) throws DataAccessException {
		Query query = createNamedQuery("findVisitByPesel", -1, -1, pesel);
		return new LinkedHashSet<Visit>(query.getResultList());
	}
}
