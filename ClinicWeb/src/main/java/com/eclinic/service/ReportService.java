package com.eclinic.service;

import com.eclinic.domain.Report;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Report entities
 * 
 */
public interface ReportService {

	/**
	 * Save an existing Report entity
	 * 
	 */
	public void saveReport(Report report);

	/**
	 * Return a count of all Report entity
	 * 
	 */
	public Integer countReports();

	/**
	 * Delete an existing Report entity
	 * 
	 */
	public void deleteReport(Report report_1);

	/**
	 */
	public Report findReportByPrimaryKey(Integer id);

	/**
	 * Return all Report entity
	 * 
	 */
	public List<Report> findAllReports(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Report entity
	 * 
	 */
	public Set<Report> loadReports();
}