package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.lang.StringBuilder;
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
		@NamedQuery(name = "findAllSpecalVisitFields", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField"),
		@NamedQuery(name = "findSpecalVisitFieldById", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.id = ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByName", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.name = ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByNameContaining", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.name like ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByPrimaryKey", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.id = ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByTypeOfValue", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.typeOfValue = ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByTypeOfValueContaining", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.typeOfValue like ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByValue", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.value = ?1"),
		@NamedQuery(name = "findSpecalVisitFieldByValueContaining", query = "select mySpecalVisitField from SpecalVisitField mySpecalVisitField where mySpecalVisitField.value like ?1") })
@Table(catalog = "eclinic", name = "Specal_Visit_Field")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "SpecalVisitField")
public class SpecalVisitField implements Serializable {
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

	@Column(name = "name", length = 40, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "value", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String value;
	/**
	 */

	@Column(name = "type_of_value", length = 40, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String typeOfValue;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_specialization", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Specialization specialization;

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
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 */
	public void setTypeOfValue(String typeOfValue) {
		this.typeOfValue = typeOfValue;
	}

	/**
	 */
	public String getTypeOfValue() {
		return this.typeOfValue;
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
	public SpecalVisitField() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(SpecalVisitField that) {
		setId(that.getId());
		setName(that.getName());
		setValue(that.getValue());
		setTypeOfValue(that.getTypeOfValue());
		setSpecialization(that.getSpecialization());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("value=[").append(value).append("] ");
		buffer.append("typeOfValue=[").append(typeOfValue).append("] ");

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
		if (!(obj instanceof SpecalVisitField))
			return false;
		SpecalVisitField equalCheck = (SpecalVisitField) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
