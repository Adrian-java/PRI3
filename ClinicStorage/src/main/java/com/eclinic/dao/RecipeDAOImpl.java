package com.eclinic.dao;

import com.eclinic.domain.Recipe;

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
 * DAO to manage Recipe entities.
 * 
 */
@Repository("RecipeDAO")
@Transactional
public class RecipeDAOImpl extends AbstractJpaDao<Recipe> implements RecipeDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Recipe.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RecipeDAOImpl
	 *
	 */
	public RecipeDAOImpl() {
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
	 * JPQL Query - findRecipeByDate
	 *
	 */
	@Transactional
	public Set<Recipe> findRecipeByDate(java.util.Calendar date) throws DataAccessException {

		return findRecipeByDate(date, -1, -1);
	}

	/**
	 * JPQL Query - findRecipeByDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Recipe> findRecipeByDate(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecipeByDate", startResult, maxRows, date);
		return new LinkedHashSet<Recipe>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecipeByPrimaryKey
	 *
	 */
	@Transactional
	public Recipe findRecipeByPrimaryKey(Integer idr) throws DataAccessException {

		return findRecipeByPrimaryKey(idr, -1, -1);
	}

	/**
	 * JPQL Query - findRecipeByPrimaryKey
	 *
	 */

	@Transactional
	public Recipe findRecipeByPrimaryKey(Integer idr, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecipeByPrimaryKey", startResult, maxRows, idr);
			return (com.eclinic.domain.Recipe) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllRecipes
	 *
	 */
	@Transactional
	public Set<Recipe> findAllRecipes() throws DataAccessException {

		return findAllRecipes(-1, -1);
	}

	/**
	 * JPQL Query - findAllRecipes
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Recipe> findAllRecipes(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRecipes", startResult, maxRows);
		return new LinkedHashSet<Recipe>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecipeByDateBefore
	 *
	 */
	@Transactional
	public Set<Recipe> findRecipeByDateBefore(java.util.Calendar date) throws DataAccessException {

		return findRecipeByDateBefore(date, -1, -1);
	}

	/**
	 * JPQL Query - findRecipeByDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Recipe> findRecipeByDateBefore(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecipeByDateBefore", startResult, maxRows, date);
		return new LinkedHashSet<Recipe>(query.getResultList());
	}

	/**
	 * JPQL Query - findRecipeByIdr
	 *
	 */
	@Transactional
	public Recipe findRecipeByIdr(Integer idr) throws DataAccessException {

		return findRecipeByIdr(idr, -1, -1);
	}

	/**
	 * JPQL Query - findRecipeByIdr
	 *
	 */

	@Transactional
	public Recipe findRecipeByIdr(Integer idr, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRecipeByIdr", startResult, maxRows, idr);
			return (com.eclinic.domain.Recipe) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRecipeByDateAfter
	 *
	 */
	@Transactional
	public Set<Recipe> findRecipeByDateAfter(java.util.Calendar date) throws DataAccessException {

		return findRecipeByDateAfter(date, -1, -1);
	}

	/**
	 * JPQL Query - findRecipeByDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Recipe> findRecipeByDateAfter(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRecipeByDateAfter", startResult, maxRows, date);
		return new LinkedHashSet<Recipe>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Recipe entity) {
		return true;
	}
}
