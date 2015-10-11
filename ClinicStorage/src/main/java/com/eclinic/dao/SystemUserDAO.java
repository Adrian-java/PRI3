package com.eclinic.dao;

import com.eclinic.domain.SystemUser;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage SystemUser entities.
 * 
 */
public interface SystemUserDAO extends JpaDao<SystemUser> {

	/**
	 * JPQL Query - findSystemUserByUnregisterDate
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDate(java.util.Calendar unregisterDate) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByUnregisterDate
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDate(Calendar unregisterDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByChangedPassword
	 *
	 */
	public Set<SystemUser> findSystemUserByChangedPassword(Boolean changedPassword) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByChangedPassword
	 *
	 */
	public Set<SystemUser> findSystemUserByChangedPassword(Boolean changedPassword, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPrimaryKey
	 *
	 */
	public SystemUser findSystemUserByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPrimaryKey
	 *
	 */
	public SystemUser findSystemUserByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPasswordContaining
	 *
	 */
	public Set<SystemUser> findSystemUserByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPasswordContaining
	 *
	 */
	public Set<SystemUser> findSystemUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDate
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDate(java.util.Calendar registerDate) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDate
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDate(Calendar registerDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserById
	 *
	 */
	public SystemUser findSystemUserById(Integer id_1) throws DataAccessException;
	
	public SystemUser findSystemUserByPesel(String pesel) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserById
	 *
	 */
	public SystemUser findSystemUserById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllSystemUsers
	 *
	 */
	public Set<SystemUser> findAllSystemUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllSystemUsers
	 *
	 */
	public Set<SystemUser> findAllSystemUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByEmailContaining
	 *
	 */
	public Set<SystemUser> findSystemUserByEmailContaining(String email) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByEmailContaining
	 *
	 */
	public Set<SystemUser> findSystemUserByEmailContaining(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPassword
	 *
	 */
	public Set<SystemUser> findSystemUserByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByPassword
	 *
	 */
	public Set<SystemUser> findSystemUserByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByIsActive
	 *
	 */
	public Set<SystemUser> findSystemUserByIsActive(Boolean isActive) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByIsActive
	 *
	 */
	public Set<SystemUser> findSystemUserByIsActive(Boolean isActive, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDateAfter
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDateAfter(java.util.Calendar registerDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDateAfter
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDateAfter(Calendar registerDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByUnregisterDateAfter
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDateAfter(java.util.Calendar unregisterDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByUnregisterDateAfter
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDateAfter(Calendar unregisterDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByEmail
	 *
	 */
	public Set<SystemUser> findSystemUserByEmail(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByEmail
	 *
	 */
	public Set<SystemUser> findSystemUserByEmail(String email_1, int startResult, int maxRows) throws DataAccessException;



	/**
	 * JPQL Query - findSystemUserByUnregisterDateBefore
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDateBefore(java.util.Calendar unregisterDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByUnregisterDateBefore
	 *
	 */
	public Set<SystemUser> findSystemUserByUnregisterDateBefore(Calendar unregisterDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDateBefore
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDateBefore(java.util.Calendar registerDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findSystemUserByRegisterDateBefore
	 *
	 */
	public Set<SystemUser> findSystemUserByRegisterDateBefore(Calendar registerDate_2, int startResult, int maxRows) throws DataAccessException;

}