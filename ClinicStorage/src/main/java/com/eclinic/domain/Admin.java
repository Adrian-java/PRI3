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
		@NamedQuery(name = "findAdminById", query = "select myAdmin from Admin myAdmin where myAdmin.id = ?1"),
		@NamedQuery(name = "findAdminByIsSuper", query = "select myAdmin from Admin myAdmin where myAdmin.isSuper = ?1"),
		@NamedQuery(name = "findAdminByPrimaryKey", query = "select myAdmin from Admin myAdmin where myAdmin.id = ?1"),
		@NamedQuery(name = "findAllAdmins", query = "select myAdmin from Admin myAdmin") })
@Table(catalog = "eclinic", name = "Admin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Admin")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Admin implements Serializable {
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

	@Column(name = "is_super", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isSuper;

	/**
	 */
	@OneToMany(mappedBy = "admin", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Worker> workers;

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
	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}

	/**
	 */
	public Boolean getIsSuper() {
		return this.isSuper;
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
	public Admin() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Admin that) {
		setId(that.getId());
		setIsSuper(that.getIsSuper());
		setWorkers(new java.util.LinkedHashSet<com.eclinic.domain.Worker>(that.getWorkers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("isSuper=[").append(isSuper).append("] ");

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
		if (!(obj instanceof Admin))
			return false;
		Admin equalCheck = (Admin) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
