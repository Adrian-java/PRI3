package com.eclinic.dao;

import com.eclinic.domain.SystemUser;

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
 * DAO to manage SystemUser entities.
 * 
 */
@Repository("SystemUserDAO")
@Transactional
public class SystemUserDAOImpl extends AbstractJpaDao<SystemUser> implements
		SystemUserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { SystemUser.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new SystemUserDAOImpl
	 *
	 */
	public SystemUserDAOImpl() {
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
	 * JPQL Query - findSystemUserByUnregisterDate
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDate(java.util.Calendar unregisterDate) throws DataAccessException {

		return findSystemUserByUnregisterDate(unregisterDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByUnregisterDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDate(java.util.Calendar unregisterDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByUnregisterDate", startResult, maxRows, unregisterDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByChangedPassword
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByChangedPassword(Boolean changedPassword) throws DataAccessException {

		return findSystemUserByChangedPassword(changedPassword, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByChangedPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByChangedPassword(Boolean changedPassword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByChangedPassword", startResult, maxRows, changedPassword);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByPrimaryKey
	 *
	 */
	@Transactional
	public SystemUser findSystemUserByPrimaryKey(Integer id) throws DataAccessException {

		return findSystemUserByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByPrimaryKey
	 *
	 */

	@Transactional
	public SystemUser findSystemUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSystemUserByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.SystemUser) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSystemUserByPasswordContaining
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByPasswordContaining(String password) throws DataAccessException {

		return findSystemUserByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDate
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDate(java.util.Calendar registerDate) throws DataAccessException {

		return findSystemUserByRegisterDate(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDate(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByRegisterDate", startResult, maxRows, registerDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserById
	 *
	 */
	@Transactional
	public SystemUser findSystemUserById(Integer id) throws DataAccessException {

		return findSystemUserById(id, -1, -1);
	}
	
	
	@Transactional
	public SystemUser findSystemUserByPesel(String pesel) throws DataAccessException {

		try {
			Query query = createNamedQuery("findSystemUserByPesel", -1, -1, pesel);
			return (com.eclinic.domain.SystemUser) query.getSingleResult();
//			SystemUser su = (SystemUser) query.getResultList().get(0);
//			return su;
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findSystemUserById
	 *
	 */

	@Transactional
	public SystemUser findSystemUserById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findSystemUserById", startResult, maxRows, id);
			return (com.eclinic.domain.SystemUser) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllSystemUsers
	 *
	 */
	@Transactional
	public Set<SystemUser> findAllSystemUsers() throws DataAccessException {

		return findAllSystemUsers(-1, -1);
	}

	/**
	 * JPQL Query - findAllSystemUsers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findAllSystemUsers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllSystemUsers", startResult, maxRows);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByEmailContaining
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByEmailContaining(String email) throws DataAccessException {

		return findSystemUserByEmailContaining(email, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByEmailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByEmailContaining", startResult, maxRows, email);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByPassword
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByPassword(String password) throws DataAccessException {

		return findSystemUserByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByPassword", startResult, maxRows, password);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByIsActive
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByIsActive(Boolean isActive) throws DataAccessException {

		return findSystemUserByIsActive(isActive, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByIsActive
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByIsActive(Boolean isActive, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByIsActive", startResult, maxRows, isActive);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDateAfter
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDateAfter(java.util.Calendar registerDate) throws DataAccessException {

		return findSystemUserByRegisterDateAfter(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDateAfter(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByRegisterDateAfter", startResult, maxRows, registerDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByUnregisterDateAfter
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDateAfter(java.util.Calendar unregisterDate) throws DataAccessException {

		return findSystemUserByUnregisterDateAfter(unregisterDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByUnregisterDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDateAfter(java.util.Calendar unregisterDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByUnregisterDateAfter", startResult, maxRows, unregisterDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByEmail
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByEmail(String email) throws DataAccessException {

		return findSystemUserByEmail(email, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByEmail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByEmail(String email, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByEmail", startResult, maxRows, email);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}



	/**
	 * JPQL Query - findSystemUserByUnregisterDateBefore
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDateBefore(java.util.Calendar unregisterDate) throws DataAccessException {

		return findSystemUserByUnregisterDateBefore(unregisterDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByUnregisterDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByUnregisterDateBefore(java.util.Calendar unregisterDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByUnregisterDateBefore", startResult, maxRows, unregisterDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDateBefore
	 *
	 */
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDateBefore(java.util.Calendar registerDate) throws DataAccessException {

		return findSystemUserByRegisterDateBefore(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findSystemUserByRegisterDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<SystemUser> findSystemUserByRegisterDateBefore(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findSystemUserByRegisterDateBefore", startResult, maxRows, registerDate);
		return new LinkedHashSet<SystemUser>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(SystemUser entity) {
		return true;
	}
}
