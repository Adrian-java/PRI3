package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.StatusOfVisitDAO;
import com.eclinic.dao.TypeOfVisitDAO;
import com.eclinic.dao.VisitDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.StatusOfVisit;
import com.eclinic.domain.TypeOfVisit;
import com.eclinic.domain.Visit;

import com.eclinic.service.VisitService;

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
 * Spring MVC controller that handles CRUD requests for Visit entities
 * 
 */

@Controller("VisitController")
public class VisitController {

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
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages StatusOfVisit entities
	 * 
	 */
	@Autowired
	private StatusOfVisitDAO statusOfVisitDAO;

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
	 * Service injected by Spring that provides CRUD operations for Visit entities
	 * 
	 */
	@Autowired
	private VisitService visitService;

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editVisit")
	public ModelAndView editVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/editVisit.jsp");

		return mav;
	}

	/**
	 * Show all Receptionist entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitReceptionist")
	public ModelAndView listVisitReceptionist(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/receptionist/listReceptionist.jsp");

		return mav;
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/deleteVisitPatientCard")
	public ModelAndView deleteVisitPatientCard(@RequestParam Integer visit_id, @RequestParam Integer related_patientcard_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitPatientCard(visit_id, related_patientcard_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Visit entities
	 * 
	 */
	public String indexVisit() {
		return "redirect:/indexVisit";
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectVisitDoctor")
	public ModelAndView selectVisitDoctor(@RequestParam Integer visit_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("visit/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteVisitDoctor")
	public ModelAndView deleteVisitDoctor(@RequestParam Integer visit_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitDoctor(visit_id, related_doctor_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */
	@RequestMapping("/newVisitReceptionist")
	public ModelAndView newVisitReceptionist(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("receptionist", new Receptionist());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Select an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectVisit")
	public ModelAndView selectVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Select the child Receptionist entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitReceptionist")
	public ModelAndView confirmDeleteVisitReceptionist(@RequestParam Integer visit_id, @RequestParam Integer related_receptionist_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("receptionist", receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/receptionist/deleteReceptionist.jsp");

		return mav;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/saveVisitPatientCard")
	public ModelAndView saveVisitPatientCard(@RequestParam Integer visit_id, @ModelAttribute PatientCard patientcard) {
		Visit parent_visit = visitService.saveVisitPatientCard(visit_id, patientcard);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteVisit")
	public String deleteVisit(@RequestParam Integer idKey) {
		Visit visit = visitDAO.findVisitByPrimaryKey(idKey);
		visitService.deleteVisit(visit);
		return "forward:/indexVisit";
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/saveVisitReceptionist")
	public ModelAndView saveVisitReceptionist(@RequestParam Integer visit_id, @ModelAttribute Receptionist receptionist) {
		Visit parent_visit = visitService.saveVisitReceptionist(visit_id, receptionist);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping("/newVisitPatientCard")
	public ModelAndView newVisitPatientCard(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("patientcard", new PatientCard());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/patientcard/editPatientCard.jsp");

		return mav;
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/selectVisitPatientCard")
	public ModelAndView selectVisitPatientCard(@RequestParam Integer visit_id, @RequestParam Integer patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("visit/patientcard/viewPatientCard.jsp");

		return mav;
	}

	/**
	 * Show all PatientCard entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitPatientCard")
	public ModelAndView listVisitPatientCard(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/patientcard/listPatientCard.jsp");

		return mav;
	}

	/**
	 * Show all Visit entities
	 * 
	 */
	@RequestMapping("/indexVisit")
	public ModelAndView listVisits() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visits", visitService.loadVisits());

		mav.setViewName("visit/listVisits.jsp");

		return mav;
	}

	/**
	 * Select the child PatientCard entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitPatientCard")
	public ModelAndView confirmDeleteVisitPatientCard(@RequestParam Integer visit_id, @RequestParam Integer related_patientcard_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(related_patientcard_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/patientcard/deletePatientCard.jsp");

		return mav;
	}

	/**
	 * Create a new TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/newVisitTypeOfVisit")
	public ModelAndView newVisitTypeOfVisit(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("typeofvisit", new TypeOfVisit());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/typeofvisit/editTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/selectVisitReceptionist")
	public ModelAndView selectVisitReceptionist(@RequestParam Integer visit_id, @RequestParam Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("visit/receptionist/viewReceptionist.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitDoctor")
	public ModelAndView confirmDeleteVisitDoctor(@RequestParam Integer visit_id, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveVisit")
	public String saveVisit(@ModelAttribute Visit visit) {
		visitService.saveVisit(visit);
		return "forward:/indexVisit";
	}

	/**
	 * Edit an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/editVisitPatientCard")
	public ModelAndView editVisitPatientCard(@RequestParam Integer visit_id, @RequestParam Integer patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("visit/patientcard/editPatientCard.jsp");

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
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newVisit")
	public ModelAndView newVisit() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/editVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/deleteVisitReceptionist")
	public ModelAndView deleteVisitReceptionist(@RequestParam Integer visit_id, @RequestParam Integer related_receptionist_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitReceptionist(visit_id, related_receptionist_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/editVisitTypeOfVisit")
	public ModelAndView editVisitTypeOfVisit(@RequestParam Integer visit_id, @RequestParam Integer typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("typeofvisit", typeofvisit);
		mav.setViewName("visit/typeofvisit/editTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/deleteVisitSickLeaves")
	public ModelAndView deleteVisitSickLeaves(@RequestParam Integer visit_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitSickLeaves(visit_id, related_sickleaves_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Create a new StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/newVisitStatusOfVisit")
	public ModelAndView newVisitStatusOfVisit(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("statusofvisit", new StatusOfVisit());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/statusofvisit/editStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/editVisitStatusOfVisit")
	public ModelAndView editVisitStatusOfVisit(@RequestParam Integer visit_id, @RequestParam Integer statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("statusofvisit", statusofvisit);
		mav.setViewName("visit/statusofvisit/editStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Delete an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/deleteVisitTypeOfVisit")
	public ModelAndView deleteVisitTypeOfVisit(@RequestParam Integer visit_id, @RequestParam Integer related_typeofvisit_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitTypeOfVisit(visit_id, related_typeofvisit_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Select the child SickLeave entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitSickLeaves")
	public ModelAndView confirmDeleteVisitSickLeaves(@RequestParam Integer visit_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/sickleaves/deleteSickLeaves.jsp");

		return mav;
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/selectVisitSickLeaves")
	public ModelAndView selectVisitSickLeaves(@RequestParam Integer visit_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("visit/sickleaves/viewSickLeaves.jsp");

		return mav;
	}

	/**
	 * Select the Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisit")
	public ModelAndView confirmDeleteVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/deleteVisit.jsp");

		return mav;
	}

	/**
	 * Show all StatusOfVisit entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitStatusOfVisit")
	public ModelAndView listVisitStatusOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/statusofvisit/listStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping("/newVisitSickLeaves")
	public ModelAndView newVisitSickLeaves(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("sickleave", new SickLeave());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 * View an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/selectVisitStatusOfVisit")
	public ModelAndView selectVisitStatusOfVisit(@RequestParam Integer visit_id, @RequestParam Integer statusofvisit_id) {
		StatusOfVisit statusofvisit = statusOfVisitDAO.findStatusOfVisitByPrimaryKey(statusofvisit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("statusofvisit", statusofvisit);
		mav.setViewName("visit/statusofvisit/viewStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * Select the child StatusOfVisit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitStatusOfVisit")
	public ModelAndView confirmDeleteVisitStatusOfVisit(@RequestParam Integer visit_id, @RequestParam Integer related_statusofvisit_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusofvisit", statusOfVisitDAO.findStatusOfVisitByPrimaryKey(related_statusofvisit_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/statusofvisit/deleteStatusOfVisit.jsp");

		return mav;
	}

	/**
	 * View an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/selectVisitTypeOfVisit")
	public ModelAndView selectVisitTypeOfVisit(@RequestParam Integer visit_id, @RequestParam Integer typeofvisit_id) {
		TypeOfVisit typeofvisit = typeOfVisitDAO.findTypeOfVisitByPrimaryKey(typeofvisit_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("typeofvisit", typeofvisit);
		mav.setViewName("visit/typeofvisit/viewTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/editVisitSickLeaves")
	public ModelAndView editVisitSickLeaves(@RequestParam Integer visit_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("visit/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveVisitDoctor")
	public ModelAndView saveVisitDoctor(@RequestParam Integer visit_id, @ModelAttribute Doctor doctor) {
		Visit parent_visit = visitService.saveVisitDoctor(visit_id, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/saveVisitSickLeaves")
	public ModelAndView saveVisitSickLeaves(@RequestParam Integer visit_id, @ModelAttribute SickLeave sickleaves) {
		Visit parent_visit = visitService.saveVisitSickLeaves(visit_id, sickleaves);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Show all SickLeave entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitSickLeaves")
	public ModelAndView listVisitSickLeaves(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/sickleaves/listSickLeaves.jsp");

		return mav;
	}

	/**
	 * Show all TypeOfVisit entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitTypeOfVisit")
	public ModelAndView listVisitTypeOfVisit(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/typeofvisit/listTypeOfVisit.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/visitController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editVisitDoctor")
	public ModelAndView editVisitDoctor(@RequestParam Integer visit_id, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("visit/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Select the child TypeOfVisit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteVisitTypeOfVisit")
	public ModelAndView confirmDeleteVisitTypeOfVisit(@RequestParam Integer visit_id, @RequestParam Integer related_typeofvisit_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("typeofvisit", typeOfVisitDAO.findTypeOfVisitByPrimaryKey(related_typeofvisit_id));
		mav.addObject("visit_id", visit_id);
		mav.setViewName("visit/typeofvisit/deleteTypeOfVisit.jsp");

		return mav;
	}

	/**
	 * Save an existing TypeOfVisit entity
	 * 
	 */
	@RequestMapping("/saveVisitTypeOfVisit")
	public ModelAndView saveVisitTypeOfVisit(@RequestParam Integer visit_id, @ModelAttribute TypeOfVisit typeofvisit) {
		Visit parent_visit = visitService.saveVisitTypeOfVisit(visit_id, typeofvisit);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Edit an existing Receptionist entity
	 * 
	 */
	@RequestMapping("/editVisitReceptionist")
	public ModelAndView editVisitReceptionist(@RequestParam Integer visit_id, @RequestParam Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("receptionist", receptionist);
		mav.setViewName("visit/receptionist/editReceptionist.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by Visit
	 * 
	 */
	@RequestMapping("/listVisitDoctor")
	public ModelAndView listVisitDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(idKey));
		mav.setViewName("visit/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newVisitDoctor")
	public ModelAndView newVisitDoctor(@RequestParam Integer visit_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("visit/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/deleteVisitStatusOfVisit")
	public ModelAndView deleteVisitStatusOfVisit(@RequestParam Integer visit_id, @RequestParam Integer related_statusofvisit_id) {
		ModelAndView mav = new ModelAndView();

		Visit visit = visitService.deleteVisitStatusOfVisit(visit_id, related_statusofvisit_id);

		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}

	/**
	 * Save an existing StatusOfVisit entity
	 * 
	 */
	@RequestMapping("/saveVisitStatusOfVisit")
	public ModelAndView saveVisitStatusOfVisit(@RequestParam Integer visit_id, @ModelAttribute StatusOfVisit statusofvisit) {
		Visit parent_visit = visitService.saveVisitStatusOfVisit(visit_id, statusofvisit);

		ModelAndView mav = new ModelAndView();
		mav.addObject("visit_id", visit_id);
		mav.addObject("visit", parent_visit);
		mav.setViewName("visit/viewVisit.jsp");

		return mav;
	}
}