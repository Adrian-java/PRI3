package com.eclinic.dao;

import com.eclinic.domain.Module;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Module entities.
 * 
 */
public interface ModuleDAO extends JpaDao<Module> {

	/**
	 * JPQL Query - findModuleByName
	 *
	 */
	public Set<Module> findModuleByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByName
	 *
	 */
	public Set<Module> findModuleByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllModules
	 *
	 */
	public Set<Module> findAllModules() throws DataAccessException;

	/**
	 * JPQL Query - findAllModules
	 *
	 */
	public Set<Module> findAllModules(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByVisibility
	 *
	 */
	public Set<Module> findModuleByVisibility(Boolean visibility) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByVisibility
	 *
	 */
	public Set<Module> findModuleByVisibility(Boolean visibility, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findModuleById
	 *
	 */
	public Module findModuleById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findModuleById
	 *
	 */
	public Module findModuleById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByPrimaryKey
	 *
	 */
	public Module findModuleByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByPrimaryKey
	 *
	 */
	public Module findModuleByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByNameContaining
	 *
	 */
	public Set<Module> findModuleByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findModuleByNameContaining
	 *
	 */
	public Set<Module> findModuleByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

}