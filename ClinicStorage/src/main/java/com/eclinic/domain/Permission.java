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
		@NamedQuery(name = "findAllPermissions", query = "select myPermission from Permission myPermission"),
		@NamedQuery(name = "findPermissionByDisplay", query = "select myPermission from Permission myPermission where myPermission.display = ?1"),
		@NamedQuery(name = "findPermissionByEdit", query = "select myPermission from Permission myPermission where myPermission.edit = ?1"),
		@NamedQuery(name = "findPermissionByExecute", query = "select myPermission from Permission myPermission where myPermission.execute = ?1"),
		@NamedQuery(name = "findPermissionById", query = "select myPermission from Permission myPermission where myPermission.id = ?1"),
		@NamedQuery(name = "findPermissionByPrimaryKey", query = "select myPermission from Permission myPermission where myPermission.id = ?1") })
@Table(catalog = "eclinic", name = "Permission")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Permission")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Permission implements Serializable {
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

	@Column(name = "display")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean display;
	/**
	 */

	@Column(name = "edit")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean edit;
	/**
	 */

	@Column(name = "execute")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean execute;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_system_user", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	SystemUser systemUser;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_module", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Module module;
	/**
	 */
	@OneToMany(mappedBy = "permission", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.TypeOfUser> typeOfUsers;

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
	public void setDisplay(Boolean display) {
		this.display = display;
	}

	/**
	 */
	public Boolean getDisplay() {
		return this.display;
	}

	/**
	 */
	public void setEdit(Boolean edit) {
		this.edit = edit;
	}

	/**
	 */
	public Boolean getEdit() {
		return this.edit;
	}

	/**
	 */
	public void setExecute(Boolean execute) {
		this.execute = execute;
	}

	/**
	 */
	public Boolean getExecute() {
		return this.execute;
	}

	/**
	 */
	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}

	/**
	 */
	@JsonIgnore
	public SystemUser getSystemUser() {
		return systemUser;
	}

	/**
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 */
	@JsonIgnore
	public Module getModule() {
		return module;
	}

	/**
	 */
	public void setTypeOfUsers(Set<TypeOfUser> typeOfUsers) {
		this.typeOfUsers = typeOfUsers;
	}

	/**
	 */
	@JsonIgnore
	public Set<TypeOfUser> getTypeOfUsers() {
		if (typeOfUsers == null) {
			typeOfUsers = new java.util.LinkedHashSet<com.eclinic.domain.TypeOfUser>();
		}
		return typeOfUsers;
	}

	/**
	 */
	public Permission() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Permission that) {
		setId(that.getId());
		setDisplay(that.getDisplay());
		setEdit(that.getEdit());
		setExecute(that.getExecute());
		setSystemUser(that.getSystemUser());
		setModule(that.getModule());
		setTypeOfUsers(new java.util.LinkedHashSet<com.eclinic.domain.TypeOfUser>(that.getTypeOfUsers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("display=[").append(display).append("] ");
		buffer.append("edit=[").append(edit).append("] ");
		buffer.append("execute=[").append(execute).append("] ");

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
		if (!(obj instanceof Permission))
			return false;
		Permission equalCheck = (Permission) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
