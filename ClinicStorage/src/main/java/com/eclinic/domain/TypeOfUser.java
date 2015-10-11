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
		@NamedQuery(name = "findAllTypeOfUsers", query = "select myTypeOfUser from TypeOfUser myTypeOfUser"),
		@NamedQuery(name = "findTypeOfUserById", query = "select myTypeOfUser from TypeOfUser myTypeOfUser where myTypeOfUser.id = ?1"),
		@NamedQuery(name = "findTypeOfUserByPrimaryKey", query = "select myTypeOfUser from TypeOfUser myTypeOfUser where myTypeOfUser.id = ?1"),
		@NamedQuery(name = "findTypeOfUserByType", query = "select myTypeOfUser from TypeOfUser myTypeOfUser where myTypeOfUser.type = ?1"),
		@NamedQuery(name = "findTypeOfUserByTypeContaining", query = "select myTypeOfUser from TypeOfUser myTypeOfUser where myTypeOfUser.type like ?1") })
@Table(catalog = "eclinic", name = "Type_Of_User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "TypeOfUser")
public class TypeOfUser implements Serializable {
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

	@Column(name = "type", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String type;
	/**
	 */

	@Column(name = "description", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	byte[] description;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "id_permission", referencedColumnName = "Id", nullable = false) })
	@XmlTransient
	Permission permission;

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
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/**
	 */
	@JsonIgnore
	public Permission getPermission() {
		return permission;
	}

	/**
	 */
	public TypeOfUser() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(TypeOfUser that) {
		setId(that.getId());
		setType(that.getType());
		setDescription(that.getDescription());
		setPermission(that.getPermission());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("type=[").append(type).append("] ");
		buffer.append("description=[").append(description).append("] ");

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
		if (!(obj instanceof TypeOfUser))
			return false;
		TypeOfUser equalCheck = (TypeOfUser) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
