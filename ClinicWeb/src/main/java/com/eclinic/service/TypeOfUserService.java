package com.eclinic.service;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for TypeOfUser entities
 * 
 */
public interface TypeOfUserService {

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public TypeOfUser saveTypeOfUserPermission(Integer id, Permission related_permission);

	/**
	 * Return a count of all TypeOfUser entity
	 * 
	 */
	public Integer countTypeOfUsers();

	/**
	 * Return all TypeOfUser entity
	 * 
	 */
	public List<TypeOfUser> findAllTypeOfUsers(Integer startResult, Integer maxRows);

	/**
	 * Load an existing TypeOfUser entity
	 * 
	 */
	public Set<TypeOfUser> loadTypeOfUsers();

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public TypeOfUser deleteTypeOfUserPermission(Integer typeofuser_id, Integer related_permission_id);

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	public void deleteTypeOfUser(TypeOfUser typeofuser);

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	public void saveTypeOfUser(TypeOfUser typeofuser_1);

	/**
	 */
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id_1);
}