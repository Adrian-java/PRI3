package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.Visit;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.domain.Worker;

import com.eclinic.service.DoctorService;

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
 * Spring MVC controller that handles CRUD requests for Doctor entities
 * 
 */

@Controller("DoctorController")
public class DoctorController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * DAO injected by Spring that manages PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardDAO patientCardDAO;

	/**
	 * DAO injected by Spring that manages Recipe entities
	 * 
	 */
	@Autowired
	private RecipeDAO recipeDAO;

	/**
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Doctor entities
	 * 
	 */
	@Autowired
	private DoctorService doctorService;

	/**
	 * Select the child Visit entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorVisits")
	public ModelAndView confirmDeleteDoctorVisits(@RequestParam Integer doctor_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visit", visitDAO.findVisitByPrimaryKey(related_visits_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/visits/deleteVisits.jsp");

		return mav;
	}

	/**
	 * Edit an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/editDoctorSickLeaves")
	public ModelAndView editDoctorSickLeaves(@RequestParam Integer doctor_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("doctor/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@RequestMapping("/saveDoctorRecipes")
	public ModelAndView saveDoctorRecipes(@RequestParam Integer doctor_id, @ModelAttribute Recipe recipes) {
		Doctor parent_doctor = doctorService.saveDoctorRecipes(doctor_id, recipes);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */
	@RequestMapping("/newDoctorRecipes")
	public ModelAndView newDoctorRecipes(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("recipe", new Recipe());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/recipes/editRecipes.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newDoctor")
	public ModelAndView newDoctor() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Select the Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctor")
	public ModelAndView confirmDeleteDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Visit entity
	 * 
	 */
	@RequestMapping("/editDoctorVisits")
	public ModelAndView editDoctorVisits(@RequestParam Integer doctor_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visit", visit);
		mav.setViewName("doctor/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/saveDoctorPatientCards")
	public ModelAndView saveDoctorPatientCards(@RequestParam Integer doctor_id, @ModelAttribute PatientCard patientcards) {
		Doctor parent_doctor = doctorService.saveDoctorPatientCards(doctor_id, patientcards);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Graphic entity
	 * 
	 */
	@RequestMapping("/editDoctorGraphics")
	public ModelAndView editDoctorGraphics(@RequestParam Integer doctor_id, @RequestParam Integer graphics_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphics_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("graphic", graphic);
		mav.setViewName("doctor/graphics/editGraphics.jsp");

		return mav;
	}

	/**
	 * Show all Worker entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorWorkers")
	public ModelAndView listDoctorWorkers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/workers/listWorkers.jsp");

		return mav;
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/selectDoctorPatientCards")
	public ModelAndView selectDoctorPatientCards(@RequestParam Integer doctor_id, @RequestParam Integer patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcards_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("doctor/patientcards/viewPatientCards.jsp");

		return mav;
	}

	/**
	 * Select the child Graphic entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorGraphics")
	public ModelAndView confirmDeleteDoctorGraphics(@RequestParam Integer doctor_id, @RequestParam Integer related_graphics_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("graphic", graphicDAO.findGraphicByPrimaryKey(related_graphics_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/graphics/deleteGraphics.jsp");

		return mav;
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/deleteDoctorPatientCards")
	public ModelAndView deleteDoctorPatientCards(@RequestParam Integer doctor_id, @RequestParam Integer related_patientcards_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorPatientCards(doctor_id, related_patientcards_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Doctor entities
	 * 
	 */
	public String indexDoctor() {
		return "redirect:/indexDoctor";
	}

	/**
	 * Show all Recipe entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorRecipes")
	public ModelAndView listDoctorRecipes(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/recipes/listRecipes.jsp");

		return mav;
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	@RequestMapping("/deleteDoctorSpecializations")
	public ModelAndView deleteDoctorSpecializations(@RequestParam Integer doctor_id, @RequestParam Integer related_specializations_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorSpecializations(doctor_id, related_specializations_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/editDoctorVisitSchedulers")
	public ModelAndView editDoctorVisitSchedulers(@RequestParam Integer doctor_id, @RequestParam Integer visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("doctor/visitschedulers/editVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities
	 * 
	 */
	@RequestMapping("/indexDoctor")
	public ModelAndView listDoctors() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctors", doctorService.loadDoctors());

		mav.setViewName("doctor/listDoctors.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/doctorController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping("/newDoctorSickLeaves")
	public ModelAndView newDoctorSickLeaves(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("sickleave", new SickLeave());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deleteDoctorWorkers")
	public ModelAndView deleteDoctorWorkers(@RequestParam Integer doctor_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorWorkers(doctor_id, related_workers_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/saveDoctorVisitSchedulers")
	public ModelAndView saveDoctorVisitSchedulers(@RequestParam Integer doctor_id, @ModelAttribute VisitScheduler visitschedulers) {
		Doctor parent_doctor = doctorService.saveDoctorVisitSchedulers(doctor_id, visitschedulers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editDoctor")
	public ModelAndView editDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	@RequestMapping("/deleteDoctorVisits")
	public ModelAndView deleteDoctorVisits(@RequestParam Integer doctor_id, @RequestParam Integer related_visits_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorVisits(doctor_id, related_visits_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteDoctor")
	public String deleteDoctor(@RequestParam Integer idKey) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(idKey);
		doctorService.deleteDoctor(doctor);
		return "forward:/indexDoctor";
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/saveDoctorSickLeaves")
	public ModelAndView saveDoctorSickLeaves(@RequestParam Integer doctor_id, @ModelAttribute SickLeave sickleaves) {
		Doctor parent_doctor = doctorService.saveDoctorSickLeaves(doctor_id, sickleaves);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@RequestMapping("/newDoctorVisitSchedulers")
	public ModelAndView newDoctorVisitSchedulers(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visitscheduler", new VisitScheduler());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/visitschedulers/editVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	@RequestMapping("/newDoctorVisits")
	public ModelAndView newDoctorVisits(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visit", new Visit());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/visits/editVisits.jsp");

		return mav;
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	@RequestMapping("/saveDoctorGraphics")
	public ModelAndView saveDoctorGraphics(@RequestParam Integer doctor_id, @ModelAttribute Graphic graphics) {
		Doctor parent_doctor = doctorService.saveDoctorGraphics(doctor_id, graphics);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Recipe entity
	 * 
	 */
	@RequestMapping("/editDoctorRecipes")
	public ModelAndView editDoctorRecipes(@RequestParam Integer doctor_id, @RequestParam Integer recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipes_idr, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("recipe", recipe);
		mav.setViewName("doctor/recipes/editRecipes.jsp");

		return mav;
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */
	@RequestMapping("/newDoctorSpecializations")
	public ModelAndView newDoctorSpecializations(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("specialization", new Specialization());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/specializations/editSpecializations.jsp");

		return mav;
	}

	/**
	 * Select the child Specialization entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorSpecializations")
	public ModelAndView confirmDeleteDoctorSpecializations(@RequestParam Integer doctor_id, @RequestParam Integer related_specializations_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("specialization", specializationDAO.findSpecializationByPrimaryKey(related_specializations_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/specializations/deleteSpecializations.jsp");

		return mav;
	}

	/**
	 * Show all Visit entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorVisits")
	public ModelAndView listDoctorVisits(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/visits/listVisits.jsp");

		return mav;
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/deleteDoctorVisitSchedulers")
	public ModelAndView deleteDoctorVisitSchedulers(@RequestParam Integer doctor_id, @RequestParam Integer related_visitschedulers_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorVisitSchedulers(doctor_id, related_visitschedulers_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Select the child SickLeave entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorSickLeaves")
	public ModelAndView confirmDeleteDoctorSickLeaves(@RequestParam Integer doctor_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/sickleaves/deleteSickLeaves.jsp");

		return mav;
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */
	@RequestMapping("/selectDoctorRecipes")
	public ModelAndView selectDoctorRecipes(@RequestParam Integer doctor_id, @RequestParam Integer recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipes_idr, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("recipe", recipe);
		mav.setViewName("doctor/recipes/viewRecipes.jsp");

		return mav;
	}

	/**
	 * Show all PatientCard entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorPatientCards")
	public ModelAndView listDoctorPatientCards(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/patientcards/listPatientCards.jsp");

		return mav;
	}

	/**
	 * Show all VisitScheduler entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorVisitSchedulers")
	public ModelAndView listDoctorVisitSchedulers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/visitschedulers/listVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/saveDoctorWorkers")
	public ModelAndView saveDoctorWorkers(@RequestParam Integer doctor_id, @ModelAttribute Worker workers) {
		Doctor parent_doctor = doctorService.saveDoctorWorkers(doctor_id, workers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	@RequestMapping("/saveDoctorSpecializations")
	public ModelAndView saveDoctorSpecializations(@RequestParam Integer doctor_id, @ModelAttribute Specialization specializations) {
		Doctor parent_doctor = doctorService.saveDoctorSpecializations(doctor_id, specializations);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	@RequestMapping("/selectDoctorVisits")
	public ModelAndView selectDoctorVisits(@RequestParam Integer doctor_id, @RequestParam Integer visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(visits_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visit", visit);
		mav.setViewName("doctor/visits/viewVisits.jsp");

		return mav;
	}

	/**
	 * Show all Graphic entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorGraphics")
	public ModelAndView listDoctorGraphics(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/graphics/listGraphics.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorWorkers")
	public ModelAndView confirmDeleteDoctorWorkers(@RequestParam Integer doctor_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_workers_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/workers/deleteWorkers.jsp");

		return mav;
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectDoctorWorkers")
	public ModelAndView selectDoctorWorkers(@RequestParam Integer doctor_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("worker", worker);
		mav.setViewName("doctor/workers/viewWorkers.jsp");

		return mav;
	}

	/**
	 * Edit an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/editDoctorPatientCards")
	public ModelAndView editDoctorPatientCards(@RequestParam Integer doctor_id, @RequestParam Integer patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcards_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("doctor/patientcards/editPatientCards.jsp");

		return mav;
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/deleteDoctorSickLeaves")
	public ModelAndView deleteDoctorSickLeaves(@RequestParam Integer doctor_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorSickLeaves(doctor_id, related_sickleaves_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newDoctorWorkers")
	public ModelAndView newDoctorWorkers(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */
	@RequestMapping("/saveDoctorVisits")
	public ModelAndView saveDoctorVisits(@RequestParam Integer doctor_id, @ModelAttribute Visit visits) {
		Doctor parent_doctor = doctorService.saveDoctorVisits(doctor_id, visits);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", parent_doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@RequestMapping("/selectDoctorSpecializations")
	public ModelAndView selectDoctorSpecializations(@RequestParam Integer doctor_id, @RequestParam Integer specializations_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specializations_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("doctor/specializations/viewSpecializations.jsp");

		return mav;
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */
	@RequestMapping("/selectDoctorVisitSchedulers")
	public ModelAndView selectDoctorVisitSchedulers(@RequestParam Integer doctor_id, @RequestParam Integer visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("visitscheduler", visitscheduler);
		mav.setViewName("doctor/visitschedulers/viewVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * View an existing Graphic entity
	 * 
	 */
	@RequestMapping("/selectDoctorGraphics")
	public ModelAndView selectDoctorGraphics(@RequestParam Integer doctor_id, @RequestParam Integer graphics_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphics_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("graphic", graphic);
		mav.setViewName("doctor/graphics/viewGraphics.jsp");

		return mav;
	}

	/**
	 * Show all SickLeave entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorSickLeaves")
	public ModelAndView listDoctorSickLeaves(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/sickleaves/listSickLeaves.jsp");

		return mav;
	}

	/**
	 * Select the child PatientCard entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorPatientCards")
	public ModelAndView confirmDeleteDoctorPatientCards(@RequestParam Integer doctor_id, @RequestParam Integer related_patientcards_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/patientcards/deletePatientCards.jsp");

		return mav;
	}

	/**
	 * Select an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectDoctor")
	public ModelAndView selectDoctor(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editDoctorWorkers")
	public ModelAndView editDoctorWorkers(@RequestParam Integer doctor_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("worker", worker);
		mav.setViewName("doctor/workers/editWorkers.jsp");

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
	 * Select the child VisitScheduler entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorVisitSchedulers")
	public ModelAndView confirmDeleteDoctorVisitSchedulers(@RequestParam Integer doctor_id, @RequestParam Integer related_visitschedulers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("visitscheduler", visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/visitschedulers/deleteVisitSchedulers.jsp");

		return mav;
	}

	/**
	 * Edit an existing Specialization entity
	 * 
	 */
	@RequestMapping("/editDoctorSpecializations")
	public ModelAndView editDoctorSpecializations(@RequestParam Integer doctor_id, @RequestParam Integer specializations_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specializations_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("specialization", specialization);
		mav.setViewName("doctor/specializations/editSpecializations.jsp");

		return mav;
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@RequestMapping("/deleteDoctorRecipes")
	public ModelAndView deleteDoctorRecipes(@RequestParam Integer doctor_id, @RequestParam Integer related_recipes_idr) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorRecipes(doctor_id, related_recipes_idr);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return "forward:/indexDoctor";
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping("/newDoctorPatientCards")
	public ModelAndView newDoctorPatientCards(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("patientcard", new PatientCard());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/patientcards/editPatientCards.jsp");

		return mav;
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/selectDoctorSickLeaves")
	public ModelAndView selectDoctorSickLeaves(@RequestParam Integer doctor_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("doctor/sickleaves/viewSickLeaves.jsp");

		return mav;
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	@RequestMapping("/deleteDoctorGraphics")
	public ModelAndView deleteDoctorGraphics(@RequestParam Integer doctor_id, @RequestParam Integer related_graphics_id) {
		ModelAndView mav = new ModelAndView();

		Doctor doctor = doctorService.deleteDoctorGraphics(doctor_id, related_graphics_id);

		mav.addObject("doctor_id", doctor_id);
		mav.addObject("doctor", doctor);
		mav.setViewName("doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Graphic entity
	 * 
	 */
	@RequestMapping("/newDoctorGraphics")
	public ModelAndView newDoctorGraphics(@RequestParam Integer doctor_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctor_id", doctor_id);
		mav.addObject("graphic", new Graphic());
		mav.addObject("newFlag", true);
		mav.setViewName("doctor/graphics/editGraphics.jsp");

		return mav;
	}

	/**
	 * Show all Specialization entities by Doctor
	 * 
	 */
	@RequestMapping("/listDoctorSpecializations")
	public ModelAndView listDoctorSpecializations(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(idKey));
		mav.setViewName("doctor/specializations/listSpecializations.jsp");

		return mav;
	}

	/**
	 * Select the child Recipe entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDoctorRecipes")
	public ModelAndView confirmDeleteDoctorRecipes(@RequestParam Integer doctor_id, @RequestParam Integer related_recipes_idr) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(related_recipes_idr));
		mav.addObject("doctor_id", doctor_id);
		mav.setViewName("doctor/recipes/deleteRecipes.jsp");

		return mav;
	}
}