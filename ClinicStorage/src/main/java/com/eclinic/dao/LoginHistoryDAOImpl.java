package com.eclinic.dao;

import com.eclinic.domain.LoginHistory;

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
 * DAO to manage LoginHistory entities.
 * 
 */
@Repository("LoginHistoryDAO")
@Transactional
public class LoginHistoryDAOImpl extends AbstractJpaDao<LoginHistory> implements
		LoginHistoryDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { LoginHistory.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new LoginHistoryDAOImpl
	 *
	 */
	public LoginHistoryDAOImpl() {
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
	 * JPQL Query - findLoginHistoryByDateLogoutAfter
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogoutAfter(java.util.Calendar dateLogout) throws DataAccessException {

		return findLoginHistoryByDateLogoutAfter(dateLogout, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogoutAfter(java.util.Calendar dateLogout, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLogoutAfter", startResult, maxRows, dateLogout);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLoginBefore
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLoginBefore(java.util.Calendar dateLogin) throws DataAccessException {

		return findLoginHistoryByDateLoginBefore(dateLogin, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLoginBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLoginBefore(java.util.Calendar dateLogin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLoginBefore", startResult, maxRows, dateLogin);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogout
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogout(java.util.Calendar dateLogout) throws DataAccessException {

		return findLoginHistoryByDateLogout(dateLogout, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogout
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogout(java.util.Calendar dateLogout, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLogout", startResult, maxRows, dateLogout);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLoginAfter
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLoginAfter(java.util.Calendar dateLogin) throws DataAccessException {

		return findLoginHistoryByDateLoginAfter(dateLogin, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLoginAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLoginAfter(java.util.Calendar dateLogin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLoginAfter", startResult, maxRows, dateLogin);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryById
	 *
	 */
	@Transactional
	public LoginHistory findLoginHistoryById(Integer id) throws DataAccessException {

		return findLoginHistoryById(id, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryById
	 *
	 */

	@Transactional
	public LoginHistory findLoginHistoryById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findLoginHistoryById", startResult, maxRows, id);
			return (com.eclinic.domain.LoginHistory) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllLoginHistorys
	 *
	 */
	@Transactional
	public Set<LoginHistory> findAllLoginHistorys() throws DataAccessException {

		return findAllLoginHistorys(-1, -1);
	}

	/**
	 * JPQL Query - findAllLoginHistorys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findAllLoginHistorys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllLoginHistorys", startResult, maxRows);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryByPrimaryKey
	 *
	 */
	@Transactional
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id) throws DataAccessException {

		return findLoginHistoryByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByPrimaryKey
	 *
	 */

	@Transactional
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findLoginHistoryByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.LoginHistory) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutBefore
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogoutBefore(java.util.Calendar dateLogout) throws DataAccessException {

		return findLoginHistoryByDateLogoutBefore(dateLogout, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogoutBefore(java.util.Calendar dateLogout, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLogoutBefore", startResult, maxRows, dateLogout);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryBySessionNumberContaining
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryBySessionNumberContaining(String sessionNumber) throws DataAccessException {

		return findLoginHistoryBySessionNumberContaining(sessionNumber, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryBySessionNumberContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryBySessionNumberContaining(String sessionNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryBySessionNumberContaining", startResult, maxRows, sessionNumber);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogin
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogin(java.util.Calendar dateLogin) throws DataAccessException {

		return findLoginHistoryByDateLogin(dateLogin, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryByDateLogin
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryByDateLogin(java.util.Calendar dateLogin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryByDateLogin", startResult, maxRows, dateLogin);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * JPQL Query - findLoginHistoryBySessionNumber
	 *
	 */
	@Transactional
	public Set<LoginHistory> findLoginHistoryBySessionNumber(String sessionNumber) throws DataAccessException {

		return findLoginHistoryBySessionNumber(sessionNumber, -1, -1);
	}

	/**
	 * JPQL Query - findLoginHistoryBySessionNumber
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<LoginHistory> findLoginHistoryBySessionNumber(String sessionNumber, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findLoginHistoryBySessionNumber", startResult, maxRows, sessionNumber);
		return new LinkedHashSet<LoginHistory>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(LoginHistory entity) {
		return true;
	}
}
