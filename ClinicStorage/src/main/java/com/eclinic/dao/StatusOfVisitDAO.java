package com.eclinic.dao;

import com.eclinic.domain.StatusOfVisit;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage StatusOfVisit entities.
 * 
 */
public interface StatusOfVisitDAO extends JpaDao<StatusOfVisit> {

	/**
	 * JPQL Query - findStatusOfVisitByType
	 *
	 */
	public Set<StatusOfVisit> findStatusOfVisitByType(String type) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitByType
	 *
	 */
	public Set<StatusOfVisit> findStatusOfVisitByType(String type, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitById
	 *
	 */
	public StatusOfVisit findStatusOfVisitById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitById
	 *
	 */
	public StatusOfVisit findStatusOfVisitById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllStatusOfVisits
	 *
	 */
	public Set<StatusOfVisit> findAllStatusOfVisits() throws DataAccessException;

	/**
	 * JPQL Query - findAllStatusOfVisits
	 *
	 */
	public Set<StatusOfVisit> findAllStatusOfVisits(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitByPrimaryKey
	 *
	 */
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitByPrimaryKey
	 *
	 */
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitByTypeContaining
	 *
	 */
	public Set<StatusOfVisit> findStatusOfVisitByTypeContaining(String type_1) throws DataAccessException;

	/**
	 * JPQL Query - findStatusOfVisitByTypeContaining
	 *
	 */
	public Set<StatusOfVisit> findStatusOfVisitByTypeContaining(String type_1, int startResult, int maxRows) throws DataAccessException;

}