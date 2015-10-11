package com.eclinic.service;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */
public interface PermissionService {

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	public Integer countPermissions();

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public void deletePermission(Permission permission);

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	public Permission deletePermissionTypeOfUsers(Integer permission_id, Integer related_typeofusers_id);

	/**
	 * Return all Permission entity
	 * 
	 */
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public void savePermission(Permission permission_1);

	/**
	 * Delete an existing Module entity
	 * 
	 */
	public Permission deletePermissionModule(Integer permission_id_1, Integer related_module_id);

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	public Permission savePermissionTypeOfUsers(Integer id, TypeOfUser related_typeofusers);

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	public Permission deletePermissionSystemUser(Integer permission_id_2, Integer related_systemuser_id);

	/**
	 * Load an existing Permission entity
	 * 
	 */
	public Set<Permission> loadPermissions();

	/**
	 */
	public Permission findPermissionByPrimaryKey(Integer id_1);

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	public Permission savePermissionSystemUser(Integer id_2, SystemUser related_systemuser);

	/**
	 * Save an existing Module entity
	 * 
	 */
	public Permission savePermissionModule(Integer id_3, Module related_module);
}