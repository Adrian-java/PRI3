package com.eclinic.dao;

import com.eclinic.domain.Module;

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
 * DAO to manage Module entities.
 * 
 */
@Repository("ModuleDAO")
@Transactional
public class ModuleDAOImpl extends AbstractJpaDao<Module> implements ModuleDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Module.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ModuleDAOImpl
	 *
	 */
	public ModuleDAOImpl() {
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
	 * JPQL Query - findModuleByName
	 *
	 */
	@Transactional
	public Set<Module> findModuleByName(String name) throws DataAccessException {

		return findModuleByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findModuleByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Module> findModuleByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findModuleByName", startResult, maxRows, name);
		return new LinkedHashSet<Module>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllModules
	 *
	 */
	@Transactional
	public Set<Module> findAllModules() throws DataAccessException {

		return findAllModules(-1, -1);
	}

	/**
	 * JPQL Query - findAllModules
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Module> findAllModules(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllModules", startResult, maxRows);
		return new LinkedHashSet<Module>(query.getResultList());
	}

	/**
	 * JPQL Query - findModuleByVisibility
	 *
	 */
	@Transactional
	public Set<Module> findModuleByVisibility(Boolean visibility) throws DataAccessException {

		return findModuleByVisibility(visibility, -1, -1);
	}

	/**
	 * JPQL Query - findModuleByVisibility
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Module> findModuleByVisibility(Boolean visibility, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findModuleByVisibility", startResult, maxRows, visibility);
		return new LinkedHashSet<Module>(query.getResultList());
	}

	/**
	 * JPQL Query - findModuleById
	 *
	 */
	@Transactional
	public Module findModuleById(Integer id) throws DataAccessException {

		return findModuleById(id, -1, -1);
	}

	/**
	 * JPQL Query - findModuleById
	 *
	 */

	@Transactional
	public Module findModuleById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findModuleById", startResult, maxRows, id);
			return (com.eclinic.domain.Module) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findModuleByPrimaryKey
	 *
	 */
	@Transactional
	public Module findModuleByPrimaryKey(Integer id) throws DataAccessException {

		return findModuleByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findModuleByPrimaryKey
	 *
	 */

	@Transactional
	public Module findModuleByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findModuleByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Module) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findModuleByNameContaining
	 *
	 */
	@Transactional
	public Set<Module> findModuleByNameContaining(String name) throws DataAccessException {

		return findModuleByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findModuleByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Module> findModuleByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findModuleByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Module>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Module entity) {
		return true;
	}
}
