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
		@NamedQuery(name = "findAllRecipes", query = "select myRecipe from Recipe myRecipe"),
		@NamedQuery(name = "findRecipeByDate", query = "select myRecipe from Recipe myRecipe where myRecipe.date = ?1"),
		@NamedQuery(name = "findRecipeByDateAfter", query = "select myRecipe from Recipe myRecipe where myRecipe.date > ?1"),
		@NamedQuery(name = "findRecipeByDateBefore", query = "select myRecipe from Recipe myRecipe where myRecipe.date < ?1"),
		@NamedQuery(name = "findRecipeByIdr", query = "select myRecipe from Recipe myRecipe where myRecipe.idr = ?1"),
		@NamedQuery(name = "findRecipeByPrimaryKey", query = "select myRecipe from Recipe myRecipe where myRecipe.idr = ?1") })
@Table(catalog = "eclinic", name = "Recipe")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Recipe")
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Idr", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@XmlElement
	Integer idr;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	/**
	 */

	@Column(name = "drug", nullable = false, columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] drug;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id") })
	@XmlTransient
	Doctor doctor;

	/**
	 */
	public void setIdr(Integer idr) {
		this.idr = idr;
	}

	/**
	 */
	public Integer getIdr() {
		return this.idr;
	}

	/**
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 */
	public Calendar getDate() {
		return this.date;
	}

	/**
	 */
	public void setDrug(byte[] drug) {
		this.drug = drug;
	}

	/**
	 */
	public byte[] getDrug() {
		return this.drug;
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
	public Recipe() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Recipe that) {
		setIdr(that.getIdr());
		setDate(that.getDate());
		setDrug(that.getDrug());
		setPatient(that.getPatient());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("idr=[").append(idr).append("] ");
		buffer.append("date=[").append(date).append("] ");
		buffer.append("drug=[").append(drug).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((idr == null) ? 0 : idr.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Recipe))
			return false;
		Recipe equalCheck = (Recipe) obj;
		if ((idr == null && equalCheck.idr != null) || (idr != null && equalCheck.idr == null))
			return false;
		if (idr != null && !idr.equals(equalCheck.idr))
			return false;
		return true;
	}
}
