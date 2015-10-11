package com.eclinic.dao;

import com.eclinic.domain.LoginHistory;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage LoginHistory entities.
 * 
 */
public interface LoginHistoryDAO extends JpaDao<LoginHistory> {

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutAfter
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogoutAfter(java.util.Calendar dateLogout) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutAfter
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogoutAfter(Calendar dateLogout, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLoginBefore
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLoginBefore(java.util.Calendar dateLogin) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLoginBefore
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLoginBefore(Calendar dateLogin, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogout
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogout(java.util.Calendar dateLogout_1) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogout
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogout(Calendar dateLogout_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLoginAfter
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLoginAfter(java.util.Calendar dateLogin_1) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLoginAfter
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLoginAfter(Calendar dateLogin_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryById
	 *
	 */
	public LoginHistory findLoginHistoryById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryById
	 *
	 */
	public LoginHistory findLoginHistoryById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllLoginHistorys
	 *
	 */
	public Set<LoginHistory> findAllLoginHistorys() throws DataAccessException;

	/**
	 * JPQL Query - findAllLoginHistorys
	 *
	 */
	public Set<LoginHistory> findAllLoginHistorys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByPrimaryKey
	 *
	 */
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByPrimaryKey
	 *
	 */
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutBefore
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogoutBefore(java.util.Calendar dateLogout_2) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogoutBefore
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogoutBefore(Calendar dateLogout_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryBySessionNumberContaining
	 *
	 */
	public Set<LoginHistory> findLoginHistoryBySessionNumberContaining(String sessionNumber) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryBySessionNumberContaining
	 *
	 */
	public Set<LoginHistory> findLoginHistoryBySessionNumberContaining(String sessionNumber, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogin
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogin(java.util.Calendar dateLogin_2) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryByDateLogin
	 *
	 */
	public Set<LoginHistory> findLoginHistoryByDateLogin(Calendar dateLogin_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryBySessionNumber
	 *
	 */
	public Set<LoginHistory> findLoginHistoryBySessionNumber(String sessionNumber_1) throws DataAccessException;

	/**
	 * JPQL Query - findLoginHistoryBySessionNumber
	 *
	 */
	public Set<LoginHistory> findLoginHistoryBySessionNumber(String sessionNumber_1, int startResult, int maxRows) throws DataAccessException;

}