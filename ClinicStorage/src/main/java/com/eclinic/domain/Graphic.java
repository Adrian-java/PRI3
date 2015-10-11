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
		@NamedQuery(name = "findAllGraphics", query = "select myGraphic from Graphic myGraphic"),
		@NamedQuery(name = "findGraphicByDay", query = "select myGraphic from Graphic myGraphic where myGraphic.day = ?1"),
		@NamedQuery(name = "findGraphicByDayAfter", query = "select myGraphic from Graphic myGraphic where myGraphic.day > ?1"),
		@NamedQuery(name = "findGraphicByDayBefore", query = "select myGraphic from Graphic myGraphic where myGraphic.day < ?1"),
		@NamedQuery(name = "findGraphicById", query = "select myGraphic from Graphic myGraphic where myGraphic.id = ?1"),
		@NamedQuery(name = "findGraphicByPrimaryKey", query = "select myGraphic from Graphic myGraphic where myGraphic.id = ?1") })
@Table(catalog = "eclinic", name = "Graphic")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Graphic")
public class Graphic implements Serializable {
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

	@Column(name = "absence", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] absence;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "day", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar day;

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
	public void setAbsence(byte[] absence) {
		this.absence = absence;
	}

	/**
	 */
	public byte[] getAbsence() {
		return this.absence;
	}

	/**
	 */
	public void setDay(Calendar day) {
		this.day = day;
	}

	/**
	 */
	public Calendar getDay() {
		return this.day;
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
	public Graphic() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Graphic that) {
		setId(that.getId());
		setAbsence(that.getAbsence());
		setDay(that.getDay());
		setDoctor(that.getDoctor());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("absence=[").append(absence).append("] ");
		buffer.append("day=[").append(day).append("] ");

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
		if (!(obj instanceof Graphic))
			return false;
		Graphic equalCheck = (Graphic) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
