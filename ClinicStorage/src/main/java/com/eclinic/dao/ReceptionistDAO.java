package com.eclinic.dao;

import com.eclinic.domain.Receptionist;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Receptionist entities.
 * 
 */
public interface ReceptionistDAO extends JpaDao<Receptionist> {

	/**
	 * JPQL Query - findAllReceptionists
	 *
	 */
	public Set<Receptionist> findAllReceptionists() throws DataAccessException;

	/**
	 * JPQL Query - findAllReceptionists
	 *
	 */
	public Set<Receptionist> findAllReceptionists(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */
	public Receptionist findReceptionistById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */
	public Receptionist findReceptionistById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */
	public Set<Receptionist> findReceptionistBySurname(String surname) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */
	public Set<Receptionist> findReceptionistBySurname(String surname, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */
	public Set<Receptionist> findReceptionistByPhoneNr(String phoneNr) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */
	public Set<Receptionist> findReceptionistByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */
	public Set<Receptionist> findReceptionistByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */
	public Set<Receptionist> findReceptionistByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */
	public Set<Receptionist> findReceptionistByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */
	public Set<Receptionist> findReceptionistByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */
	public Set<Receptionist> findReceptionistByPhoneNrContaining(String phoneNr_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */
	public Set<Receptionist> findReceptionistByPhoneNrContaining(String phoneNr_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */
	public Set<Receptionist> findReceptionistBySurnameContaining(String surname_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */
	public Set<Receptionist> findReceptionistBySurnameContaining(String surname_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */
	public Receptionist findReceptionistByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */
	public Receptionist findReceptionistByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}