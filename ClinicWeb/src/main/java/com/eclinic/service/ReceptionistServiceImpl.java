package com.eclinic.service;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
import com.eclinic.domain.Worker;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Receptionist entities
 * 
 */

@Service("ReceptionistService")
@Transactional
public class ReceptionistServiceImpl implements ReceptionistService {

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Instantiates a new ReceptionistServiceImpl.
	 *
	 */
	public ReceptionistServiceImpl() {
	}

	/**
	 * Load an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Set<Receptionist> loadReceptionists() {
		return receptionistDAO.findAllReceptionists();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@Transactional
	public void deleteReceptionist(Receptionist receptionist) {
		receptionistDAO.remove(receptionist);
		receptionistDAO.flush();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public Receptionist saveReceptionistVisits(Integer id, Visit related_visits) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(id, -1, -1);
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

		related_visits.setReceptionist(receptionist);
		receptionist.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		receptionist = receptionistDAO.store(receptionist);
		receptionistDAO.flush();

		return receptionist;
	}

	/**
	 */
	@Transactional
	public Receptionist findReceptionistByPrimaryKey(Integer id) {
		return receptionistDAO.findReceptionistByPrimaryKey(id);
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Transactional
	public Receptionist saveReceptionistWorkers(Integer id, Worker related_workers) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(id, -1, -1);
		Worker existingworkers = workerDAO.findWorkerByPrimaryKey(related_workers.getId());

		// copy into the existing record to preserve existing relationships
		if (existingworkers != null) {
			existingworkers.setId(related_workers.getId());
			related_workers = existingworkers;
		} else {
			related_workers = workerDAO.store(related_workers);
			workerDAO.flush();
		}

		related_workers.setReceptionist(receptionist);
		receptionist.getWorkers().add(related_workers);
		related_workers = workerDAO.store(related_workers);
		workerDAO.flush();

		receptionist = receptionistDAO.store(receptionist);
		receptionistDAO.flush();

		return receptionist;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public Receptionist deleteReceptionistVisits(Integer receptionist_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		related_visits.setReceptionist(null);
		receptionist.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return receptionist;
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@Transactional
	public Integer saveReceptionist(Receptionist receptionist) {
		Receptionist existingReceptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId());

		if (existingReceptionist != null) {
			if (existingReceptionist != receptionist) {
				existingReceptionist.setId(receptionist.getId());
				existingReceptionist.setName(receptionist.getName());
				existingReceptionist.setSurname(receptionist.getSurname());
				existingReceptionist.setPhoneNr(receptionist.getPhoneNr());
				existingReceptionist.setAccess(receptionist.getAccess());
			}
			receptionist = receptionistDAO.store(existingReceptionist);
		} else {
			receptionist = receptionistDAO.store(receptionist);
		}
		receptionistDAO.flush();
		return receptionist.getId();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@Transactional
	public Receptionist deleteReceptionistWorkers(Integer receptionist_id, Integer related_workers_id) {
		Worker related_workers = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		related_workers.setReceptionist(null);
		receptionist.getWorkers().remove(related_workers);

		workerDAO.remove(related_workers);
		workerDAO.flush();

		return receptionist;
	}

	/**
	 * Return all Receptionist entity
	 * 
	 */
	@Transactional
	public List<Receptionist> findAllReceptionists(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Receptionist>(receptionistDAO.findAllReceptionists(startResult, maxRows));
	}

	/**
	 * Return a count of all Receptionist entity
	 * 
	 */
	@Transactional
	public Integer countReceptionists() {
		return ((Long) receptionistDAO.createQuerySingleResult("select count(o) from Receptionist o").getSingleResult()).intValue();
	}
}
