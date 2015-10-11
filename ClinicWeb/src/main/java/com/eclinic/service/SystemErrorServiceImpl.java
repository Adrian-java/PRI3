package com.eclinic.service;

import com.eclinic.dao.SystemErrorDAO;

import com.eclinic.domain.SystemError;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SystemError entities
 * 
 */

@Service("SystemErrorService")
@Transactional
public class SystemErrorServiceImpl implements SystemErrorService {

	/**
	 * DAO injected by Spring that manages SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorDAO systemErrorDAO;

	/**
	 * Instantiates a new SystemErrorServiceImpl.
	 *
	 */
	public SystemErrorServiceImpl() {
	}

	/**
	 */
	@Transactional
	public SystemError findSystemErrorByPrimaryKey(Integer id) {
		return systemErrorDAO.findSystemErrorByPrimaryKey(id);
	}

	/**
	 * Save an existing SystemError entity
	 * 
	 */
	@Transactional
	public void saveSystemError(SystemError systemerror) {
		SystemError existingSystemError = systemErrorDAO.findSystemErrorByPrimaryKey(systemerror.getId());

		if (existingSystemError != null) {
			if (existingSystemError != systemerror) {
				existingSystemError.setId(systemerror.getId());
				existingSystemError.setDate(systemerror.getDate());
				existingSystemError.setGeneratedErrorDescription(systemerror.getGeneratedErrorDescription());
				existingSystemError.setFixed(systemerror.getFixed());
			}
			systemerror = systemErrorDAO.store(existingSystemError);
		} else {
			systemerror = systemErrorDAO.store(systemerror);
		}
		systemErrorDAO.flush();
	}

	/**
	 * Delete an existing SystemError entity
	 * 
	 */
	@Transactional
	public void deleteSystemError(SystemError systemerror) {
		systemErrorDAO.remove(systemerror);
		systemErrorDAO.flush();
	}

	/**
	 * Load an existing SystemError entity
	 * 
	 */
	@Transactional
	public Set<SystemError> loadSystemErrors() {
		return systemErrorDAO.findAllSystemErrors();
	}

	/**
	 * Return all SystemError entity
	 * 
	 */
	@Transactional
	public List<SystemError> findAllSystemErrors(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SystemError>(systemErrorDAO.findAllSystemErrors(startResult, maxRows));
	}

	/**
	 * Return a count of all SystemError entity
	 * 
	 */
	@Transactional
	public Integer countSystemErrors() {
		return ((Long) systemErrorDAO.createQuerySingleResult("select count(o) from SystemError o").getSingleResult()).intValue();
	}
}
