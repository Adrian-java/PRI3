package com.eclinic.dao;

import com.eclinic.domain.Address;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Address entities.
 * 
 */
public interface AddressDAO extends JpaDao<Address> {

	/**
	 * JPQL Query - findAddressByHomeNrContaining
	 *
	 */
	public Set<Address> findAddressByHomeNrContaining(String homeNr) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByHomeNrContaining
	 *
	 */
	public Set<Address> findAddressByHomeNrContaining(String homeNr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeCity
	 *
	 */
	public Set<Address> findAddressByCountryCodeCity(String countryCodeCity) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeCity
	 *
	 */
	public Set<Address> findAddressByCountryCodeCity(String countryCodeCity, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryContaining
	 *
	 */
	public Set<Address> findAddressByCountryContaining(String country) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryContaining
	 *
	 */
	public Set<Address> findAddressByCountryContaining(String country, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByProvince
	 *
	 */
	public Set<Address> findAddressByProvince(String province) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByProvince
	 *
	 */
	public Set<Address> findAddressByProvince(String province, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByProvinceContaining
	 *
	 */
	public Set<Address> findAddressByProvinceContaining(String province_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByProvinceContaining
	 *
	 */
	public Set<Address> findAddressByProvinceContaining(String province_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountry
	 *
	 */
	public Set<Address> findAddressByCountry(String country_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountry
	 *
	 */
	public Set<Address> findAddressByCountry(String country_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeContaining
	 *
	 */
	public Set<Address> findAddressByCountryCodeContaining(String countryCode) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeContaining
	 *
	 */
	public Set<Address> findAddressByCountryCodeContaining(String countryCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByPrimaryKey
	 *
	 */
	public Address findAddressByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByPrimaryKey
	 *
	 */
	public Address findAddressByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeCityContaining
	 *
	 */
	public Set<Address> findAddressByCountryCodeCityContaining(String countryCodeCity_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCodeCityContaining
	 *
	 */
	public Set<Address> findAddressByCountryCodeCityContaining(String countryCodeCity_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAddresss
	 *
	 */
	public Set<Address> findAllAddresss() throws DataAccessException;

	/**
	 * JPQL Query - findAllAddresss
	 *
	 */
	public Set<Address> findAllAddresss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressById
	 *
	 */
	public Address findAddressById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressById
	 *
	 */
	public Address findAddressById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByHomeNr
	 *
	 */
	public Set<Address> findAddressByHomeNr(String homeNr_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByHomeNr
	 *
	 */
	public Set<Address> findAddressByHomeNr(String homeNr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCityContaining
	 *
	 */
	public Set<Address> findAddressByCityContaining(String city) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCityContaining
	 *
	 */
	public Set<Address> findAddressByCityContaining(String city, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCode
	 *
	 */
	public Set<Address> findAddressByCountryCode(String countryCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCountryCode
	 *
	 */
	public Set<Address> findAddressByCountryCode(String countryCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCity
	 *
	 */
	public Set<Address> findAddressByCity(String city_1) throws DataAccessException;

	/**
	 * JPQL Query - findAddressByCity
	 *
	 */
	public Set<Address> findAddressByCity(String city_1, int startResult, int maxRows) throws DataAccessException;

}