package com.eclinic.dao;

import com.eclinic.domain.Address;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Address entities.
 * 
 */
@Repository("AddressDAO")
@Transactional
public class AddressDAOImpl extends AbstractJpaDao<Address> implements
		AddressDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Address.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AddressDAOImpl
	 *
	 */
	public AddressDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAddressByHomeNrContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByHomeNrContaining(String homeNr) throws DataAccessException {

		return findAddressByHomeNrContaining(homeNr, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByHomeNrContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByHomeNrContaining(String homeNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByHomeNrContaining", startResult, maxRows, homeNr);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCountryCodeCity
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountryCodeCity(String countryCodeCity) throws DataAccessException {

		return findAddressByCountryCodeCity(countryCodeCity, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountryCodeCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountryCodeCity(String countryCodeCity, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountryCodeCity", startResult, maxRows, countryCodeCity);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCountryContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountryContaining(String country) throws DataAccessException {

		return findAddressByCountryContaining(country, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountryContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountryContaining(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountryContaining", startResult, maxRows, country);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByProvince
	 *
	 */
	@Transactional
	public Set<Address> findAddressByProvince(String province) throws DataAccessException {

		return findAddressByProvince(province, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByProvince
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByProvince(String province, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByProvince", startResult, maxRows, province);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByProvinceContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByProvinceContaining(String province) throws DataAccessException {

		return findAddressByProvinceContaining(province, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByProvinceContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByProvinceContaining(String province, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByProvinceContaining", startResult, maxRows, province);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCountry
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountry(String country) throws DataAccessException {

		return findAddressByCountry(country, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountry
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountry(String country, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountry", startResult, maxRows, country);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCountryCodeContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountryCodeContaining(String countryCode) throws DataAccessException {

		return findAddressByCountryCodeContaining(countryCode, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountryCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountryCodeContaining(String countryCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountryCodeContaining", startResult, maxRows, countryCode);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByPrimaryKey
	 *
	 */
	@Transactional
	public Address findAddressByPrimaryKey(Integer id) throws DataAccessException {

		return findAddressByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByPrimaryKey
	 *
	 */

	@Transactional
	public Address findAddressByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAddressByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Address) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAddressByCountryCodeCityContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountryCodeCityContaining(String countryCodeCity) throws DataAccessException {

		return findAddressByCountryCodeCityContaining(countryCodeCity, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountryCodeCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountryCodeCityContaining(String countryCodeCity, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountryCodeCityContaining", startResult, maxRows, countryCodeCity);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAddresss
	 *
	 */
	@Transactional
	public Set<Address> findAllAddresss() throws DataAccessException {

		return findAllAddresss(-1, -1);
	}

	/**
	 * JPQL Query - findAllAddresss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAllAddresss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAddresss", startResult, maxRows);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressById
	 *
	 */
	@Transactional
	public Address findAddressById(Integer id) throws DataAccessException {

		return findAddressById(id, -1, -1);
	}

	/**
	 * JPQL Query - findAddressById
	 *
	 */

	@Transactional
	public Address findAddressById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAddressById", startResult, maxRows, id);
			return (com.eclinic.domain.Address) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAddressByHomeNr
	 *
	 */
	@Transactional
	public Set<Address> findAddressByHomeNr(String homeNr) throws DataAccessException {

		return findAddressByHomeNr(homeNr, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByHomeNr
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByHomeNr(String homeNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByHomeNr", startResult, maxRows, homeNr);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCityContaining
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCityContaining(String city) throws DataAccessException {

		return findAddressByCityContaining(city, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCityContaining(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCityContaining", startResult, maxRows, city);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCountryCode
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCountryCode(String countryCode) throws DataAccessException {

		return findAddressByCountryCode(countryCode, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCountryCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCountryCode(String countryCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCountryCode", startResult, maxRows, countryCode);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * JPQL Query - findAddressByCity
	 *
	 */
	@Transactional
	public Set<Address> findAddressByCity(String city) throws DataAccessException {

		return findAddressByCity(city, -1, -1);
	}

	/**
	 * JPQL Query - findAddressByCity
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Address> findAddressByCity(String city, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAddressByCity", startResult, maxRows, city);
		return new LinkedHashSet<Address>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Address entity) {
		return true;
	}
}
