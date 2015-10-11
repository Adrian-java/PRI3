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
		@NamedQuery(name = "findAllStatusOfVisits", query = "select myStatusOfVisit from StatusOfVisit myStatusOfVisit"),
		@NamedQuery(name = "findStatusOfVisitById", query = "select myStatusOfVisit from StatusOfVisit myStatusOfVisit where myStatusOfVisit.id = ?1"),
		@NamedQuery(name = "findStatusOfVisitByPrimaryKey", query = "select myStatusOfVisit from StatusOfVisit myStatusOfVisit where myStatusOfVisit.id = ?1"),
		@NamedQuery(name = "findStatusOfVisitByType", query = "select myStatusOfVisit from StatusOfVisit myStatusOfVisit where myStatusOfVisit.type = ?1"),
		@NamedQuery(name = "findStatusOfVisitByTypeContaining", query = "select myStatusOfVisit from StatusOfVisit myStatusOfVisit where myStatusOfVisit.type like ?1") })
@Table(catalog = "eclinic", name = "Status_Of_Visit")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "StatusOfVisit")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class StatusOfVisit implements Serializable {
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

	@Column(name = "type", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String type;

	/**
	 */
	@OneToMany(mappedBy = "statusOfVisit", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	public void setType(String type) {
		this.type = type;
	}

	/**
	 */
	public String getType() {
		return this.type;
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
	public StatusOfVisit() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(StatusOfVisit that) {
		setId(that.getId());
		setType(that.getType());
		setVisits(new java.util.LinkedHashSet<com.eclinic.domain.Visit>(that.getVisits()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("type=[").append(type).append("] ");

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
		if (!(obj instanceof StatusOfVisit))
			return false;
		StatusOfVisit equalCheck = (StatusOfVisit) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
