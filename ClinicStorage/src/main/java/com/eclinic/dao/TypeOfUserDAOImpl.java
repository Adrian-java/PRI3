package com.eclinic.dao;

import com.eclinic.domain.TypeOfUser;

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
 * DAO to manage TypeOfUser entities.
 * 
 */
@Repository("TypeOfUserDAO")
@Transactional
public class TypeOfUserDAOImpl extends AbstractJpaDao<TypeOfUser> implements
		TypeOfUserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { TypeOfUser.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TypeOfUserDAOImpl
	 *
	 */
	public TypeOfUserDAOImpl() {
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
	 * JPQL Query - findAllTypeOfUsers
	 *
	 */
	@Transactional
	public Set<TypeOfUser> findAllTypeOfUsers() throws DataAccessException {

		return findAllTypeOfUsers(-1, -1);
	}

	/**
	 * JPQL Query - findAllTypeOfUsers
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfUser> findAllTypeOfUsers(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTypeOfUsers", startResult, maxRows);
		return new LinkedHashSet<TypeOfUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfUserByType
	 *
	 */
	@Transactional
	public Set<TypeOfUser> findTypeOfUserByType(String type) throws DataAccessException {

		return findTypeOfUserByType(type, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfUserByType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfUser> findTypeOfUserByType(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTypeOfUserByType", startResult, maxRows, type);
		return new LinkedHashSet<TypeOfUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfUserByTypeContaining
	 *
	 */
	@Transactional
	public Set<TypeOfUser> findTypeOfUserByTypeContaining(String type) throws DataAccessException {

		return findTypeOfUserByTypeContaining(type, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfUserByTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<TypeOfUser> findTypeOfUserByTypeContaining(String type, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTypeOfUserByTypeContaining", startResult, maxRows, type);
		return new LinkedHashSet<TypeOfUser>(query.getResultList());
	}

	/**
	 * JPQL Query - findTypeOfUserByPrimaryKey
	 *
	 */
	@Transactional
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id) throws DataAccessException {

		return findTypeOfUserByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfUserByPrimaryKey
	 *
	 */

	@Transactional
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTypeOfUserByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.TypeOfUser) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTypeOfUserById
	 *
	 */
	@Transactional
	public TypeOfUser findTypeOfUserById(Integer id) throws DataAccessException {

		return findTypeOfUserById(id, -1, -1);
	}

	/**
	 * JPQL Query - findTypeOfUserById
	 *
	 */

	@Transactional
	public TypeOfUser findTypeOfUserById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTypeOfUserById", startResult, maxRows, id);
			return (com.eclinic.domain.TypeOfUser) query.getSingleResult();
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
	public boolean canBeMerged(TypeOfUser entity) {
		return true;
	}
}
