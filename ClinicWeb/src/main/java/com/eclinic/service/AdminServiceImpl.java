package com.eclinic.service;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Admin entities
 * 
 */

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Instantiates a new AdminServiceImpl.
	 *
	 */
	public AdminServiceImpl() {
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	@Transactional
	public void saveAdmin(Admin admin) {
		Admin existingAdmin = adminDAO.findAdminByPrimaryKey(admin.getId());

		if (existingAdmin != null) {
			if (existingAdmin != admin) {
				existingAdmin.setId(admin.getId());
				existingAdmin.setIsSuper(admin.getIsSuper());
			}
			admin = adminDAO.store(existingAdmin);
		} else {
			admin = adminDAO.store(admin);
		}
		adminDAO.flush();
	}

	/**
	 * Return all Admin entity
	 * 
	 */
	@Transactional
	public List<Admin> findAllAdmins(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Admin>(adminDAO.findAllAdmins(startResult, maxRows));
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public Admin saveAdminWorkers(Integer id, Worker related_workers) {
		Admin admin = adminDAO.findAdminByPrimaryKey(id, -1, -1);
		Worker existingworkers = workerDAO.findWorkerByPrimaryKey(related_workers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworkers != null) {
			existingworkers.setId(related_workers.getId());
			related_workers = existingworkers;
		} else {
			related_workers = workerDAO.store(related_workers);
			workerDAO.flush();
		}

		related_workers.setAdmin(admin);
		admin.getWorkers().add(related_workers);
		related_workers = workerDAO.store(related_workers);
		workerDAO.flush();

		admin = adminDAO.store(admin);
		adminDAO.flush();

		return admin;
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	@Transactional
	public void deleteAdmin(Admin admin) {
		adminDAO.remove(admin);
		adminDAO.flush();
	}

	/**
	 * Return a count of all Admin entity
	 * 
	 */
	@Transactional
	public Integer countAdmins() {
		return ((Long) adminDAO.createQuerySingleResult("select count(o) from Admin o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public Admin deleteAdminWorkers(Integer admin_id, Integer related_workers_id) {
		Worker related_workers = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id, -1, -1);

		related_workers.setAdmin(null);
		admin.getWorkers().remove(related_workers);

		workerDAO.remove(related_workers);
		workerDAO.flush();

		return admin;
	}

	/**
	 */
	@Transactional
	public Admin findAdminByPrimaryKey(Integer id) {
		return adminDAO.findAdminByPrimaryKey(id);
	}

	/**
	 * Load an existing Admin entity
	 * 
	 */
	@Transactional
	public Set<Admin> loadAdmins() {
		return adminDAO.findAllAdmins();
	}
}
