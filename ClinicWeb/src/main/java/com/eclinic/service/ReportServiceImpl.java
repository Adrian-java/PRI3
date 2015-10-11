package com.eclinic.service;

import com.eclinic.dao.ReportDAO;

import com.eclinic.domain.Report;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Report entities
 * 
 */

@Service("ReportService")
@Transactional
public class ReportServiceImpl implements ReportService {

	/**
	 * DAO injected by Spring that manages Report entities
	 * 
	 */
	@Autowired
	private ReportDAO reportDAO;

	/**
	 * Instantiates a new ReportServiceImpl.
	 *
	 */
	public ReportServiceImpl() {
	}

	/**
	 * Save an existing Report entity
	 * 
	 */
	@Transactional
	public void saveReport(Report report) {
		Report existingReport = reportDAO.findReportByPrimaryKey(report.getId());

		if (existingReport != null) {
			if (existingReport != report) {
				existingReport.setId(report.getId());
				existingReport.setDateFrom(report.getDateFrom());
				existingReport.setDateTo(report.getDateTo());
				existingReport.setDescription(report.getDescription());
				existingReport.setReportData(report.getReportData());
			}
			report = reportDAO.store(existingReport);
		} else {
			report = reportDAO.store(report);
		}
		reportDAO.flush();
	}

	/**
	 * Return a count of all Report entity
	 * 
	 */
	@Transactional
	public Integer countReports() {
		return ((Long) reportDAO.createQuerySingleResult("select count(o) from Report o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Report entity
	 * 
	 */
	@Transactional
	public void deleteReport(Report report) {
		reportDAO.remove(report);
		reportDAO.flush();
	}

	/**
	 */
	@Transactional
	public Report findReportByPrimaryKey(Integer id) {
		return reportDAO.findReportByPrimaryKey(id);
	}

	/**
	 * Return all Report entity
	 * 
	 */
	@Transactional
	public List<Report> findAllReports(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Report>(reportDAO.findAllReports(startResult, maxRows));
	}

	/**
	 * Load an existing Report entity
	 * 
	 */
	@Transactional
	public Set<Report> loadReports() {
		return reportDAO.findAllReports();
	}
}
