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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAddressByCity", query = "select myAddress from Address myAddress where myAddress.city = ?1"),
		@NamedQuery(name = "findAddressByCityContaining", query = "select myAddress from Address myAddress where myAddress.city like ?1"),
		@NamedQuery(name = "findAddressByCountry", query = "select myAddress from Address myAddress where myAddress.country = ?1"),
		@NamedQuery(name = "findAddressByCountryCode", query = "select myAddress from Address myAddress where myAddress.countryCode = ?1"),
		@NamedQuery(name = "findAddressByCountryCodeCity", query = "select myAddress from Address myAddress where myAddress.countryCodeCity = ?1"),
		@NamedQuery(name = "findAddressByCountryCodeCityContaining", query = "select myAddress from Address myAddress where myAddress.countryCodeCity like ?1"),
		@NamedQuery(name = "findAddressByCountryCodeContaining", query = "select myAddress from Address myAddress where myAddress.countryCode like ?1"),
		@NamedQuery(name = "findAddressByCountryContaining", query = "select myAddress from Address myAddress where myAddress.country like ?1"),
		@NamedQuery(name = "findAddressByHomeNr", query = "select myAddress from Address myAddress where myAddress.homeNr = ?1"),
		@NamedQuery(name = "findAddressByHomeNrContaining", query = "select myAddress from Address myAddress where myAddress.homeNr like ?1"),
		@NamedQuery(name = "findAddressById", query = "select myAddress from Address myAddress where myAddress.id = ?1"),
		@NamedQuery(name = "findAddressByPrimaryKey", query = "select myAddress from Address myAddress where myAddress.id = ?1"),
		@NamedQuery(name = "findAddressByProvince", query = "select myAddress from Address myAddress where myAddress.province = ?1"),
		@NamedQuery(name = "findAddressByProvinceContaining", query = "select myAddress from Address myAddress where myAddress.province like ?1"),
		@NamedQuery(name = "findAllAddresss", query = "select myAddress from Address myAddress") })
@Table(catalog = "eclinic", name = "Address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wee/com/eclinic/domain", name = "Address")
@XmlRootElement(namespace = "wee/com/eclinic/domain")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = IDENTITY)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "city", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "country_code", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String countryCode;
	/**
	 */

	@Column(name = "province", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String province;
	/**
	 */

	@Column(name = "country", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String country;
	/**
	 */

	@Column(name = "country_code_city", length = 20, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String countryCodeCity;
	/**
	 */

	@Column(name = "home_nr", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String homeNr;

	/**
	 */
	@OneToMany(mappedBy = "address", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@XmlElement(name = "", namespace = "")
	java.util.Set<com.eclinic.domain.Patient> patients;

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
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 */
	public String getProvince() {
		return this.province;
	}

	/**
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 */
	public void setCountryCodeCity(String countryCodeCity) {
		this.countryCodeCity = countryCodeCity;
	}

	/**
	 */
	public String getCountryCodeCity() {
		return this.countryCodeCity;
	}

	/**
	 */
	public void setHomeNr(String homeNr) {
		this.homeNr = homeNr;
	}

	/**
	 */
	public String getHomeNr() {
		return this.homeNr;
	}

	/**
	 */
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	/**
	 */
	@JsonIgnore
	public Set<Patient> getPatients() {
		if (patients == null) {
			patients = new java.util.LinkedHashSet<com.eclinic.domain.Patient>();
		}
		return patients;
	}

	/**
	 */
	public Address() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Address that) {
		setId(that.getId());
		setCity(that.getCity());
		setCountryCode(that.getCountryCode());
		setProvince(that.getProvince());
		setCountry(that.getCountry());
		setCountryCodeCity(that.getCountryCodeCity());
		setHomeNr(that.getHomeNr());
		setPatients(new java.util.LinkedHashSet<com.eclinic.domain.Patient>(that.getPatients()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("countryCode=[").append(countryCode).append("] ");
		buffer.append("province=[").append(province).append("] ");
		buffer.append("country=[").append(country).append("] ");
		buffer.append("countryCodeCity=[").append(countryCodeCity).append("] ");
		buffer.append("homeNr=[").append(homeNr).append("] ");

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
		if (!(obj instanceof Address))
			return false;
		Address equalCheck = (Address) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
