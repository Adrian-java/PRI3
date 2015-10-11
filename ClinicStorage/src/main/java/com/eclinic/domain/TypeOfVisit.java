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
		@NamedQuery(name = "findAllTypeOfVisits", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit"),
		@NamedQuery(name = "findTypeOfVisitByDuration", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit where myTypeOfVisit.duration = ?1"),
		@NamedQuery(name = "findTypeOfVisitById", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit where myTypeOfVisit.id = ?1"),
		@NamedQuery(name = "findTypeOfVisitByName", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit where myTypeOfVisit.name = ?1"),
		@NamedQuery(name = "findTypeOfVisitByNameContaining", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit where myTypeOfVisit.name like ?1"),
		@NamedQuery(name = "findTypeOfVisitByPrimaryKey", query = "select myTypeOfVisit from TypeOfVisit myTypeOfVisit where myTypeOfVisit.id = ?1") })
@Table(catalog = "eclinic", name = "Type_Of_Visit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "TypeOfVisit")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class TypeOfVisit implements Serializable {
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

	@Column(name = "name", length = 50, nullable = false)
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

	@Column(name = "duration", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer duration;

	/**
	 */
	@OneToMany(mappedBy = "typeOfVisit", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 */
	public Integer getDuration() {
		return this.duration;
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
	public TypeOfVisit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TypeOfVisit that) {
		setId(that.getId());
		setName(that.getName());
		setDescription(that.getDescription());
		setDuration(that.getDuration());
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(that.getVisits()));
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
		buffer.append("duration=[").append(duration).append("] ");

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
		if (!(obj instanceof TypeOfVisit))
			return false;
		TypeOfVisit equalCheck = (TypeOfVisit) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
