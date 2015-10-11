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
		@NamedQuery(name = "findAllModules", query = "select myModule from Module myModule"),
		@NamedQuery(name = "findModuleById", query = "select myModule from Module myModule where myModule.id = ?1"),
		@NamedQuery(name = "findModuleByName", query = "select myModule from Module myModule where myModule.name = ?1"),
		@NamedQuery(name = "findModuleByNameContaining", query = "select myModule from Module myModule where myModule.name like ?1"),
		@NamedQuery(name = "findModuleByPrimaryKey", query = "select myModule from Module myModule where myModule.id = ?1"),
		@NamedQuery(name = "findModuleByVisibility", query = "select myModule from Module myModule where myModule.visibility = ?1") })
@Table(catalog = "eclinic", name = "Module")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Module")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Module implements Serializable {
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

	@Column(name = "name", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "visibility", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean visibility;

	/**
	 */
	@OneToMany(mappedBy = "module", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Permission> permissions;

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
	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}

	/**
	 */
	public Boolean getVisibility() {
		return this.visibility;
	}

	/**
	 */
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	/**
	 */
	@JsonIgnore
	public Set<Permission> getPermissions() {
		if (permissions == null) {
			permissions = new java.util.LinkedHashSet<com.eclinic.domain.Permission>();
		}
		return permissions;
	}

	/**
	 */
	public Module() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Module that) {
		setId(that.getId());
		setName(that.getName());
		setVisibility(that.getVisibility());
		setPermissions(new java.util.LinkedHashSet<com.eclinic.domain.Permission>(that.getPermissions()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("visibility=[").append(visibility).append("] ");

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
		if (!(obj instanceof Module))
			return false;
		Module equalCheck = (Module) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
