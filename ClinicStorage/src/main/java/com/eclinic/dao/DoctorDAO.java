package com.eclinic.dao;

import com.eclinic.domain.Doctor;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Doctor entities.
 * 
 */
public interface DoctorDAO extends JpaDao<Doctor> {

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	public Set<Doctor> findDoctorBySurnameContaining(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	public Set<Doctor> findDoctorBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	public Set<Doctor> findDoctorBySurname(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	public Set<Doctor> findDoctorBySurname(String surname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	public Set<Doctor> findDoctorByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	public Set<Doctor> findDoctorByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	public Set<Doctor> findAllDoctors() throws DataAccessException;

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	public Set<Doctor> findAllDoctors(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	public Set<Doctor> findDoctorByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	public Set<Doctor> findDoctorByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	public Doctor findDoctorByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	public Doctor findDoctorByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	public Doctor findDoctorById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	public Doctor findDoctorById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}