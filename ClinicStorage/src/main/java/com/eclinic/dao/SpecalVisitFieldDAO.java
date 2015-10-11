package com.eclinic.dao;

import com.eclinic.domain.SpecalVisitField;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage SpecalVisitField entities.
 * 
 */
public interface SpecalVisitFieldDAO extends JpaDao<SpecalVisitField> {

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValueContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValueContaining(String typeOfValue) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValueContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValueContaining(String typeOfValue, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValue
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValue(String typeOfValue_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByTypeOfValue
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByTypeOfValue(String typeOfValue_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByPrimaryKey
	 *
	 */
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByPrimaryKey
	 *
	 */
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSpecalVisitFields
	 *
	 */
	public Set<SpecalVisitField> findAllSpecalVisitFields() throws DataAccessException;

	/**
	 * JPQL Query - findAllSpecalVisitFields
	 *
	 */
	public Set<SpecalVisitField> findAllSpecalVisitFields(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByValueContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByValueContaining(String value) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByValueContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByValueContaining(String value, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByName
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByName
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByNameContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByNameContaining
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldById
	 *
	 */
	public SpecalVisitField findSpecalVisitFieldById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldById
	 *
	 */
	public SpecalVisitField findSpecalVisitFieldById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByValue
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByValue(String value_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecalVisitFieldByValue
	 *
	 */
	public Set<SpecalVisitField> findSpecalVisitFieldByValue(String value_1, int startResult, int maxRows) throws DataAccessException;

}