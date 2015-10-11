package com.eclinic.service;

import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SystemUser entities
 * 
 */
public interface SystemUserService {

	/**
	 * Save an existing Worker entity
	 * 
	 */
	public SystemUser saveSystemUserWorker(Integer id, Worker related_worker);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public SystemUser saveSystemUserPermissions(Integer id_1, Permission related_permissions);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public SystemUser deleteSystemUserPermissions(Integer systemuser_id, Integer related_permissions_id);

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	public SystemUser deleteSystemUserWorker(Integer systemuser_id_1, Integer related_worker_id);

	/**
	 * Return a count of all SystemUser entity
	 * 
	 */
	public Integer countSystemUsers();

	/**
	 */
	public SystemUser findSystemUserByPrimaryKey(Integer id_2);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Integer saveSystemUser(SystemUser systemuser);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public void deleteSystemUser(SystemUser systemuser_1);

	/**
	 * Load an existing SystemUser entity
	 * 
	 */
	public Set<SystemUser> loadSystemUsers();

	/**
	 * Return all SystemUser entity
	 * 
	 */
	public List<SystemUser> findAllSystemUsers(Integer startResult, Integer maxRows);
}