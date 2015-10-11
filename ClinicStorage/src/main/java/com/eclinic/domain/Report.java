package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllReports", query = "select myReport from Report myReport"),
		@NamedQuery(name = "findReportByDateFrom", query = "select myReport from Report myReport where myReport.dateFrom = ?1"),
		@NamedQuery(name = "findReportByDateFromAfter", query = "select myReport from Report myReport where myReport.dateFrom > ?1"),
		@NamedQuery(name = "findReportByDateFromBefore", query = "select myReport from Report myReport where myReport.dateFrom < ?1"),
		@NamedQuery(name = "findReportByDateTo", query = "select myReport from Report myReport where myReport.dateTo = ?1"),
		@NamedQuery(name = "findReportByDateToAfter", query = "select myReport from Report myReport where myReport.dateTo > ?1"),
		@NamedQuery(name = "findReportByDateToBefore", query = "select myReport from Report myReport where myReport.dateTo < ?1"),
		@NamedQuery(name = "findReportByDescription", query = "select myReport from Report myReport where myReport.description = ?1"),
		@NamedQuery(name = "findReportByDescriptionContaining", query = "select myReport from Report myReport where myReport.description like ?1"),
		@NamedQuery(name = "findReportById", query = "select myReport from Report myReport where myReport.id = ?1"),
		@NamedQuery(name = "findReportByPrimaryKey", query = "select myReport from Report myReport where myReport.id = ?1") })
@Table(catalog = "eclinic", name = "Report")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Report")
public class Report implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer id;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_from", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateFrom;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date_to")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateTo;
	/**
	 */

	@Column(name = "description", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "report_data", nullable = false, columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] reportData;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setDateFrom(Calendar dateFrom) {
		this.dateFrom = dateFrom;
	}

	/**
	 */
	public Calendar getDateFrom() {
		return this.dateFrom;
	}

	/**
	 */
	public void setDateTo(Calendar dateTo) {
		this.dateTo = dateTo;
	}

	/**
	 */
	public Calendar getDateTo() {
		return this.dateTo;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setReportData(byte[] reportData) {
		this.reportData = reportData;
	}

	/**
	 */
	public byte[] getReportData() {
		return this.reportData;
	}

	/**
	 */
	public Report() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Report that) {
		setId(that.getId());
		setDateFrom(that.getDateFrom());
		setDateTo(that.getDateTo());
		setDescription(that.getDescription());
		setReportData(that.getReportData());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("dateFrom=[").append(dateFrom).append("] ");
		buffer.append("dateTo=[").append(dateTo).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("reportData=[").append(reportData).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Report))
			return false;
		Report equalCheck = (Report) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
