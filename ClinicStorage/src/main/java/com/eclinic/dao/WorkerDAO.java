package com.eclinic.dao;

import com.eclinic.domain.Worker;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Worker entities.
 * 
 */
public interface WorkerDAO extends JpaDao<Worker> {

	/**
	 * JPQL Query - findWorkerById
	 *
	 */
	public Worker findWorkerById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findWorkerById
	 *
	 */
	public Worker findWorkerById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllWorkers
	 *
	 */
	public Set<Worker> findAllWorkers() throws DataAccessException;

	/**
	 * JPQL Query - findAllWorkers
	 *
	 */
	public Set<Worker> findAllWorkers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findWorkerByPrimaryKey
	 *
	 */
	public Worker findWorkerByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findWorkerByPrimaryKey
	 *
	 */
	public Worker findWorkerByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}