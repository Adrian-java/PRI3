package com.eclinic.service;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for LoginHistory entities
 * 
 */
public interface LoginHistoryService {

	/**
	 * Load an existing LoginHistory entity
	 * 
	 */
	public Set<LoginHistory> loadLoginHistorys();

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public LoginHistory deleteLoginHistoryWorker(Integer loginhistory_id, Integer related_worker_id);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public LoginHistory saveLoginHistoryWorker(Integer id, Worker related_worker);

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	public void deleteLoginHistory(LoginHistory loginhistory);

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	public void saveLoginHistory(LoginHistory loginhistory_1);

	/**
	 * Return a count of all LoginHistory entity
	 * 
	 */
	public Integer countLoginHistorys();

	/**
	 */
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id_1);

	/**
	 * Return all LoginHistory entity
	 * 
	 */
	public List<LoginHistory> findAllLoginHistorys(Integer startResult, Integer maxRows);
}