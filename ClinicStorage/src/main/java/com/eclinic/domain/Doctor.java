package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
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
		@NamedQuery(name = "findAllDoctors", query = "select myDoctor from Doctor myDoctor"),
		@NamedQuery(name = "findDoctorById", query = "select myDoctor from Doctor myDoctor where myDoctor.id = ?1"),
		@NamedQuery(name = "findDoctorByName", query = "select myDoctor from Doctor myDoctor where myDoctor.name = ?1"),
		@NamedQuery(name = "findDoctorByNameContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.name like ?1"),
		@NamedQuery(name = "findDoctorByPrimaryKey", query = "select myDoctor from Doctor myDoctor where myDoctor.id = ?1"),
		@NamedQuery(name = "findDoctorBySurname", query = "select myDoctor from Doctor myDoctor where myDoctor.surname = ?1"),
		@NamedQuery(name = "findDoctorBySurnameContaining", query = "select myDoctor from Doctor myDoctor where myDoctor.surname like ?1") })
@Table(catalog = "eclinic", name = "Doctor")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Doctor")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Doctor implements Serializable {
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

	@Column(name = "name", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "surname", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String surname;

	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Specialization> specializations;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.PatientCard> patientCards;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Recipe> recipes;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Graphic> graphics;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Visit> visits;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Worker> workers;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.VisitScheduler> visitSchedulers;
	/**
	 */
	@OneToMany(mappedBy = "doctor", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	// @XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.SickLeave> sickLeaves;

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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 */
	public String getSurname() {
		return this.surname;
	}

	/**
	 */
	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}

	/**
	 */
	// @JsonIgnore
	@JsonProperty("specialization")
	public Set<Specialization> getSpecializations() {
		if (specializations == null) {
			specializations = new java.util.LinkedHashSet<com.eclinic.domain.Specialization>();
		}
		return specializations;
	}

	/**
	 */
	public void setPatientCards(Set<PatientCard> patientCards) {
		this.patientCards = patientCards;
	}

	/**
	 */
	@JsonIgnore
	public Set<PatientCard> getPatientCards() {
		if (patientCards == null) {
			patientCards = new java.util.LinkedHashSet<com.eclinic.domain.PatientCard>();
		}
		return patientCards;
	}

	/**
	 */
	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	/**
	 */
	@JsonIgnore
	public Set<Recipe> getRecipes() {
		if (recipes == null) {
			recipes = new java.util.LinkedHashSet<com.eclinic.domain.Recipe>();
		}
		return recipes;
	}

	/**
	 */
	public void setGraphics(Set<Graphic> graphics) {
		this.graphics = graphics;
	}

	/**
	 */
	@JsonIgnore
	public Set<Graphic> getGraphics() {
		if (graphics == null) {
			graphics = new java.util.LinkedHashSet<com.eclinic.domain.Graphic>();
		}
		return graphics;
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
	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}

	/**
	 */
	@JsonIgnore
	public Set<Worker> getWorkers() {
		if (workers == null) {
			workers = new java.util.LinkedHashSet<com.eclinic.domain.Worker>();
		}
		return workers;
	}

	/**
	 */
	public void setVisitSchedulers(Set<VisitScheduler> visitSchedulers) {
		this.visitSchedulers = visitSchedulers;
	}

	/**
	 */
	@JsonIgnore
	public Set<VisitScheduler> getVisitSchedulers() {
		if (visitSchedulers == null) {
			visitSchedulers = new java.util.LinkedHashSet<com.eclinic.domain.VisitScheduler>();
		}
		return visitSchedulers;
	}

	/**
	 */
	public void setSickLeaves(Set<SickLeave> sickLeaves) {
		this.sickLeaves = sickLeaves;
	}

	/**
	 */
	@JsonIgnore
	public Set<SickLeave> getSickLeaves() {
		if (sickLeaves == null) {
			sickLeaves = new java.util.LinkedHashSet<com.eclinic.domain.SickLeave>();
		}
		return sickLeaves;
	}

	/**
	 */
	public Doctor() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Doctor that) {
		if (that.getId() != null)
			setId(that.getId());
		if (that.getName() != null)
			setName(that.getName());
		if (that.getSurname() != null)
			setSurname(that.getSurname());
		setSpecializations(new java.util.LinkedHashSet<com.eclinic.domain.Specialization>(
				that.getSpecializations()));
		setPatientCards(new java.util.LinkedHashSet<com.eclinic.domain.PatientCard>(
				that.getPatientCards()));
		setRecipes(new java.util.LinkedHashSet<com.eclinic.domain.Recipe>(
				that.getRecipes()));
		setGraphics(new java.util.LinkedHashSet<com.eclinic.domain.Graphic>(
				that.getGraphics()));
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(
				that.getVisits()));
		setWorkers(new java.util.LinkedHashSet<com.eclinic.domain.Worker>(
				that.getWorkers()));
		setVisitSchedulers(new java.util.LinkedHashSet<com.eclinic.domain.VisitScheduler>(
				that.getVisitSchedulers()));
		setSickLeaves(new java.util.LinkedHashSet<com.eclinic.domain.SickLeave>(
				that.getSickLeaves()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("surname=[").append(surname).append("] ");

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
		if (!(obj instanceof Doctor))
			return false;
		Doctor equalCheck = (Doctor) obj;
		if ((id == null && equalCheck.id != null)
				|| (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
