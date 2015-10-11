package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Visit entities
 * 
 */
public interface VisitService {

	/**
	 * Load an existing Visit entity
	 * 
	 */
	public Set<Visit> loadVisits();

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	public Visit deleteVisitTypeOfVisit(Integer visit_id, Integer related_typeofvisit_id);

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	public void deleteVisit(Visit visit);

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	public Visit deleteVisitPatientCard(Integer visit_id_1, Integer related_patientcard_id);

	/**
	 * Return all Visit entity
	 * 
	 */
	public List<Visit> findAllVisits(Integer startResult, Integer maxRows);

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	public Visit saveVisitTypeOfVisit(Integer id, TypeOfVisit related_typeofvisit);

	/**
	 * Save an existing Visit entity
	 * 
	 */
	public Integer saveVisit(Visit visit_1);

	/**
	 * Return a count of all Visit entity
	 * 
	 */
	public Integer countVisits();

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	public Visit deleteVisitReceptionist(Integer visit_id_2, Integer related_receptionist_id);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Visit saveVisitDoctor(Integer id_1, Doctor related_doctor);

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	public Visit saveVisitStatusOfVisit(Integer id_2, StatusOfVisit related_statusofvisit);

	/**
	 */
	public Visit findVisitByPrimaryKey(Integer id_3);

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	public Visit deleteVisitSickLeaves(Integer visit_id_3, Integer related_sickleaves_id);

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	public Visit deleteVisitStatusOfVisit(Integer visit_id_4, Integer related_statusofvisit_id);

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	public Visit saveVisitSickLeaves(Integer id_4, SickLeave related_sickleaves);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Visit deleteVisitDoctor(Integer visit_id_5, Integer related_doctor_id);

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	public Visit saveVisitPatientCard(Integer id_5, PatientCard related_patientcard);

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	public Visit saveVisitReceptionist(Integer id_6, Receptionist related_receptionist);
}