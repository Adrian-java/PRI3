package com.eclinic.dao;

import com.eclinic.domain.SystemError;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage SystemError entities.
 * 
 */
public interface SystemErrorDAO extends JpaDao<SystemError> {

	/**
	 * JPQL Query - findSystemErrorById
	 *
	 */
	public SystemError findSystemErrorById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSystemErrorById
	 *
	 */
	public SystemError findSystemErrorById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemErrorByPrimaryKey
	 *
	 */
	public SystemError findSystemErrorByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSystemErrorByPrimaryKey
	 *
	 */
	public SystemError findSystemErrorByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemErrorByDate
	 *
	 */
	public Set<SystemError> findSystemErrorByDate(java.util.Calendar date) throws DataAccessException;

	/**
	 * JPQL Query - findSystemErrorByDate
	 *
	 */
	public Set<SystemError> findSystemErrorByDate(Calendar date, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSystemErrors
	 *
	 */
	public Set<SystemError> findAllSystemErrors() throws DataAccessException;

	/**
	 * JPQL Query - findAllSystemErrors
	 *
	 */
	public Set<SystemError> findAllSystemErrors(int startResult, int maxRows) throws DataAccessException;

}