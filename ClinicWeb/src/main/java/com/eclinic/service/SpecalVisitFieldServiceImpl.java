package com.eclinic.service;

import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;

import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for SpecalVisitField entities
 * 
 */

@Service("SpecalVisitFieldService")
@Transactional
public class SpecalVisitFieldServiceImpl implements SpecalVisitFieldService {

	/**
	 * DAO injected by Spring that manages SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldDAO specalVisitFieldDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * Instantiates a new SpecalVisitFieldServiceImpl.
	 *
	 */
	public SpecalVisitFieldServiceImpl() {
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	@Transactional
	public void deleteSpecalVisitField(SpecalVisitField specalvisitfield) {
		specalVisitFieldDAO.remove(specalvisitfield);
		specalVisitFieldDAO.flush();
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@Transactional
	public SpecalVisitField deleteSpecalVisitFieldSpecialization(Integer specalvisitfield_id, Integer related_specialization_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id, -1, -1);
		Specialization related_specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		specalvisitfield.setSpecialization(null);
		related_specialization.getSpecalVisitFields().remove(specalvisitfield);
		specalvisitfield = specalVisitFieldDAO.store(specalvisitfield);
		specalVisitFieldDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		specializationDAO.remove(related_specialization);
		specializationDAO.flush();

		return specalvisitfield;
	}

	/**
	 */
	@Transactional
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id) {
		return specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(id);
	}

	/**
	 * Return a count of all SpecalVisitField entity
	 * 
	 */
	@Transactional
	public Integer countSpecalVisitFields() {
		return ((Long) specalVisitFieldDAO.createQuerySingleResult("select count(o) from SpecalVisitField o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	@Transactional
	public void saveSpecalVisitField(SpecalVisitField specalvisitfield) {
		SpecalVisitField existingSpecalVisitField = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId());

		if (existingSpecalVisitField != null) {
			if (existingSpecalVisitField != specalvisitfield) {
				existingSpecalVisitField.setId(specalvisitfield.getId());
				existingSpecalVisitField.setName(specalvisitfield.getName());
				existingSpecalVisitField.setValue(specalvisitfield.getValue());
				existingSpecalVisitField.setTypeOfValue(specalvisitfield.getTypeOfValue());
			}
			specalvisitfield = specalVisitFieldDAO.store(existingSpecalVisitField);
		} else {
			specalvisitfield = specalVisitFieldDAO.store(specalvisitfield);
		}
		specalVisitFieldDAO.flush();
	}

	/**
	 * Return all SpecalVisitField entity
	 * 
	 */
	@Transactional
	public List<SpecalVisitField> findAllSpecalVisitFields(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<SpecalVisitField>(specalVisitFieldDAO.findAllSpecalVisitFields(startResult, maxRows));
	}

	/**
	 * Load an existing SpecalVisitField entity
	 * 
	 */
	@Transactional
	public Set<SpecalVisitField> loadSpecalVisitFields() {
		return specalVisitFieldDAO.findAllSpecalVisitFields();
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@Transactional
	public SpecalVisitField saveSpecalVisitFieldSpecialization(Integer id, Specialization related_specialization) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(id, -1, -1);
		Specialization existingspecialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization.getId());

		// copy into the existing record to preserve existing relationships
		if (existingspecialization != null) {
			existingspecialization.setId(related_specialization.getId());
			existingspecialization.setName(related_specialization.getName());
			existingspecialization.setDescription(related_specialization.getDescription());
			related_specialization = existingspecialization;
		}

		specalvisitfield.setSpecialization(related_specialization);
		related_specialization.getSpecalVisitFields().add(specalvisitfield);
		specalvisitfield = specalVisitFieldDAO.store(specalvisitfield);
		specalVisitFieldDAO.flush();

		related_specialization = specializationDAO.store(related_specialization);
		specializationDAO.flush();

		return specalvisitfield;
	}
}
