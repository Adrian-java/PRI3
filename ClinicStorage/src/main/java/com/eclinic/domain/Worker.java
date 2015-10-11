package com.eclinic.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllWorkers", query = "select myWorker from Worker myWorker"),
		@NamedQuery(name = "findWorkerById", query = "select myWorker from Worker myWorker where myWorker.id = ?1"),
		@NamedQuery(name = "findWorkerByPrimaryKey", query = "select myWorker from Worker myWorker where myWorker.id = ?1") })
@Table(catalog = "eclinic", name = "Worker")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Worker")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Worker implements Serializable {
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
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_patient", referencedColumnName = "id") })
	@XmlTransient
	Patient patient;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_admin", referencedColumnName = "Id") })
	@XmlTransient
	Admin admin;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_recepcionist", referencedColumnName = "Id") })
	@XmlTransient
	Receptionist receptionist;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name = "id_doctor", referencedColumnName = "Id") })
	@XmlTransient
	Doctor doctor;
	/**
	 */
	@OneToMany(mappedBy = "worker", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.LoginHistory> loginHistories;
	/**
	 */
	@OneToMany(mappedBy = "worker", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.SystemUser> systemUsers;

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
	@PreAuthorize("hasRole('admin')")
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 */
	//@JsonIgnore
	@JsonProperty("patient")
	public Patient getPatient() {
		return patient;
	}

	/**
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("admin")
	public Admin getAdmin() {
		return admin;
	}

	/**
	 */
	public void setReceptionist(Receptionist receptionist) {
		this.receptionist = receptionist;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("receptionist")
	public Receptionist getReceptionist() {
		return receptionist;
	}

	/**
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 */
//	@JsonIgnore
	@JsonProperty("doctor")
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 */
	public void setLoginHistories(Set<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
	}

	/**
	 */
	@JsonIgnore
	public Set<LoginHistory> getLoginHistories() {
		if (loginHistories == null) {
			loginHistories = new java.util.LinkedHashSet<com.eclinic.domain.LoginHistory>();
		}
		return loginHistories;
	}

	/**
	 */
	public void setSystemUsers(Set<SystemUser> systemUsers) {
		this.systemUsers = systemUsers;
	}

	/**
	 */
	@JsonIgnore
	public Set<SystemUser> getSystemUsers() {
		if (systemUsers == null) {
			systemUsers = new java.util.LinkedHashSet<com.eclinic.domain.SystemUser>();
		}
		return systemUsers;
	}

	/**
	 */
	public Worker() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Worker that) {
		setId(that.getId());
		setPatient(that.getPatient());
		setAdmin(that.getAdmin());
		setReceptionist(that.getReceptionist());
		setDoctor(that.getDoctor());
		setLoginHistories(new java.util.LinkedHashSet<com.eclinic.domain.LoginHistory>(that.getLoginHistories()));
		setSystemUsers(new java.util.LinkedHashSet<com.eclinic.domain.SystemUser>(that.getSystemUsers()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");

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
		if (!(obj instanceof Worker))
			return false;
		Worker equalCheck = (Worker) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
