package com.eclinic.service;

import com.eclinic.domain.ApplicationParameter;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for ApplicationParameter entities
 * 
 */
public interface ApplicationParameterService {

	/**
	 */
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id);

	/**
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	public void saveApplicationParameter(ApplicationParameter applicationparameter);

	/**
	 * Return all ApplicationParameter entity
	 * 
	 */
	public List<ApplicationParameter> findAllApplicationParameters(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	public void deleteApplicationParameter(ApplicationParameter applicationparameter_1);

	/**
	 * Return a count of all ApplicationParameter entity
	 * 
	 */
	public Integer countApplicationParameters();

	/**
	 * Load an existing ApplicationParameter entity
	 * 
	 */
	public Set<ApplicationParameter> loadApplicationParameters();
}