package com.eclinic.service;

import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for StatusOfVisit entities
 * 
 */

@Service("StatusOfVisitService")
@Transactional
public class StatusOfVisitServiceImpl implements StatusOfVisitService {

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new StatusOfVisitServiceImpl.
	 *
	 */
	public StatusOfVisitServiceImpl() {
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@Transactional
	public void deleteStatusOfVisit(StatusOfVisit statusofvisit) {
		statusOfVisitDAO.remove(statusofvisit);
		statusOfVisitDAO.flush();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public StatusOfVisit deleteStatusOfVisitVisits(Integer statusofvisit_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id, -1, -1);

		related_visits.setStatusOfVisit(null);
		statusofvisit.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return statusofvisit;
	}

	/**
	 * Return a count of all StatusOfVisit entity
	 * 
	 */
	@Transactional
	public Integer countStatusOfVisits() {
		return ((Long) statusOfVisitDAO.createQuerySingleResult("select count(o) from StatusOfVisit o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public StatusOfVisit findStatusOfVisitByPrimaryKey(Integer id) {
		return statusOfVisitDAO.findStatusOfVisitByPrimaryKey(id);
	}

	/**
	 * Return all StatusOfVisit entity
	 * 
	 */
	@Transactional
	public List<StatusOfVisit> findAllStatusOfVisits(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<StatusOfVisit>(statusOfVisitDAO.findAllStatusOfVisits(startResult, maxRows));
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public StatusOfVisit saveStatusOfVisitVisits(Integer id, Visit related_visits) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(id, -1, -1);
		Visit existingvisits = visitDAO.findVisitByPrimaryKey(related_visits.getId());

		// copy into the existing record to preserve existing relationships
		if (existingvisits != null) {
			existingvisits.setId(related_visits.getId());
			existingvisits.setDateOfVisit(related_visits.getDateOfVisit());
			existingvisits.setDescriptionOfVisit(related_visits.getDescriptionOfVisit());
			existingvisits.setIsLeave(related_visits.getIsLeave());
			existingvisits.setSpecial(related_visits.getSpecial());
			related_visits = existingvisits;
		}

		related_visits.setStatusOfVisit(statusofvisit);
		statusofvisit.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		statusofvisit = statusOfVisitDAO.store(statusofvisit);
		statusOfVisitDAO.flush();

		return statusofvisit;
	}

	/**
	 * Load an existing StatusOfVisit entity
	 * 
	 */
	@Transactional
	public Set<StatusOfVisit> loadStatusOfVisits() {
		return statusOfVisitDAO.findAllStatusOfVisits();
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@Transactional
	public void saveStatusOfVisit(StatusOfVisit statusofvisit) {
		StatusOfVisit existingStatusOfVisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit.getId());

		if (existingStatusOfVisit != null) {
			if (existingStatusOfVisit != statusofvisit) {
				existingStatusOfVisit.setId(statusofvisit.getId());
				existingStatusOfVisit.setType(statusofvisit.getType());
			}
			statusofvisit = statusOfVisitDAO.store(existingStatusOfVisit);
		} else {
			statusofvisit = statusOfVisitDAO.store(statusofvisit);
		}
		statusOfVisitDAO.flush();
	}
}
