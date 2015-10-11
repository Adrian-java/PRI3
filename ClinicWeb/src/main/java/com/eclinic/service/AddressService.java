package com.eclinic.service;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Address entities
 * 
 */
public interface AddressService {

	/**
	 * Save an existing Address entity
	 * @return 
	 * 
	 */
	public Integer saveAddress(Address address);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Address deleteAddressPatients(Integer address_id, Integer related_patients_id);

	/**
	 * Return all Address entity
	 * 
	 */
	public List<Address> findAllAddresss(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Address entity
	 * 
	 */
	public Integer countAddresss();

	/**
	 * Delete an existing Address entity
	 * 
	 */
	public void deleteAddress(Address address_1);

	/**
	 * Load an existing Address entity
	 * 
	 */
	public Set<Address> loadAddresss();

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Address saveAddressPatients(Integer id, Patient related_patients);

	/**
	 */
	public Address findAddressByPrimaryKey(Integer id_1);
}