package com.eclinic.dao;

import com.eclinic.domain.ApplicationParameter;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage ApplicationParameter entities.
 * 
 */
public interface ApplicationParameterDAO extends JpaDao<ApplicationParameter> {

	/**
	 * JPQL Query - findApplicationParameterByValueNumber
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueNumber(Integer valueNumber) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByValueNumber
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueNumber(Integer valueNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterById
	 *
	 */
	public ApplicationParameter findApplicationParameterById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterById
	 *
	 */
	public ApplicationParameter findApplicationParameterById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByKey
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByKey(String key) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByKey
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByKey(String key, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByPrimaryKey
	 *
	 */
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByPrimaryKey
	 *
	 */
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByValueString
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueString(String valueString) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByValueString
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueString(String valueString, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByValueStringContaining
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueStringContaining(String valueString_1) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByValueStringContaining
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByValueStringContaining(String valueString_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllApplicationParameters
	 *
	 */
	public Set<ApplicationParameter> findAllApplicationParameters() throws DataAccessException;

	/**
	 * JPQL Query - findAllApplicationParameters
	 *
	 */
	public Set<ApplicationParameter> findAllApplicationParameters(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByKeyContaining
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByKeyContaining(String key_1) throws DataAccessException;

	/**
	 * JPQL Query - findApplicationParameterByKeyContaining
	 *
	 */
	public Set<ApplicationParameter> findApplicationParameterByKeyContaining(String key_1, int startResult, int maxRows) throws DataAccessException;

}