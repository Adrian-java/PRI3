package com.eclinic.service;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Permission;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SystemUser entities
 * 
 */

@Service("SystemUserService")
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

	@Autowired
	private PermissionDAO permissionDAO;

	@Autowired
	private SystemUserDAO systemUserDAO;

	@Autowired
	private WorkerDAO workerDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	/**
	 * Instantiates a new SystemUserServiceImpl.
	 *
	 */
	public SystemUserServiceImpl() {
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public SystemUser saveSystemUserWorker(Integer id, Worker related_worker) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(id, -1, -1);
		Worker existingworker = workerDAO.findWorkerByPrimaryKey(related_worker.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworker != null) {
			existingworker.setId(related_worker.getId());
			related_worker = existingworker;
		}

		systemuser.setWorker(related_worker);
		related_worker.getSystemUsers().add(systemuser);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_worker = workerDAO.store(related_worker);
		workerDAO.flush();

		return systemuser;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public SystemUser saveSystemUserPermissions(Integer id, Permission related_permissions) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(id, -1, -1);
		Permission existingpermissions = permissionDAO.findPermissionByPrimaryKey(related_permissions.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermissions != null) {
			existingpermissions.setId(related_permissions.getId());
			existingpermissions.setDisplay(related_permissions.getDisplay());
			existingpermissions.setEdit(related_permissions.getEdit());
			existingpermissions.setExecute(related_permissions.getExecute());
			related_permissions = existingpermissions;
		}

		related_permissions.setSystemUser(systemuser);
		systemuser.getPermissions().add(related_permissions);
		related_permissions = permissionDAO.store(related_permissions);
		permissionDAO.flush();

		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		return systemuser;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserPermissions(Integer systemuser_id, Integer related_permissions_id) {
		Permission related_permissions = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);

		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id, -1, -1);

		related_permissions.setSystemUser(null);
		systemuser.getPermissions().remove(related_permissions);

		permissionDAO.remove(related_permissions);
		permissionDAO.flush();

		return systemuser;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public SystemUser deleteSystemUserWorker(Integer systemuser_id, Integer related_worker_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(systemuser_id, -1, -1);
		Worker related_worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);

		systemuser.setWorker(null);
		related_worker.getSystemUsers().remove(systemuser);
		systemuser = systemUserDAO.store(systemuser);
		systemUserDAO.flush();

		related_worker = workerDAO.store(related_worker);
		workerDAO.flush();

		workerDAO.remove(related_worker);
		workerDAO.flush();

		return systemuser;
	}

	/**
	 * Return a count of all SystemUser entity
	 * 
	 */
	@Transactional
	public Integer countSystemUsers() {
		return ((Long) systemUserDAO.createQuerySingleResult("select count(o) from SystemUser o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public SystemUser findSystemUserByPrimaryKey(Integer id) {
		return systemUserDAO.findSystemUserByPrimaryKey(id);
	}

	/**
	 * Save an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Integer saveSystemUser(SystemUser systemuser) {
		SystemUser existingSystemUser = systemUserDAO.findSystemUserByPesel(systemuser.getPesel());
		if (existingSystemUser != null) {
			if (existingSystemUser != systemuser) {
				existingSystemUser.setId(systemuser.getId());
				existingSystemUser.setPassword(systemuser.getPassword());
				existingSystemUser.setDescription(systemuser.getDescription());
				existingSystemUser.setRegisterDate(systemuser.getRegisterDate());
				existingSystemUser.setIsActive(systemuser.getIsActive());
				existingSystemUser.setChangedPassword(systemuser.getChangedPassword());
				existingSystemUser.setEmail(systemuser.getEmail());
				existingSystemUser.setUnregisterDate(systemuser.getUnregisterDate());
			}
			systemuser = systemUserDAO.store(existingSystemUser);
		} else {
			systemuser.setPassword(passwordEncoder.encode(systemuser.getPassword()));
			systemuser = systemUserDAO.store(systemuser);
		}
		systemUserDAO.flush();
		return systemuser.getId();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */
	@Transactional
	public void deleteSystemUser(SystemUser systemuser) {
		systemUserDAO.remove(systemuser);
		systemUserDAO.flush();
	}

	/**
	 * Load an existing SystemUser entity
	 * 
	 */
	@Transactional
	public Set<SystemUser> loadSystemUsers() {
		return systemUserDAO.findAllSystemUsers();
	}

	/**
	 * Return all SystemUser entity
	 * 
	 */
	@Transactional
	public List<SystemUser> findAllSystemUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SystemUser>(systemUserDAO.findAllSystemUsers(startResult, maxRows));
	}
}
