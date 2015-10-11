package com.eclinic.dao;

import com.eclinic.domain.Report;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Report entities.
 * 
 */
public interface ReportDAO extends JpaDao<Report> {

	/**
	 * JPQL Query - findReportByDateTo
	 *
	 */
	public Set<Report> findReportByDateTo(java.util.Calendar dateTo) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateTo
	 *
	 */
	public Set<Report> findReportByDateTo(Calendar dateTo, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFromAfter
	 *
	 */
	public Set<Report> findReportByDateFromAfter(java.util.Calendar dateFrom) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFromAfter
	 *
	 */
	public Set<Report> findReportByDateFromAfter(Calendar dateFrom, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFrom
	 *
	 */
	public Set<Report> findReportByDateFrom(java.util.Calendar dateFrom_1) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFrom
	 *
	 */
	public Set<Report> findReportByDateFrom(Calendar dateFrom_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDescription
	 *
	 */
	public Set<Report> findReportByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDescription
	 *
	 */
	public Set<Report> findReportByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByPrimaryKey
	 *
	 */
	public Report findReportByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findReportByPrimaryKey
	 *
	 */
	public Report findReportByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDescriptionContaining
	 *
	 */
	public Set<Report> findReportByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDescriptionContaining
	 *
	 */
	public Set<Report> findReportByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateToBefore
	 *
	 */
	public Set<Report> findReportByDateToBefore(java.util.Calendar dateTo_1) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateToBefore
	 *
	 */
	public Set<Report> findReportByDateToBefore(Calendar dateTo_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllReports
	 *
	 */
	public Set<Report> findAllReports() throws DataAccessException;

	/**
	 * JPQL Query - findAllReports
	 *
	 */
	public Set<Report> findAllReports(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateToAfter
	 *
	 */
	public Set<Report> findReportByDateToAfter(java.util.Calendar dateTo_2) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateToAfter
	 *
	 */
	public Set<Report> findReportByDateToAfter(Calendar dateTo_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportById
	 *
	 */
	public Report findReportById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findReportById
	 *
	 */
	public Report findReportById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFromBefore
	 *
	 */
	public Set<Report> findReportByDateFromBefore(java.util.Calendar dateFrom_2) throws DataAccessException;

	/**
	 * JPQL Query - findReportByDateFromBefore
	 *
	 */
	public Set<Report> findReportByDateFromBefore(Calendar dateFrom_2, int startResult, int maxRows) throws DataAccessException;

}