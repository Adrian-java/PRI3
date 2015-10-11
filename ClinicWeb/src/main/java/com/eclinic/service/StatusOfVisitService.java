package com.eclinic.service;

import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for StatusOfVisit entities
 * 
 */
public interface StatusOfVisitService {

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	public void deleteStatusOfVisit(StatusOfVisit statusofvisit);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public StatusOfVisit deleteStatusOfVisitVisits(Integer statusofvisit_id, Integer related_visits_id);

	/**
	 * Return a count of all StatusOfVisit entity
	 * 
	 */
	public Integer countStatusOfVisits();

	/**
	 */
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id);

	/**
	 * Return all StatusOfVisit entity
	 * 
	 */
	public List<StatusOfVisit> findAllStatusOfVisits(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public StatusOfVisit saveStatusOfVisitVisits(Integer id_1, Visit related_visits);

	/**
	 * Load an existing StatusOfVisit entity
	 * 
	 */
	public Set<StatusOfVisit> loadStatusOfVisits();

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	public void saveStatusOfVisit(StatusOfVisit statusofvisit_1);
}