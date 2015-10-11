package com.eclinic.dao;

import com.eclinic.domain.TypeOfUser;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage TypeOfUser entities.
 * 
 */
public interface TypeOfUserDAO extends JpaDao<TypeOfUser> {

	/**
	 * JPQL Query - findAllTypeOfUsers
	 *
	 */
	public Set<TypeOfUser> findAllTypeOfUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllTypeOfUsers
	 *
	 */
	public Set<TypeOfUser> findAllTypeOfUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByType
	 *
	 */
	public Set<TypeOfUser> findTypeOfUserByType(String type) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByType
	 *
	 */
	public Set<TypeOfUser> findTypeOfUserByType(String type, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByTypeContaining
	 *
	 */
	public Set<TypeOfUser> findTypeOfUserByTypeContaining(String type_1) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByTypeContaining
	 *
	 */
	public Set<TypeOfUser> findTypeOfUserByTypeContaining(String type_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByPrimaryKey
	 *
	 */
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserByPrimaryKey
	 *
	 */
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserById
	 *
	 */
	public TypeOfUser findTypeOfUserById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findTypeOfUserById
	 *
	 */
	public TypeOfUser findTypeOfUserById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}