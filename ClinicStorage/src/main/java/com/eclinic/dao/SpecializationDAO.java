package com.eclinic.dao;

import com.eclinic.domain.Specialization;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Specialization entities.
 * 
 */
public interface SpecializationDAO extends JpaDao<Specialization> {

	/**
	 * JPQL Query - findSpecializationByNameContaining
	 *
	 */
	public Set<Specialization> findSpecializationByNameContaining(String name) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationByNameContaining
	 *
	 */
	public Set<Specialization> findSpecializationByNameContaining(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationByPrimaryKey
	 *
	 */
	public Specialization findSpecializationByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationByPrimaryKey
	 *
	 */
	public Specialization findSpecializationByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSpecializations
	 *
	 */
	public Set<Specialization> findAllSpecializations() throws DataAccessException;

	/**
	 * JPQL Query - findAllSpecializations
	 *
	 */
	public Set<Specialization> findAllSpecializations(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationById
	 *
	 */
	public Specialization findSpecializationById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationById
	 *
	 */
	public Specialization findSpecializationById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationByName
	 *
	 */
	public Set<Specialization> findSpecializationByName(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findSpecializationByName
	 *
	 */
	public Set<Specialization> findSpecializationByName(String name_1, int startResult, int maxRows) throws DataAccessException;

}