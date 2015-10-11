package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllApplicationParameters", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter"),
		@NamedQuery(name = "findApplicationParameterById", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.id = ?1"),
		@NamedQuery(name = "findApplicationParameterByKey", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.key = ?1"),
		@NamedQuery(name = "findApplicationParameterByKeyContaining", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.key like ?1"),
		@NamedQuery(name = "findApplicationParameterByPrimaryKey", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.id = ?1"),
		@NamedQuery(name = "findApplicationParameterByValueNumber", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.valueNumber = ?1"),
		@NamedQuery(name = "findApplicationParameterByValueString", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.valueString = ?1"),
		@NamedQuery(name = "findApplicationParameterByValueStringContaining", query = "select myApplicationParameter from ApplicationParameter myApplicationParameter where myApplicationParameter.valueString like ?1") })
@Table(catalog = "eclinic", name = "Application_Parameter")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "ApplicationParameter")
public class ApplicationParameter implements Serializable {
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

	@Column(name = "key", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String key;
	/**
	 */

	@Column(name = "value_string", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String valueString;
	/**
	 */

	@Column(name = "value_number", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer valueNumber;

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
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 */
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	/**
	 */
	public String getValueString() {
		return this.valueString;
	}

	/**
	 */
	public void setValueNumber(Integer valueNumber) {
		this.valueNumber = valueNumber;
	}

	/**
	 */
	public Integer getValueNumber() {
		return this.valueNumber;
	}

	/**
	 */
	public ApplicationParameter() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ApplicationParameter that) {
		setId(that.getId());
		setKey(that.getKey());
		setValueString(that.getValueString());
		setValueNumber(that.getValueNumber());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("key=[").append(key).append("] ");
		buffer.append("valueString=[").append(valueString).append("] ");
		buffer.append("valueNumber=[").append(valueNumber).append("] ");

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
		if (!(obj instanceof ApplicationParameter))
			return false;
		ApplicationParameter equalCheck = (ApplicationParameter) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
