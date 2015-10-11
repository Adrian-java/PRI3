package com.eclinic.service;

import com.eclinic.dao.ApplicationParameterDAO;

import com.eclinic.domain.ApplicationParameter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for ApplicationParameter entities
 * 
 */

@Service("ApplicationParameterService")
@Transactional
public class ApplicationParameterServiceImpl implements
		ApplicationParameterService {

	/**
	 * DAO injected by Spring that manages ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterDAO applicationParameterDAO;

	/**
	 * Instantiates a new ApplicationParameterServiceImpl.
	 *
	 */
	public ApplicationParameterServiceImpl() {
	}

	/**
	 */
	@Transactional
	public ApplicationParameter findApplicationParameterByPrimaryKey(Integer id) {
		return applicationParameterDAO.findApplicationParameterByPrimaryKey(id);
	}

	/**
	 * Save an existing ApplicationParameter entity
	 * 
	 */
	@Transactional
	public void saveApplicationParameter(ApplicationParameter applicationparameter) {
		ApplicationParameter existingApplicationParameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId());

		if (existingApplicationParameter != null) {
			if (existingApplicationParameter != applicationparameter) {
				existingApplicationParameter.setId(applicationparameter.getId());
				existingApplicationParameter.setKey(applicationparameter.getKey());
				existingApplicationParameter.setValueString(applicationparameter.getValueString());
				existingApplicationParameter.setValueNumber(applicationparameter.getValueNumber());
			}
			applicationparameter = applicationParameterDAO.store(existingApplicationParameter);
		} else {
			applicationparameter = applicationParameterDAO.store(applicationparameter);
		}
		applicationParameterDAO.flush();
	}

	/**
	 * Return all ApplicationParameter entity
	 * 
	 */
	@Transactional
	public List<ApplicationParameter> findAllApplicationParameters(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<ApplicationParameter>(applicationParameterDAO.findAllApplicationParameters(startResult, maxRows));
	}

	/**
	 * Delete an existing ApplicationParameter entity
	 * 
	 */
	@Transactional
	public void deleteApplicationParameter(ApplicationParameter applicationparameter) {
		applicationParameterDAO.remove(applicationparameter);
		applicationParameterDAO.flush();
	}

	/**
	 * Return a count of all ApplicationParameter entity
	 * 
	 */
	@Transactional
	public Integer countApplicationParameters() {
		return ((Long) applicationParameterDAO.createQuerySingleResult("select count(o) from ApplicationParameter o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing ApplicationParameter entity
	 * 
	 */
	@Transactional
	public Set<ApplicationParameter> loadApplicationParameters() {
		return applicationParameterDAO.findAllApplicationParameters();
	}
}
