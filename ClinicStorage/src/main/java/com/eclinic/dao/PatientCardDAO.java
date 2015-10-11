package com.eclinic.dao;

import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage PatientCard entities.
 * 
 */
public interface PatientCardDAO extends JpaDao<PatientCard> {

	/**
	 * JPQL Query - findPatientCardById
	 *
	 */
	public PatientCard findPatientCardById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardById
	 *
	 */
	public PatientCard findPatientCardById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPatientCards
	 *
	 */
	public Set<PatientCard> findAllPatientCards() throws DataAccessException;

	/**
	 * JPQL Query - findAllPatientCards
	 *
	 */
	public Set<PatientCard> findAllPatientCards(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByPrimaryKey
	 *
	 */
	public PatientCard findPatientCardByPrimaryKey(Integer id_1) throws DataAccessException;
	
	public PatientCard findPatientCardByPatientId(Patient id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByPrimaryKey
	 *
	 */
	public PatientCard findPatientCardByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDateBefore
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDateBefore(java.util.Calendar registerDate) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDateBefore
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDateBefore(Calendar registerDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDateAfter
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDateAfter(java.util.Calendar registerDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDateAfter
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDateAfter(Calendar registerDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDate
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDate(java.util.Calendar registerDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findPatientCardByRegisterDate
	 *
	 */
	public Set<PatientCard> findPatientCardByRegisterDate(Calendar registerDate_2, int startResult, int maxRows) throws DataAccessException;

}