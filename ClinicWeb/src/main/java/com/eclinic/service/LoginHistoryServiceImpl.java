package com.eclinic.service;

import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for LoginHistory entities
 * 
 */

@Service("LoginHistoryService")
@Transactional
public class LoginHistoryServiceImpl implements LoginHistoryService {

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Instantiates a new LoginHistoryServiceImpl.
	 *
	 */
	public LoginHistoryServiceImpl() {
	}

	/**
	 * Load an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public Set<LoginHistory> loadLoginHistorys() {
		return loginHistoryDAO.findAllLoginHistorys();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public LoginHistory deleteLoginHistoryWorker(Integer loginhistory_id, Integer related_worker_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id, -1, -1);
		Worker related_worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);

		loginhistory.setWorker(null);
		related_worker.getLoginHistories().remove(loginhistory);
		loginhistory = loginHistoryDAO.store(loginhistory);
		loginHistoryDAO.flush();

		related_worker = workerDAO.store(related_worker);
		workerDAO.flush();

		workerDAO.remove(related_worker);
		workerDAO.flush();

		return loginhistory;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public LoginHistory saveLoginHistoryWorker(Integer id, Worker related_worker) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(id, -1, -1);
		Worker existingworker = workerDAO.findWorkerByPrimaryKey(related_worker.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworker != null) {
			existingworker.setId(related_worker.getId());
			related_worker = existingworker;
		}

		loginhistory.setWorker(related_worker);
		related_worker.getLoginHistories().add(loginhistory);
		loginhistory = loginHistoryDAO.store(loginhistory);
		loginHistoryDAO.flush();

		related_worker = workerDAO.store(related_worker);
		workerDAO.flush();

		return loginhistory;
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public void deleteLoginHistory(LoginHistory loginhistory) {
		loginHistoryDAO.remove(loginhistory);
		loginHistoryDAO.flush();
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */
	@Transactional
	public void saveLoginHistory(LoginHistory loginhistory) {
		LoginHistory existingLoginHistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId());

		if (existingLoginHistory != null) {
			if (existingLoginHistory != loginhistory) {
				existingLoginHistory.setId(loginhistory.getId());
				existingLoginHistory.setDateLogin(loginhistory.getDateLogin());
				existingLoginHistory.setSessionNumber(loginhistory.getSessionNumber());
				existingLoginHistory.setDateLogout(loginhistory.getDateLogout());
			}
			loginhistory = loginHistoryDAO.store(existingLoginHistory);
		} else {
			loginhistory = loginHistoryDAO.store(loginhistory);
		}
		loginHistoryDAO.flush();
	}

	/**
	 * Return a count of all LoginHistory entity
	 * 
	 */
	@Transactional
	public Integer countLoginHistorys() {
		return ((Long) loginHistoryDAO.createQuerySingleResult("select count(o) from LoginHistory o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public LoginHistory findLoginHistoryByPrimaryKey(Integer id) {
		return loginHistoryDAO.findLoginHistoryByPrimaryKey(id);
	}

	/**
	 * Return all LoginHistory entity
	 * 
	 */
	@Transactional
	public List<LoginHistory> findAllLoginHistorys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<LoginHistory>(loginHistoryDAO.findAllLoginHistorys(startResult, maxRows));
	}
}
