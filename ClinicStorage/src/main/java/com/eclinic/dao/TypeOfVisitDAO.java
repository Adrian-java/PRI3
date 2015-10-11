package com.eclinic.dao;

import com.eclinic.domain.TypeOfVisit;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TypeOfVisit entities.
 * 
 */
public interface TypeOfVisitDAO extends JpaDao<TypeOfVisit> {

	/**
	 * JPQL Query - findTypeOfVisitByDuration
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByDuration(Integer duration) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByDuration
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByDuration(Integer duration, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitById
	 *
	 */
	public TypeOfVisit findTypeOfVisitById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitById
	 *
	 */
	public TypeOfVisit findTypeOfVisitById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByNameContaining
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByNameContaining
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTypeOfVisits
	 *
	 */
	public Set<TypeOfVisit> findAllTypeOfVisits() throws DataAccessException;

	/**
	 * JPQL Query - findAllTypeOfVisits
	 *
	 */
	public Set<TypeOfVisit> findAllTypeOfVisits(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByName
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByName
	 *
	 */
	public Set<TypeOfVisit> findTypeOfVisitByName(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByPrimaryKey
	 *
	 */
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfVisitByPrimaryKey
	 *
	 */
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}