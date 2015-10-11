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
import org.skyway.spring.util.databinding.TypeConversionUtils;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllVisitSchedulers", query = "select myVisitScheduler from VisitScheduler myVisitScheduler"),
		@NamedQuery(name = "findVisitSchedulerById", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.id = ?1"),
		@NamedQuery(name = "findVisitSchedulerByNumberOfDay", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.numberOfDay = ?1"),
		@NamedQuery(name = "findVisitSchedulerByNumberOfMonth", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.numberOfMonth = ?1"),
		@NamedQuery(name = "findVisitSchedulerByPrimaryKey", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.id = ?1"),
		@NamedQuery(name = "findVisitSchedulerByTimeOfVisit", query = "select myVisitScheduler from VisitScheduler myVisitScheduler where myVisitScheduler.timeOfVisit = ?1") })
@Table(catalog = "eclinic", name = "Visit_Scheduler")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "VisitScheduler")
public class VisitScheduler implements Serializable {
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

	@Column(name = "number_of_day", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numberOfDay;
	/**
	 */

	@Column(name = "number_of_month")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer numberOfMonth;
	/**
	 */

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time_of_visit")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar timeOfVisit;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_specialization", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Specialization specialization;
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
	public void setNumberOfDay(Integer numberOfDay) {
		this.numberOfDay = numberOfDay;
	}

	/**
	 */
	public Integer getNumberOfDay() {
		return this.numberOfDay;
	}

	/**
	 */
	public void setNumberOfMonth(Integer numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	/**
	 */
	public Integer getNumberOfMonth() {
		return this.numberOfMonth;
	}

	/**
	 */
	public void setDescription(byte[] description) {
		this.description = description;
	}

	/**
	 */
	public byte[] getDescription() {
		return this.description;
	}

	/**
	 */
	public void setTimeOfVisit(Calendar timeOfVisit) {
		TypeConversionUtils.clearDateFields(timeOfVisit);
		this.timeOfVisit = timeOfVisit;
	}

	/**
	 */
	public Calendar getTimeOfVisit() {
		return this.timeOfVisit;
	}

	/**
	 */
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	/**
	 */
	@JsonIgnore
	public Specialization getSpecialization() {
		return specialization;
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
	public VisitScheduler() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(VisitScheduler that) {
		setId(that.getId());
		setNumberOfDay(that.getNumberOfDay());
		setNumberOfMonth(that.getNumberOfMonth());
		setDescription(that.getDescription());
		setTimeOfVisit(that.getTimeOfVisit());
		setSpecialization(that.getSpecialization());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("numberOfDay=[").append(numberOfDay).append("] ");
		buffer.append("numberOfMonth=[").append(numberOfMonth).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("timeOfVisit=[").append(timeOfVisit).append("] ");

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
		if (!(obj instanceof VisitScheduler))
			return false;
		VisitScheduler equalCheck = (VisitScheduler) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
