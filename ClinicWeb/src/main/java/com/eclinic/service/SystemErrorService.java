package com.eclinic.service;

import com.eclinic.domain.SystemError;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SystemError entities
 * 
 */
public interface SystemErrorService {

	/**
	 */
	public SystemError findSystemErrorByPrimaryKey(Integer id);

	/**
	 * Save an existing SystemError entity
	 * 
	 */
	public void saveSystemError(SystemError systemerror);

	/**
	 * Delete an existing SystemError entity
	 * 
	 */
	public void deleteSystemError(SystemError systemerror_1);

	/**
	 * Load an existing SystemError entity
	 * 
	 */
	public Set<SystemError> loadSystemErrors();

	/**
	 * Return all SystemError entity
	 * 
	 */
	public List<SystemError> findAllSystemErrors(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all SystemError entity
	 * 
	 */
	public Integer countSystemErrors();
}