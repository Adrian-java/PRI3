package com.eclinic.service;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Module entities
 * 
 */

@Service("ModuleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

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
	 * Instantiates a new ModuleServiceImpl.
	 *
	 */
	public ModuleServiceImpl() {
	}

	/**
	 * Load an existing Module entity
	 * 
	 */
	@Transactional
	public Set<Module> loadModules() {
		return moduleDAO.findAllModules();
	}

	/**
	 * Return all Module entity
	 * 
	 */
	@Transactional
	public List<Module> findAllModules(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Module>(moduleDAO.findAllModules(startResult, maxRows));
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public Module saveModulePermissions(Integer id, Permission related_permissions) {
		Module module = moduleDAO.findModuleByPrimaryKey(id, -1, -1);
		Permission existingpermissions = permissionDAO.findPermissionByPrimaryKey(related_permissions.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermissions != null) {
			existingpermissions.setId(related_permissions.getId());
			existingpermissions.setDisplay(related_permissions.getDisplay());
			existingpermissions.setEdit(related_permissions.getEdit());
			existingpermissions.setExecute(related_permissions.getExecute());
			related_permissions = existingpermissions;
		}

		related_permissions.setModule(module);
		module.getPermissions().add(related_permissions);
		related_permissions = permissionDAO.store(related_permissions);
		permissionDAO.flush();

		module = moduleDAO.store(module);
		moduleDAO.flush();

		return module;
	}

	/**
	 */
	@Transactional
	public Module findModuleByPrimaryKey(Integer id) {
		return moduleDAO.findModuleByPrimaryKey(id);
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public Module deleteModulePermissions(Integer module_id, Integer related_permissions_id) {
		Permission related_permissions = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);

		Module module = moduleDAO.findModuleByPrimaryKey(module_id, -1, -1);

		related_permissions.setModule(null);
		module.getPermissions().remove(related_permissions);

		permissionDAO.remove(related_permissions);
		permissionDAO.flush();

		return module;
	}

	/**
	 * Return a count of all Module entity
	 * 
	 */
	@Transactional
	public Integer countModules() {
		return ((Long) moduleDAO.createQuerySingleResult("select count(o) from Module o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */
	@Transactional
	public void deleteModule(Module module) {
		moduleDAO.remove(module);
		moduleDAO.flush();
	}

	/**
	 * Save an existing Module entity
	 * 
	 */
	@Transactional
	public void saveModule(Module module) {
		Module existingModule = moduleDAO.findModuleByPrimaryKey(module.getId());

		if (existingModule != null) {
			if (existingModule != module) {
				existingModule.setId(module.getId());
				existingModule.setName(module.getName());
				existingModule.setVisibility(module.getVisibility());
			}
			module = moduleDAO.store(existingModule);
		} else {
			module = moduleDAO.store(module);
		}
		moduleDAO.flush();
	}
}
