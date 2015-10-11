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
		@NamedQuery(name = "findAllSystemErrors", query = "select mySystemError from SystemError mySystemError"),
		@NamedQuery(name = "findSystemErrorByDate", query = "select mySystemError from SystemError mySystemError where mySystemError.date = ?1"),
		@NamedQuery(name = "findSystemErrorById", query = "select mySystemError from SystemError mySystemError where mySystemError.id = ?1"),
		@NamedQuery(name = "findSystemErrorByPrimaryKey", query = "select mySystemError from SystemError mySystemError where mySystemError.id = ?1") })
@Table(catalog = "eclinic", name = "System_Error")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SystemError")
public class SystemError implements Serializable {
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar date;
	/**
	 */

	@Column(name = "generated_error_description", nullable = false, columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] generatedErrorDescription;
	/**
	 */

	@Column(name = "fixed", nullable = false, columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] fixed;

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
	public void setGeneratedErrorDescription(byte[] generatedErrorDescription) {
		this.generatedErrorDescription = generatedErrorDescription;
	}

	/**
	 */
	public byte[] getGeneratedErrorDescription() {
		return this.generatedErrorDescription;
	}

	/**
	 */
	public void setFixed(byte[] fixed) {
		this.fixed = fixed;
	}

	/**
	 */
	public byte[] getFixed() {
		return this.fixed;
	}

	/**
	 */
	public SystemError() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(SystemError that) {
		setId(that.getId());
		setDate(that.getDate());
		setGeneratedErrorDescription(that.getGeneratedErrorDescription());
		setFixed(that.getFixed());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("date=[").append(date).append("] ");
		buffer.append("generatedErrorDescription=[").append(generatedErrorDescription).append("] ");
		buffer.append("fixed=[").append(fixed).append("] ");

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
		if (!(obj instanceof SystemError))
			return false;
		SystemError equalCheck = (SystemError) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
