package com.eclinic.dao;

import com.eclinic.domain.Recipe;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Recipe entities.
 * 
 */
public interface RecipeDAO extends JpaDao<Recipe> {

	/**
	 * JPQL Query - findRecipeByDate
	 *
	 */
	public Set<Recipe> findRecipeByDate(java.util.Calendar date) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByDate
	 *
	 */
	public Set<Recipe> findRecipeByDate(Calendar date, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByPrimaryKey
	 *
	 */
	public Recipe findRecipeByPrimaryKey(Integer idr) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByPrimaryKey
	 *
	 */
	public Recipe findRecipeByPrimaryKey(Integer idr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRecipes
	 *
	 */
	public Set<Recipe> findAllRecipes() throws DataAccessException;

	/**
	 * JPQL Query - findAllRecipes
	 *
	 */
	public Set<Recipe> findAllRecipes(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByDateBefore
	 *
	 */
	public Set<Recipe> findRecipeByDateBefore(java.util.Calendar date_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByDateBefore
	 *
	 */
	public Set<Recipe> findRecipeByDateBefore(Calendar date_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByIdr
	 *
	 */
	public Recipe findRecipeByIdr(Integer idr_1) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByIdr
	 *
	 */
	public Recipe findRecipeByIdr(Integer idr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByDateAfter
	 *
	 */
	public Set<Recipe> findRecipeByDateAfter(java.util.Calendar date_2) throws DataAccessException;

	/**
	 * JPQL Query - findRecipeByDateAfter
	 *
	 */
	public Set<Recipe> findRecipeByDateAfter(Calendar date_2, int startResult, int maxRows) throws DataAccessException;

}