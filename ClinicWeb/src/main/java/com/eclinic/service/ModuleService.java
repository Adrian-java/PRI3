package com.eclinic.service;

import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Module entities
 * 
 */
public interface ModuleService {

	/**
	 * Load an existing Module entity
	 * 
	 */
	public Set<Module> loadModules();

	/**
	 * Return all Module entity
	 * 
	 */
	public List<Module> findAllModules(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public Module saveModulePermissions(Integer id, Permission related_permissions);

	/**
	 */
	public Module findModuleByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public Module deleteModulePermissions(Integer module_id, Integer related_permissions_id);

	/**
	 * Return a count of all Module entity
	 * 
	 */
	public Integer countModules();

	/**
	 * Delete an existing Module entity
	 * 
	 */
	public void deleteModule(Module module);

	/**
	 * Save an existing Module entity
	 * 
	 */
	public void saveModule(Module module_1);
}