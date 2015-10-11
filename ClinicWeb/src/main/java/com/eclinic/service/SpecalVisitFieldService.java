package com.eclinic.service;

import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for SpecalVisitField entities
 * 
 */
public interface SpecalVisitFieldService {

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	public void deleteSpecalVisitField(SpecalVisitField specalvisitfield);

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	public SpecalVisitField deleteSpecalVisitFieldSpecialization(Integer specalvisitfield_id, Integer related_specialization_id);

	/**
	 */
	public SpecalVisitField findSpecalVisitFieldByPrimaryKey(Integer id);

	/**
	 * Return a count of all SpecalVisitField entity
	 * 
	 */
	public Integer countSpecalVisitFields();

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */
	public void saveSpecalVisitField(SpecalVisitField specalvisitfield_1);

	/**
	 * Return all SpecalVisitField entity
	 * 
	 */
	public List<SpecalVisitField> findAllSpecalVisitFields(Integer startResult, Integer maxRows);

	/**
	 * Load an existing SpecalVisitField entity
	 * 
	 */
	public Set<SpecalVisitField> loadSpecalVisitFields();

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	public SpecalVisitField saveSpecalVisitFieldSpecialization(Integer id_1, Specialization related_specialization);
}