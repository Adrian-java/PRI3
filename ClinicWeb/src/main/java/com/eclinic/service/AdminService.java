package com.eclinic.service;

import com.eclinic.domain.Admin;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Admin entities
 * 
 */
public interface AdminService {

	/**
	 * Save an existing Admin entity
	 * 
	 */
	public void saveAdmin(Admin admin);

	/**
	 * Return all Admin entity
	 * 
	 */
	public List<Admin> findAllAdmins(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public Admin saveAdminWorkers(Integer id, Worker related_workers);

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	public void deleteAdmin(Admin admin_1);

	/**
	 * Return a count of all Admin entity
	 * 
	 */
	public Integer countAdmins();

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public Admin deleteAdminWorkers(Integer admin_id, Integer related_workers_id);

	/**
	 */
	public Admin findAdminByPrimaryKey(Integer id_1);

	/**
	 * Load an existing Admin entity
	 * 
	 */
	public Set<Admin> loadAdmins();
}