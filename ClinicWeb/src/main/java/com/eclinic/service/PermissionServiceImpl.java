package com.eclinic.service;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */

@Service("PermissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

	/**
	 * DAO injected by Spring that manages Module entities
	 * 
	 */
	@Autowired
	private ModuleDAO moduleDAO;

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Instantiates a new PermissionServiceImpl.
	 *
	 */
	public PermissionServiceImpl() {
	}

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	@Transactional
	public Integer countPermissions() {
		return ((Long) permissionDAO.createQuerySingleResult("select count(o) from Permission o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public void deletePermission(Permission permission) {
		permissionDAO.remove(permission);
		permissionDAO.flush();
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionTypeOfUsers(Integer permission_id, Integer related_typeofusers_id) {
		TypeOfUser related_typeofusers = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers_id, -1, -1);

		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		related_typeofusers.setPermission(null);
		permission.getTypeOfUsers().remove(related_typeofusers);

		typeOfUserDAO.remove(related_typeofusers);
		typeOfUserDAO.flush();

		return permission;
	}

	/**
	 * Return all Permission entity
	 * 
	 */
	@Transactional
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Permission>(permissionDAO.findAllPermissions(startResult, maxRows));
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public void savePermission(Permission permission) {
		Permission existingPermission = permissionDAO.findPermissionByPrimaryKey(permission.getId());

		if (existingPermission != null) {
			if (existingPermission != permission) {
				existingPermission.setId(permission.getId());
				existingPermission.setDisplay(permission.getDisplay());
				existingPermission.setEdit(permission.getEdit());
				existingPermission.setExecute(permission.getExecute());
			}
			permission = permissionDAO.store(existingPermission);
		} else {
			permission = permissionDAO.store(permission);
		}
		permissionDAO.flush();
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionModule(Integer permission_id, Integer related_module_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);
		Module related_module = moduleDAO.findModuleByPrimaryKey(related_module_id, -1, -1);

		permission.setModule(null);
		related_module.getPermissions().remove(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_module = moduleDAO.store(related_module);
		moduleDAO.flush();

		moduleDAO.remove(related_module);
		moduleDAO.flush();

		return permission;
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public Permission savePermissionTypeOfUsers(Integer id, TypeOfUser related_typeofusers) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
		TypeOfUser existingtypeOfUsers = typeOfUserDAO.findTypeOfUserByPrimaryKey(related_typeofusers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingtypeOfUsers != null) {
			existingtypeOfUsers.setId(related_typeofusers.getId());
			existingtypeOfUsers.setType(related_typeofusers.getType());
			existingtypeOfUsers.setDescription(related_typeofusers.getDescription());
			related_typeofusers = existingtypeOfUsers;
		}

		related_typeofusers.setPermission(permission);
		permission.getTypeOfUsers().add(related_typeofusers);
		related_typeofusers = typeOfUserDAO.store(related_typeofusers);
		typeOfUserDAO.flush();

		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		return permission;
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionSystemUser(Integer permission_id, Integer related_systemuser_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);
		SystemUser related_systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser_id, -1, -1);

		permission.setSystemUser(null);
		related_systemuser.getPermissions().remove(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		systemUserDAO.remove(related_systemuser);
		systemUserDAO.flush();

		return permission;
	}

	/**
	 * Load an existing Permission entity
	 * 
	 */
	@Transactional
	public Set<Permission> loadPermissions() {
		return permissionDAO.findAllPermissions();
	}

	/**
	 */
	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id) {
		return permissionDAO.findPermissionByPrimaryKey(id);
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Permission savePermissionSystemUser(Integer id, SystemUser related_systemuser) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
		SystemUser existingsystemUser = systemUserDAO.findSystemUserByPrimaryKey(related_systemuser.getId());

		// copy into the existing record to preserve existing relationships
		if (existingsystemUser != null) {
			existingsystemUser.setId(related_systemuser.getId());
			existingsystemUser.setPesel(related_systemuser.getPesel());
			existingsystemUser.setPassword(related_systemuser.getPassword());
			existingsystemUser.setDescription(related_systemuser.getDescription());
			existingsystemUser.setRegisterDate(related_systemuser.getRegisterDate());
			existingsystemUser.setIsActive(related_systemuser.getIsActive());
			existingsystemUser.setChangedPassword(related_systemuser.getChangedPassword());
			existingsystemUser.setEmail(related_systemuser.getEmail());
			existingsystemUser.setUnregisterDate(related_systemuser.getUnregisterDate());
			related_systemuser = existingsystemUser;
		}

		permission.setSystemUser(related_systemuser);
		related_systemuser.getPermissions().add(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_systemuser = systemUserDAO.store(related_systemuser);
		systemUserDAO.flush();

		return permission;
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@Transactional
	public Permission savePermissionModule(Integer id, Module related_module) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
		Module existingmodule = moduleDAO.findModuleByPrimaryKey(related_module.getId());

		// copy into the existing record to preserve existing relationships
		if (existingmodule != null) {
			existingmodule.setId(related_module.getId());
			existingmodule.setName(related_module.getName());
			existingmodule.setVisibility(related_module.getVisibility());
			related_module = existingmodule;
		}

		permission.setModule(related_module);
		related_module.getPermissions().add(permission);
		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		related_module = moduleDAO.store(related_module);
		moduleDAO.flush();

		return permission;
	}
}
