package com.eclinic.dao;

import com.eclinic.domain.Patient;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Patient entities.
 * 
 */
public interface PatientDAO extends JpaDao<Patient> {

	/**
	 * JPQL Query - findPatientBySurname
	 *
	 */
	public Set<Patient> findPatientBySurname(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurname
	 *
	 */
	public Set<Patient> findPatientBySurname(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPatients
	 *
	 */
	public Set<Patient> findAllPatients() throws DataAccessException;

	/**
	 * JPQL Query - findAllPatients
	 *
	 */
	public Set<Patient> findAllPatients(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */
	public Set<Patient> findPatientByDateOfBirthBefore(java.util.Calendar dateOfBirth) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthBefore
	 *
	 */
	public Set<Patient> findPatientByDateOfBirthBefore(Calendar dateOfBirth, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */
	public Set<Patient> findPatientByConfirmed(Integer confirmed) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByConfirmed
	 *
	 */
	public Set<Patient> findPatientByConfirmed(Integer confirmed, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */
	public Set<Patient> findPatientByDateOfBirthAfter(java.util.Calendar dateOfBirth_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirthAfter
	 *
	 */
	public Set<Patient> findPatientByDateOfBirthAfter(Calendar dateOfBirth_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientById
	 *
	 */
	public Patient findPatientById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPatientById
	 *
	 */
	public Patient findPatientById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */
	public Set<Patient> findPatientByEMailContaining(String EMail) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMailContaining
	 *
	 */
	public Set<Patient> findPatientByEMailContaining(String EMail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */
	public Set<Patient> findPatientByPhoneNr(String phoneNr) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNr
	 *
	 */
	public Set<Patient> findPatientByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */
	public Set<Patient> findPatientByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByNameContaining
	 *
	 */
	public Set<Patient> findPatientByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */
	public Set<Patient> findPatientByEMail(String EMail_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByEMail
	 *
	 */
	public Set<Patient> findPatientByEMail(String EMail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */
	public Set<Patient> findPatientByPhoneNrContaining(String phoneNr_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPhoneNrContaining
	 *
	 */
	public Set<Patient> findPatientByPhoneNrContaining(String phoneNr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */
	public Set<Patient> findPatientByDateOfBirth(java.util.Calendar dateOfBirth_2) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByDateOfBirth
	 *
	 */
	public Set<Patient> findPatientByDateOfBirth(Calendar dateOfBirth_2, int startResult, int maxRows) throws DataAccessException;


	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */
	public Patient findPatientByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByPrimaryKey
	 *
	 */
	public Patient findPatientByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByName
	 *
	 */
	public Set<Patient> findPatientByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientByName
	 *
	 */
	public Set<Patient> findPatientByName(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */
	public Set<Patient> findPatientBySurnameContaining(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientBySurnameContaining
	 *
	 */
	public Set<Patient> findPatientBySurnameContaining(String surname_1, int startResult, int maxRows) throws DataAccessException;

}