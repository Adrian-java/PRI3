package com.eclinic.dao;

import com.eclinic.domain.Admin;

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
 * DAO to manage Admin entities.
 * 
 */
@Repository("AdminDAO")
@Transactional
public class AdminDAOImpl extends AbstractJpaDao<Admin> implements AdminDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Admin.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AdminDAOImpl
	 *
	 */
	public AdminDAOImpl() {
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
	 * JPQL Query - findAdminByIsSuper
	 *
	 */
	@Transactional
	public Set<Admin> findAdminByIsSuper(Boolean isSuper) throws DataAccessException {

		return findAdminByIsSuper(isSuper, -1, -1);
	}

	/**
	 * JPQL Query - findAdminByIsSuper
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Admin> findAdminByIsSuper(Boolean isSuper, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAdminByIsSuper", startResult, maxRows, isSuper);
		return new LinkedHashSet<Admin>(query.getResultList());
	}

	/**
	 * JPQL Query - findAdminById
	 *
	 */
	@Transactional
	public Admin findAdminById(Integer id) throws DataAccessException {

		return findAdminById(id, -1, -1);
	}

	/**
	 * JPQL Query - findAdminById
	 *
	 */

	@Transactional
	public Admin findAdminById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdminById", startResult, maxRows, id);
			return (com.eclinic.domain.Admin) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */
	@Transactional
	public Admin findAdminByPrimaryKey(Integer id) throws DataAccessException {

		return findAdminByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findAdminByPrimaryKey
	 *
	 */

	@Transactional
	public Admin findAdminByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAdminByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Admin) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAdmins
	 *
	 */
	@Transactional
	public Set<Admin> findAllAdmins() throws DataAccessException {

		return findAllAdmins(-1, -1);
	}

	/**
	 * JPQL Query - findAllAdmins
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Admin> findAllAdmins(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAdmins", startResult, maxRows);
		return new LinkedHashSet<Admin>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Admin entity) {
		return true;
	}
}
