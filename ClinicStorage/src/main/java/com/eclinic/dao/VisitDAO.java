package com.eclinic.dao;

import com.eclinic.domain.Visit;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Visit entities.
 * 
 */
public interface VisitDAO extends JpaDao<Visit> {

	/**
	 * JPQL Query - findVisitByIsLeave
	 *
	 */
	public Set<Visit> findVisitByIsLeave(Boolean isLeave)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitByIsLeave
	 *
	 */
	public Set<Visit> findVisitByIsLeave(Boolean isLeave, int startResult,
			int maxRows) throws DataAccessException;

	public Set<Visit> findVisitByPesel(String pesel) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisit
	 *
	 */
	public Set<Visit> findVisitByDateOfVisit(java.util.Calendar dateOfVisit)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisit
	 *
	 */
	public Set<Visit> findVisitByDateOfVisit(Calendar dateOfVisit,
			int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByPrimaryKey
	 *
	 */
	public Visit findVisitByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByPrimaryKey
	 *
	 */
	public Visit findVisitByPrimaryKey(Integer id, int startResult, int maxRows)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitById
	 *
	 */
	public Visit findVisitById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findVisitById
	 *
	 */
	public Visit findVisitById(Integer id_1, int startResult, int maxRows)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisitAfter
	 *
	 */
	public Set<Visit> findVisitByDateOfVisitAfter(
			java.util.Calendar dateOfVisit_1) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisitAfter
	 *
	 */
	public Set<Visit> findVisitByDateOfVisitAfter(Calendar dateOfVisit_1,
			int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllVisits
	 *
	 */
	public Set<Visit> findAllVisits() throws DataAccessException;

	/**
	 * JPQL Query - findAllVisits
	 *
	 */
	public Set<Visit> findAllVisits(int startResult, int maxRows)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitBySpecial
	 *
	 */
	public Set<Visit> findVisitBySpecial(Boolean special)
			throws DataAccessException;

	/**
	 * JPQL Query - findVisitBySpecial
	 *
	 */
	public Set<Visit> findVisitBySpecial(Boolean special, int startResult,
			int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisitBefore
	 *
	 */
	public Set<Visit> findVisitByDateOfVisitBefore(
			java.util.Calendar dateOfVisit_2) throws DataAccessException;

	/**
	 * JPQL Query - findVisitByDateOfVisitBefore
	 *
	 */
	public Set<Visit> findVisitByDateOfVisitBefore(Calendar dateOfVisit_2,
			int startResult, int maxRows) throws DataAccessException;

}