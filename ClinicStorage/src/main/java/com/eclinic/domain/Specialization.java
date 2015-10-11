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

import javax.xml.bind.annotation.*;
import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllSpecializations", query = "select mySpecialization from Specialization mySpecialization"),
		@NamedQuery(name = "findSpecializationById", query = "select mySpecialization from Specialization mySpecialization where mySpecialization.id = ?1"),
		@NamedQuery(name = "findSpecializationByName", query = "select mySpecialization from Specialization mySpecialization where mySpecialization.name = ?1"),
		@NamedQuery(name = "findSpecializationByNameContaining", query = "select mySpecialization from Specialization mySpecialization where mySpecialization.name like ?1"),
		@NamedQuery(name = "findSpecializationByPrimaryKey", query = "select mySpecialization from Specialization mySpecialization where mySpecialization.id = ?1") })
@Table(catalog = "eclinic", name = "Specialization")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Specialization")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Specialization implements Serializable {
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

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Doctor doctor;
	/**
	 */
	@OneToMany(mappedBy = "specialization", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.SpecalVisitField> specalVisitFields;
	/**
	 */
	@OneToMany(mappedBy = "specialization", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.VisitScheduler> visitSchedulers;

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
	public void setSpecalVisitFields(Set<SpecalVisitField> specalVisitFields) {
		this.specalVisitFields = specalVisitFields;
	}

	/**
	 */
	@JsonIgnore
	public Set<SpecalVisitField> getSpecalVisitFields() {
		if (specalVisitFields == null) {
			specalVisitFields = new java.util.LinkedHashSet<com.eclinic.domain.SpecalVisitField>();
		}
		return specalVisitFields;
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
	public Specialization() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Specialization that) {
		setId(that.getId());
		setName(that.getName());
		setDescription(that.getDescription());
		setDoctor(that.getDoctor());
		setSpecalVisitFields(new java.util.LinkedHashSet<com.eclinic.domain.SpecalVisitField>(that.getSpecalVisitFields()));
		setVisitSchedulers(new java.util.LinkedHashSet<com.eclinic.domain.VisitScheduler>(that.getVisitSchedulers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("description=[").append(description).append("] ");

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
		if (!(obj instanceof Specialization))
			return false;
		Specialization equalCheck = (Specialization) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
