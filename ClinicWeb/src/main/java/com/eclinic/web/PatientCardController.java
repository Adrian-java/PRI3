package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;

import com.eclinic.service.PatientCardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for PatientCard entities
 * 
 */

@Controller("PatientCardController")
public class PatientCardController {

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
	 * Service injected by Spring that provides CRUD operations for PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardService patientCardService;

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/savePatientCardVisits")
	public ModelAndView savePatientCardVisits(@RequestParam Integer patientcard_id, @ModelAttribute Visit visits) {
		PatientCard parent_patientcard = patientCardService.savePatientCardVisits(patientcard_id, visits);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", parent_patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectPatientCardVisits")
	public ModelAndView selectPatientCardVisits(@RequestParam Integer patientcard_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("visit", visit);
		mav.setViewName("patientcard/visits/viewVisits.jsp");

		return mav;
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/deletePatientCard")
	public String deletePatientCard(@RequestParam Integer idKey) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(idKey);
		patientCardService.deletePatientCard(patientcard);
		return "forward:/indexPatientCard";
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectPatientCardDoctor")
	public ModelAndView selectPatientCardDoctor(@RequestParam Integer patientcard_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("patientcard/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/patientcardController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newPatientCardDoctor")
	public ModelAndView newPatientCardDoctor(@RequestParam Integer patientcard_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("patientcard/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Entry point to show all PatientCard entities
	 * 
	 */
	public String indexPatientCard() {
		return "redirect:/indexPatientCard";
	}

	/**
	 * Select an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/selectPatientCard")
	public ModelAndView selectPatientCard(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/savePatientCard")
	public String savePatientCard(@ModelAttribute PatientCard patientcard) {
		patientCardService.savePatientCard(patientcard);
		return "forward:/indexPatientCard";
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deletePatientCardPatient")
	public ModelAndView deletePatientCardPatient(@RequestParam Integer patientcard_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		PatientCard patientcard = patientCardService.deletePatientCardPatient(patientcard_id, related_patient_id);

		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editPatientCardDoctor")
	public ModelAndView editPatientCardDoctor(@RequestParam Integer patientcard_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("patientcard/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/editPatientCard")
	public ModelAndView editPatientCard(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/editPatientCard.jsp");

		return mav;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/savePatientCardPatient")
	public ModelAndView savePatientCardPatient(@RequestParam Integer patientcard_id, @ModelAttribute Patient patient) {
		PatientCard parent_patientcard = patientCardService.savePatientCardPatient(patientcard_id, patient);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", parent_patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectPatientCardPatient")
	public ModelAndView selectPatientCardPatient(@RequestParam Integer patientcard_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patient", patient);
		mav.setViewName("patientcard/patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/savePatientCardDoctor")
	public ModelAndView savePatientCardDoctor(@RequestParam Integer patientcard_id, @ModelAttribute Doctor doctor) {
		PatientCard parent_patientcard = patientCardService.savePatientCardDoctor(patientcard_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", parent_patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Show all PatientCard entities
	 * 
	 */
	@RequestMapping("/indexPatientCard")
	public ModelAndView listPatientCards() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcards", patientCardService.loadPatientCards());

		mav.setViewName("patientcard/listPatientCards.jsp");

		return mav;
	}

	/**
	 * Show all Visit entities by PatientCard
	 * 
	 */
	@RequestMapping("/listPatientCardVisits")
	public ModelAndView listPatientCardVisits(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/visits/listVisits.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientCardDoctor")
	public ModelAndView confirmDeletePatientCardDoctor(@RequestParam Integer patientcard_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("patientcard_id", patientcard_id);
		mav.setViewName("patientcard/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editPatientCardPatient")
	public ModelAndView editPatientCardPatient(@RequestParam Integer patientcard_id, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patient", patient);
		mav.setViewName("patientcard/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newPatientCardPatient")
	public ModelAndView newPatientCardPatient(@RequestParam Integer patientcard_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("patientcard/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deletePatientCardDoctor")
	public ModelAndView deletePatientCardDoctor(@RequestParam Integer patientcard_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		PatientCard patientcard = patientCardService.deletePatientCardDoctor(patientcard_id, related_doctor_id);

		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deletePatientCardVisits")
	public ModelAndView deletePatientCardVisits(@RequestParam Integer patientcard_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		PatientCard patientcard = patientCardService.deletePatientCardVisits(patientcard_id, related_visits_id);

		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Select the child Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientCardPatient")
	public ModelAndView confirmDeletePatientCardPatient(@RequestParam Integer patientcard_id, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(related_patient_id));
		mav.addObject("patientcard_id", patientcard_id);
		mav.setViewName("patientcard/patient/deletePatient.jsp");

		return mav;
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping("/newPatientCard")
	public ModelAndView newPatientCard() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", new PatientCard());
		mav.addObject("newFlag", true);
		mav.setViewName("patientcard/editPatientCard.jsp");

		return mav;
	}

	/**
	 * Show all Patient entities by PatientCard
	 * 
	 */
	@RequestMapping("/listPatientCardPatient")
	public ModelAndView listPatientCardPatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/patient/listPatient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editPatientCardVisits")
	public ModelAndView editPatientCardVisits(@RequestParam Integer patientcard_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("visit", visit);
		mav.setViewName("patientcard/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientCardVisits")
	public ModelAndView confirmDeletePatientCardVisits(@RequestParam Integer patientcard_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visits_id));
		mav.addObject("patientcard_id", patientcard_id);
		mav.setViewName("patientcard/visits/deleteVisits.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by PatientCard
	 * 
	 */
	@RequestMapping("/listPatientCardDoctor")
	public ModelAndView listPatientCardDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Select the PatientCard entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientCard")
	public ModelAndView confirmDeletePatientCard(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(idKey));
		mav.setViewName("patientcard/deletePatientCard.jsp");

		return mav;
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newPatientCardVisits")
	public ModelAndView newPatientCardVisits(@RequestParam Integer patientcard_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patientcard_id", patientcard_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("patientcard/visits/editVisits.jsp");

		return mav;
	}
}