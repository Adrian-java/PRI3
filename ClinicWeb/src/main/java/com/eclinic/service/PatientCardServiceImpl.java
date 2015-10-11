package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for PatientCard entities
 * 
 */

@Service("PatientCardService")
@Transactional
public class PatientCardServiceImpl implements PatientCardService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Instantiates a new PatientCardServiceImpl.
	 *
	 */
	public PatientCardServiceImpl() {
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public PatientCard savePatientCardPatient(Integer id, Patient related_patient) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(id, -1, -1);
		Patient existingpatient = patientDAO.findPatientByPrimaryKey(related_patient.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatient != null) {
			existingpatient.setId(related_patient.getId());
			existingpatient.setName(related_patient.getName());
			existingpatient.setSurname(related_patient.getSurname());
			existingpatient.setDateOfBirth(related_patient.getDateOfBirth());
			existingpatient.setEMail(related_patient.getEMail());
			existingpatient.setPhoneNr(related_patient.getPhoneNr());
			existingpatient.setConfirmed(related_patient.getConfirmed());
			related_patient = existingpatient;
		}

		patientcard.setPatient(related_patient);
		related_patient.getPatientCards().add(patientcard);
		patientcard = patientCardDAO.store(patientcard);
		patientCardDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return patientcard;
	}

	/**
	 * Return a count of all PatientCard entity
	 * 
	 */
	@Transactional
	public Integer countPatientCards() {
		return ((Long) patientCardDAO.createQuerySingleResult("select count(o) from PatientCard o").getSingleResult()).intValue();
	}

	/**
	 * Return all PatientCard entity
	 * 
	 */
	@Transactional
	public List<PatientCard> findAllPatientCards(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<PatientCard>(patientCardDAO.findAllPatientCards(startResult, maxRows));
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public PatientCard deletePatientCardPatient(Integer patientcard_id, Integer related_patient_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		patientcard.setPatient(null);
		related_patient.getPatientCards().remove(patientcard);
		patientcard = patientCardDAO.store(patientcard);
		patientCardDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return patientcard;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public PatientCard deletePatientCardDoctor(Integer patientcard_id, Integer related_doctor_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		patientcard.setDoctor(null);
		related_doctor.getPatientCards().remove(patientcard);
		patientcard = patientCardDAO.store(patientcard);
		patientCardDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return patientcard;
	}

	/**
	 * Load an existing PatientCard entity
	 * 
	 */
	@Transactional
	public Set<PatientCard> loadPatientCards() {
		return patientCardDAO.findAllPatientCards();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@Transactional
	public void deletePatientCard(PatientCard patientcard) {
		patientCardDAO.remove(patientcard);
		patientCardDAO.flush();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public PatientCard savePatientCardDoctor(Integer id, Doctor related_doctor) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(id, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		}

		patientcard.setDoctor(related_doctor);
		related_doctor.getPatientCards().add(patientcard);
		patientcard = patientCardDAO.store(patientcard);
		patientCardDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return patientcard;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@Transactional
	public PatientCard deletePatientCardVisits(Integer patientcard_id, Integer related_visits_id) {
		Visit related_visits = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id, -1, -1);

		related_visits.setPatientCard(null);
		patientcard.getVisits().remove(related_visits);

		visitDAO.remove(related_visits);
		visitDAO.flush();

		return patientcard;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@Transactional
	public PatientCard savePatientCardVisits(Integer id, Visit related_visits) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(id, -1, -1);
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

		related_visits.setPatientCard(patientcard);
		patientcard.getVisits().add(related_visits);
		related_visits = visitDAO.store(related_visits);
		visitDAO.flush();

		patientcard = patientCardDAO.store(patientcard);
		patientCardDAO.flush();

		return patientcard;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@Transactional
	public Integer savePatientCard(PatientCard patientcard) {
		PatientCard existingPatientCard = patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId());

		if (existingPatientCard != null) {
			if (existingPatientCard != patientcard) {
				existingPatientCard.setId(patientcard.getId());
				existingPatientCard.setRegisterDate(patientcard.getRegisterDate());
			}
			patientcard = patientCardDAO.store(existingPatientCard);
		} else {
			patientcard = patientCardDAO.store(patientcard);
		}
		patientCardDAO.flush();
		return patientcard.getId();
	}

	/**
	 */
	@Transactional
	public PatientCard findPatientCardByPrimaryKey(Integer id) {
		return patientCardDAO.findPatientCardByPrimaryKey(id);
	}
}
