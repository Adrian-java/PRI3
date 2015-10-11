package com.eclinic.dao;

import com.eclinic.domain.SickLeave;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage SickLeave entities.
 * 
 */
public interface SickLeaveDAO extends JpaDao<SickLeave> {

	/**
	 * JPQL Query - findSickLeaveByDateFromAfter
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFromAfter(java.util.Calendar dateFrom) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateFromAfter
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFromAfter(Calendar dateFrom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByPrimaryKey
	 *
	 */
	public SickLeave findSickLeaveByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByPrimaryKey
	 *
	 */
	public SickLeave findSickLeaveByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateFromBefore
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFromBefore(java.util.Calendar dateFrom_1) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateFromBefore
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFromBefore(Calendar dateFrom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveById
	 *
	 */
	public SickLeave findSickLeaveById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveById
	 *
	 */
	public SickLeave findSickLeaveById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateToBefore
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateToBefore(java.util.Calendar dateTo) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateToBefore
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateToBefore(Calendar dateTo, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateTo
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateTo(java.util.Calendar dateTo_1) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateTo
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateTo(Calendar dateTo_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSickLeaves
	 *
	 */
	public Set<SickLeave> findAllSickLeaves() throws DataAccessException;

	/**
	 * JPQL Query - findAllSickLeaves
	 *
	 */
	public Set<SickLeave> findAllSickLeaves(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateToAfter
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateToAfter(java.util.Calendar dateTo_2) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateToAfter
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateToAfter(Calendar dateTo_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateFrom
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFrom(java.util.Calendar dateFrom_2) throws DataAccessException;

	/**
	 * JPQL Query - findSickLeaveByDateFrom
	 *
	 */
	public Set<SickLeave> findSickLeaveByDateFrom(Calendar dateFrom_2, int startResult, int maxRows) throws DataAccessException;

}