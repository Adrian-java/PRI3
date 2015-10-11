package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPatientCards", query = "select myPatientCard from PatientCard myPatientCard"),
		@NamedQuery(name = "findPatientCardByPatientId", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.patient = ?1"),
		@NamedQuery(name = "findPatientCardById", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.id = ?1"),
		@NamedQuery(name = "findPatientCardByPrimaryKey", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.id = ?1"),
		@NamedQuery(name = "findPatientCardByRegisterDate", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.registerDate = ?1"),
		@NamedQuery(name = "findPatientCardByRegisterDateAfter", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.registerDate > ?1"),
		@NamedQuery(name = "findPatientCardByRegisterDateBefore", query = "select myPatientCard from PatientCard myPatientCard where myPatientCard.registerDate < ?1") })
@Table(catalog = "eclinic", name = "Patient_Card")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "PatientCard")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class PatientCard implements Serializable {
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
	@Column(name = "register_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar registerDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "id_default_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	/**
	 */
	@OneToMany(mappedBy = "patientCard", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits;

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
	public void setRegisterDate(Calendar registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 */
	public Calendar getRegisterDate() {
		return this.registerDate;
	}

	/**
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("patient")
	public Patient getPatient() {
		return patient;
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
	public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	/**
	 */
	@JsonIgnore
	public Set<Visit> getVisits() {
		if (visits == null) {
			visits = new java.util.LinkedHashSet<com.eclinic.domain.Visit>();
		}
		return visits;
	}

	/**
	 */
	public PatientCard() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(PatientCard that) {
		setId(that.getId());
		setRegisterDate(that.getRegisterDate());
		setPatient(that.getPatient());
		setDoctor(that.getDoctor());
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(that.getVisits()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("registerDate=[").append(registerDate).append("] ");

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
		if (!(obj instanceof PatientCard))
			return false;
		PatientCard equalCheck = (PatientCard) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
