package com.eclinic.dao;

import com.eclinic.domain.Permission;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Permission entities.
 * 
 */
public interface PermissionDAO extends JpaDao<Permission> {

	/**
	 * JPQL Query - findPermissionByExecute
	 *
	 */
	public Set<Permission> findPermissionByExecute(Boolean execute) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByExecute
	 *
	 */
	public Set<Permission> findPermissionByExecute(Boolean execute, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	public Permission findPermissionByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	public Permission findPermissionByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	public Set<Permission> findAllPermissions() throws DataAccessException;

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	public Set<Permission> findAllPermissions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	public Permission findPermissionById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	public Permission findPermissionById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByEdit
	 *
	 */
	public Set<Permission> findPermissionByEdit(Boolean edit) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByEdit
	 *
	 */
	public Set<Permission> findPermissionByEdit(Boolean edit, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByDisplay
	 *
	 */
	public Set<Permission> findPermissionByDisplay(Boolean display) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByDisplay
	 *
	 */
	public Set<Permission> findPermissionByDisplay(Boolean display, int startResult, int maxRows) throws DataAccessException;

}