package com.eclinic.service;

import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for TypeOfVisit entities
 * 
 */

@Service("TypeOfVisitService")
@Transactional
public class TypeOfVisitServiceImpl implements TypeOfVisitService {

	/**
	 * DAO injected by Spring that manages TypeOfVisit entities
	 * 
	 */
	@Autowired
	private TypeOfVisitDAO typeOfVisitDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new TypeOfVisitServiceImpl.
	 *
	 */
	public TypeOfVisitServiceImpl() {
	}

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@Transactional
	public void deleteTypeOfVisit(TypeOfVisit typeofvisit) {
		typeOfVisitDAO.remove(typeofvisit);
		typeOfVisitDAO.flush();
	}

	/**
	 */
	@Transactional
	public TypeOfVisit findTypeOfVisitByPrimaryKey(Integer id) {
		return typeOfVisitDAO.findTypeOfVisitByPrimaryKey(id);
	}

	/**
	 * Load an existing TypeOfVisit entity
	 * 
	 */
	@Transactional
	public Set<TypeOfVisit> loadTypeOfVisits() {
		return typeOfVisitDAO.findAllTypeOfVisits();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public TypeOfVisit saveTypeOfVisitVisits(Integer id, Visit related_visits) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(id, -1, -1);
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

		related_visits.setTypeOfVisit(typeofvisit);
		typeofvisit.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		typeofvisit = typeOfVisitDAO.store(typeofvisit);
		typeOfVisitDAO.flush();

		return typeofvisit;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public TypeOfVisit deleteTypeOfVisitVisits(Integer typeofvisit_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id, -1, -1);

		related_visits.setTypeOfVisit(null);
		typeofvisit.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return typeofvisit;
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@Transactional
	public void saveTypeOfVisit(TypeOfVisit typeofvisit) {
		TypeOfVisit existingTypeOfVisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit.getId());

		if (existingTypeOfVisit != null) {
			if (existingTypeOfVisit != typeofvisit) {
				existingTypeOfVisit.setId(typeofvisit.getId());
				existingTypeOfVisit.setName(typeofvisit.getName());
				existingTypeOfVisit.setDescription(typeofvisit.getDescription());
				existingTypeOfVisit.setDuration(typeofvisit.getDuration());
			}
			typeofvisit = typeOfVisitDAO.store(existingTypeOfVisit);
		} else {
			typeofvisit = typeOfVisitDAO.store(typeofvisit);
		}
		typeOfVisitDAO.flush();
	}

	/**
	 * Return a count of all TypeOfVisit entity
	 * 
	 */
	@Transactional
	public Integer countTypeOfVisits() {
		return ((Long) typeOfVisitDAO.createQuerySingleResult("select count(o) from TypeOfVisit o").getSingleResult()).intValue();
	}

	/**
	 * Return all TypeOfVisit entity
	 * 
	 */
	@Transactional
	public List<TypeOfVisit> findAllTypeOfVisits(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<TypeOfVisit>(typeOfVisitDAO.findAllTypeOfVisits(startResult, maxRows));
	}
}
