package com.eclinic.dao;

import com.eclinic.domain.Permission;

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
 * DAO to manage Permission entities.
 * 
 */
@Repository("PermissionDAO")
@Transactional
public class PermissionDAOImpl extends AbstractJpaDao<Permission> implements
		PermissionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Permission.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PermissionDAOImpl
	 *
	 */
	public PermissionDAOImpl() {
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
	 * JPQL Query - findPermissionByExecute
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByExecute(Boolean execute) throws DataAccessException {

		return findPermissionByExecute(execute, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByExecute
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByExecute(Boolean execute, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByExecute", startResult, maxRows, execute);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id) throws DataAccessException {

		return findPermissionByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */

	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPermissionByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Permission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	@Transactional
	public Set<Permission> findAllPermissions() throws DataAccessException {

		return findAllPermissions(-1, -1);
	}

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findAllPermissions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPermissions", startResult, maxRows);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	@Transactional
	public Permission findPermissionById(Integer id) throws DataAccessException {

		return findPermissionById(id, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionById
	 *
	 */

	@Transactional
	public Permission findPermissionById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPermissionById", startResult, maxRows, id);
			return (com.eclinic.domain.Permission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPermissionByEdit
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByEdit(Boolean edit) throws DataAccessException {

		return findPermissionByEdit(edit, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByEdit
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByEdit(Boolean edit, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByEdit", startResult, maxRows, edit);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByDisplay
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByDisplay(Boolean display) throws DataAccessException {

		return findPermissionByDisplay(display, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByDisplay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByDisplay(Boolean display, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByDisplay", startResult, maxRows, display);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Permission entity) {
		return true;
	}
}
