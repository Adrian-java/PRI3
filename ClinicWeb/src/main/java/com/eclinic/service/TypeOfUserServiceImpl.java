package com.eclinic.service;

import com.eclinic.dao.PermissionDAO;
import com.eclinic.dao.TypeOfUserDAO;

import com.eclinic.domain.Permission;
import com.eclinic.domain.TypeOfUser;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for TypeOfUser entities
 * 
 */

@Service("TypeOfUserService")
@Transactional
public class TypeOfUserServiceImpl implements TypeOfUserService {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages TypeOfUser entities
	 * 
	 */
	@Autowired
	private TypeOfUserDAO typeOfUserDAO;

	/**
	 * Instantiates a new TypeOfUserServiceImpl.
	 *
	 */
	public TypeOfUserServiceImpl() {
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public TypeOfUser saveTypeOfUserPermission(Integer id, Permission related_permission) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(id, -1, -1);
		Permission existingpermission = permissionDAO.findPermissionByPrimaryKey(related_permission.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermission != null) {
			existingpermission.setId(related_permission.getId());
			existingpermission.setDisplay(related_permission.getDisplay());
			existingpermission.setEdit(related_permission.getEdit());
			existingpermission.setExecute(related_permission.getExecute());
			related_permission = existingpermission;
		}

		typeofuser.setPermission(related_permission);
		related_permission.getTypeOfUsers().add(typeofuser);
		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		return typeofuser;
	}

	/**
	 * Return a count of all TypeOfUser entity
	 * 
	 */
	@Transactional
	public Integer countTypeOfUsers() {
		return ((Long) typeOfUserDAO.createQuerySingleResult("select count(o) from TypeOfUser o").getSingleResult()).intValue();
	}

	/**
	 * Return all TypeOfUser entity
	 * 
	 */
	@Transactional
	public List<TypeOfUser> findAllTypeOfUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<TypeOfUser>(typeOfUserDAO.findAllTypeOfUsers(startResult, maxRows));
	}

	/**
	 * Load an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public Set<TypeOfUser> loadTypeOfUsers() {
		return typeOfUserDAO.findAllTypeOfUsers();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public TypeOfUser deleteTypeOfUserPermission(Integer typeofuser_id, Integer related_permission_id) {
		TypeOfUser typeofuser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser_id, -1, -1);
		Permission related_permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		typeofuser.setPermission(null);
		related_permission.getTypeOfUsers().remove(typeofuser);
		typeofuser = typeOfUserDAO.store(typeofuser);
		typeOfUserDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		permissionDAO.remove(related_permission);
		permissionDAO.flush();

		return typeofuser;
	}

	/**
	 * Delete an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public void deleteTypeOfUser(TypeOfUser typeofuser) {
		typeOfUserDAO.remove(typeofuser);
		typeOfUserDAO.flush();
	}

	/**
	 * Save an existing TypeOfUser entity
	 * 
	 */
	@Transactional
	public void saveTypeOfUser(TypeOfUser typeofuser) {
		TypeOfUser existingTypeOfUser = typeOfUserDAO.findTypeOfUserByPrimaryKey(typeofuser.getId());

		if (existingTypeOfUser != null) {
			if (existingTypeOfUser != typeofuser) {
				existingTypeOfUser.setId(typeofuser.getId());
				existingTypeOfUser.setType(typeofuser.getType());
				existingTypeOfUser.setDescription(typeofuser.getDescription());
			}
			typeofuser = typeOfUserDAO.store(existingTypeOfUser);
		} else {
			typeofuser = typeOfUserDAO.store(typeofuser);
		}
		typeOfUserDAO.flush();
	}

	/**
	 */
	@Transactional
	public TypeOfUser findTypeOfUserByPrimaryKey(Integer id) {
		return typeOfUserDAO.findTypeOfUserByPrimaryKey(id);
	}
}
