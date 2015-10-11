package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSickLeaves", query = "select mySickLeave from SickLeave mySickLeave"),
		@NamedQuery(name = "findSickLeaveByDateFrom", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateFrom = ?1"),
		@NamedQuery(name = "findSickLeaveByDateFromAfter", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateFrom > ?1"),
		@NamedQuery(name = "findSickLeaveByDateFromBefore", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateFrom < ?1"),
		@NamedQuery(name = "findSickLeaveByDateTo", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateTo = ?1"),
		@NamedQuery(name = "findSickLeaveByDateToAfter", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateTo > ?1"),
		@NamedQuery(name = "findSickLeaveByDateToBefore", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.dateTo < ?1"),
		@NamedQuery(name = "findSickLeaveById", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.id = ?1"),
		@NamedQuery(name = "findSickLeaveByPrimaryKey", query = "select mySickLeave from SickLeave mySickLeave where mySickLeave.id = ?1") })
@Table(catalog = "eclinic", name = "Sick_Leave")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SickLeave")
public class SickLeave implements Serializable {
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
	@Column(name = "date_to", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateTo;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_visit", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Visit visit;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;

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
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
	@JsonIgnore
	public Patient getPatient() {
		return patient;
	}

	/**
	 */
	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	/**
	 */
	@JsonIgnore
	public Visit getVisit() {
		return visit;
	}

	/**
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 */
	@JsonIgnore
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 */
	public SickLeave() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(SickLeave that) {
		setId(that.getId());
		setDateFrom(that.getDateFrom());
		setDateTo(that.getDateTo());
		setPatient(that.getPatient());
		setVisit(that.getVisit());
		setDoctor(that.getDoctor());
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
		if (!(obj instanceof SickLeave))
			return false;
		SickLeave equalCheck = (SickLeave) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
