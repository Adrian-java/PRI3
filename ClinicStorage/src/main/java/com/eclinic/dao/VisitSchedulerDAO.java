package com.eclinic.dao;

import com.eclinic.domain.VisitScheduler;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage VisitScheduler entities.
 * 
 */
public interface VisitSchedulerDAO extends JpaDao<VisitScheduler> {

	/**
	 * JPQL Query - findAllVisitSchedulers
	 *
	 */
	public Set<VisitScheduler> findAllVisitSchedulers() throws DataAccessException;

	/**
	 * JPQL Query - findAllVisitSchedulers
	 *
	 */
	public Set<VisitScheduler> findAllVisitSchedulers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfDay
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByNumberOfDay(Integer numberOfDay) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfDay
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByNumberOfDay(Integer numberOfDay, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfMonth
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByNumberOfMonth(Integer numberOfMonth) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByNumberOfMonth
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByNumberOfMonth(Integer numberOfMonth, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByTimeOfVisit
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByTimeOfVisit(java.util.Calendar timeOfVisit) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByTimeOfVisit
	 *
	 */
	public Set<VisitScheduler> findVisitSchedulerByTimeOfVisit(Calendar timeOfVisit, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerById
	 *
	 */
	public VisitScheduler findVisitSchedulerById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerById
	 *
	 */
	public VisitScheduler findVisitSchedulerById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByPrimaryKey
	 *
	 */
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findVisitSchedulerByPrimaryKey
	 *
	 */
	public VisitScheduler findVisitSchedulerByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}