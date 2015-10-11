package com.eclinic.web;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.WorkerDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Recipe;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Worker;

import com.eclinic.service.PatientService;

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
 * Spring MVC controller that handles CRUD requests for Patient entities
 * 
 */

@Controller("PatientController")
public class PatientController {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	@Autowired
	private AddressDAO addressDAO;

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
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Patient entities
	 * 
	 */
	@Autowired
	private PatientService patientService;

	/**
	 * View an existing Worker entity
	 * 
	 */
	@RequestMapping("/selectPatientWorkers")
	public ModelAndView selectPatientWorkers(@RequestParam Integer patient_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("worker", worker);
		mav.setViewName("patient/workers/viewWorkers.jsp");

		return mav;
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	@RequestMapping("/newPatientSickLeaves")
	public ModelAndView newPatientSickLeaves(@RequestParam Integer patient_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("sickleave", new SickLeave());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@RequestMapping("/deletePatientRecipes")
	public ModelAndView deletePatientRecipes(@RequestParam Integer patient_id, @RequestParam Integer related_recipes_idr) {
		ModelAndView mav = new ModelAndView();

		Patient patient = patientService.deletePatientRecipes(patient_id, related_recipes_idr);

		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Worker entity
	 * 
	 */
	@RequestMapping("/editPatientWorkers")
	public ModelAndView editPatientWorkers(@RequestParam Integer patient_id, @RequestParam Integer workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(workers_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("worker", worker);
		mav.setViewName("patient/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/savePatient")
	public String savePatient(@ModelAttribute Patient patient) {
		patientService.savePatient(patient);
		return "forward:/indexPatient";
	}

	/**
	 * Show all PatientCard entities by Patient
	 * 
	 */
	@RequestMapping("/listPatientPatientCards")
	public ModelAndView listPatientPatientCards(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/patientcards/listPatientCards.jsp");

		return mav;
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/selectPatientPatientCards")
	public ModelAndView selectPatientPatientCards(@RequestParam Integer patient_id, @RequestParam Integer patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcards_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("patient/patientcards/viewPatientCards.jsp");

		return mav;
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@RequestMapping("/savePatientRecipes")
	public ModelAndView savePatientRecipes(@RequestParam Integer patient_id, @ModelAttribute Recipe recipes) {
		Patient parent_patient = patientService.savePatientRecipes(patient_id, recipes);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", parent_patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@RequestMapping("/savePatientAddress")
	public ModelAndView savePatientAddress(@RequestParam Integer patient_id, @ModelAttribute Address address) {
		Patient parent_patient = patientService.savePatientAddress(patient_id, address);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", parent_patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * View an existing Address entity
	 * 
	 */
	@RequestMapping("/selectPatientAddress")
	public ModelAndView selectPatientAddress(@RequestParam Integer patient_id, @RequestParam Integer address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(address_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("address", address);
		mav.setViewName("patient/address/viewAddress.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editPatient")
	public ModelAndView editPatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Select the child SickLeave entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientSickLeaves")
	public ModelAndView confirmDeletePatientSickLeaves(@RequestParam Integer patient_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("sickleave", sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id));
		mav.addObject("patient_id", patient_id);
		mav.setViewName("patient/sickleaves/deleteSickLeaves.jsp");

		return mav;
	}

	/**
	 * Edit an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/editPatientSickLeaves")
	public ModelAndView editPatientSickLeaves(@RequestParam Integer patient_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("patient/sickleaves/editSickLeaves.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/patientController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
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
	 * Show all SickLeave entities by Patient
	 * 
	 */
	@RequestMapping("/listPatientSickLeaves")
	public ModelAndView listPatientSickLeaves(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/sickleaves/listSickLeaves.jsp");

		return mav;
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	@RequestMapping("/newPatientPatientCards")
	public ModelAndView newPatientPatientCards(@RequestParam Integer patient_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patientcard", new PatientCard());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/patientcards/editPatientCards.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Patient entities
	 * 
	 */
	public String indexPatient() {
		return "redirect:/indexPatient";
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/savePatientSickLeaves")
	public ModelAndView savePatientSickLeaves(@RequestParam Integer patient_id, @ModelAttribute SickLeave sickleaves) {
		Patient parent_patient = patientService.savePatientSickLeaves(patient_id, sickleaves);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", parent_patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Recipe entity
	 * 
	 */
	@RequestMapping("/editPatientRecipes")
	public ModelAndView editPatientRecipes(@RequestParam Integer patient_id, @RequestParam Integer recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipes_idr, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("recipe", recipe);
		mav.setViewName("patient/recipes/editRecipes.jsp");

		return mav;
	}

	/**
	 * Edit an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/editPatientPatientCards")
	public ModelAndView editPatientPatientCards(@RequestParam Integer patient_id, @RequestParam Integer patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcards_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patientcard", patientcard);
		mav.setViewName("patient/patientcards/editPatientCards.jsp");

		return mav;
	}

	/**
	 * Show all Patient entities
	 * 
	 */
	@RequestMapping("/indexPatient")
	public ModelAndView listPatients() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patients", patientService.loadPatients());

		mav.setViewName("patient/listPatients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Address entity
	 * 
	 */
	@RequestMapping("/editPatientAddress")
	public ModelAndView editPatientAddress(@RequestParam Integer patient_id, @RequestParam Integer address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(address_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("address", address);
		mav.setViewName("patient/address/editAddress.jsp");

		return mav;
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@RequestMapping("/deletePatientAddress")
	public ModelAndView deletePatientAddress(@RequestParam Integer patient_id, @RequestParam Integer related_address_id) {
		ModelAndView mav = new ModelAndView();

		Patient patient = patientService.deletePatientAddress(patient_id, related_address_id);

		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/savePatientPatientCards")
	public ModelAndView savePatientPatientCards(@RequestParam Integer patient_id, @ModelAttribute PatientCard patientcards) {
		Patient parent_patient = patientService.savePatientPatientCards(patient_id, patientcards);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", parent_patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Select the child Recipe entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientRecipes")
	public ModelAndView confirmDeletePatientRecipes(@RequestParam Integer patient_id, @RequestParam Integer related_recipes_idr) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(related_recipes_idr));
		mav.addObject("patient_id", patient_id);
		mav.setViewName("patient/recipes/deleteRecipes.jsp");

		return mav;
	}

	/**
	 * Create a new Address entity
	 * 
	 */
	@RequestMapping("/newPatientAddress")
	public ModelAndView newPatientAddress(@RequestParam Integer patient_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("address", new Address());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/address/editAddress.jsp");

		return mav;
	}

	/**
	 * Show all Recipe entities by Patient
	 * 
	 */
	@RequestMapping("/listPatientRecipes")
	public ModelAndView listPatientRecipes(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/recipes/listRecipes.jsp");

		return mav;
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	@RequestMapping("/newPatientWorkers")
	public ModelAndView newPatientWorkers(@RequestParam Integer patient_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("worker", new Worker());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/workers/editWorkers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	@RequestMapping("/deletePatientWorkers")
	public ModelAndView deletePatientWorkers(@RequestParam Integer patient_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		Patient patient = patientService.deletePatientWorkers(patient_id, related_workers_id);

		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@RequestMapping("/savePatientWorkers")
	public ModelAndView savePatientWorkers(@RequestParam Integer patient_id, @ModelAttribute Worker workers) {
		Patient parent_patient = patientService.savePatientWorkers(patient_id, workers);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", parent_patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */
	@RequestMapping("/newPatientRecipes")
	public ModelAndView newPatientRecipes(@RequestParam Integer patient_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("recipe", new Recipe());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/recipes/editRecipes.jsp");

		return mav;
	}

	/**
	 * Select an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectPatient")
	public ModelAndView selectPatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Select the child Worker entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientWorkers")
	public ModelAndView confirmDeletePatientWorkers(@RequestParam Integer patient_id, @RequestParam Integer related_workers_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("worker", workerDAO.findWorkerByPrimaryKey(related_workers_id));
		mav.addObject("patient_id", patient_id);
		mav.setViewName("patient/workers/deleteWorkers.jsp");

		return mav;
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */
	@RequestMapping("/selectPatientRecipes")
	public ModelAndView selectPatientRecipes(@RequestParam Integer patient_id, @RequestParam Integer recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipes_idr, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("recipe", recipe);
		mav.setViewName("patient/recipes/viewRecipes.jsp");

		return mav;
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/selectPatientSickLeaves")
	public ModelAndView selectPatientSickLeaves(@RequestParam Integer patient_id, @RequestParam Integer sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient_id", patient_id);
		mav.addObject("sickleave", sickleave);
		mav.setViewName("patient/sickleaves/viewSickLeaves.jsp");

		return mav;
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	@RequestMapping("/deletePatientPatientCards")
	public ModelAndView deletePatientPatientCards(@RequestParam Integer patient_id, @RequestParam Integer related_patientcards_id) {
		ModelAndView mav = new ModelAndView();

		Patient patient = patientService.deletePatientPatientCards(patient_id, related_patientcards_id);

		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */
	@RequestMapping("/deletePatientSickLeaves")
	public ModelAndView deletePatientSickLeaves(@RequestParam Integer patient_id, @RequestParam Integer related_sickleaves_id) {
		ModelAndView mav = new ModelAndView();

		Patient patient = patientService.deletePatientSickLeaves(patient_id, related_sickleaves_id);

		mav.addObject("patient_id", patient_id);
		mav.addObject("patient", patient);
		mav.setViewName("patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Select the Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatient")
	public ModelAndView confirmDeletePatient(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/deletePatient.jsp");

		return mav;
	}

	/**
	 * Select the child PatientCard entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientPatientCards")
	public ModelAndView confirmDeletePatientPatientCards(@RequestParam Integer patient_id, @RequestParam Integer related_patientcards_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patientcard", patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id));
		mav.addObject("patient_id", patient_id);
		mav.setViewName("patient/patientcards/deletePatientCards.jsp");

		return mav;
	}

	/**
	 * Show all Address entities by Patient
	 * 
	 */
	@RequestMapping("/listPatientAddress")
	public ModelAndView listPatientAddress(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/address/listAddress.jsp");

		return mav;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deletePatient")
	public String deletePatient(@RequestParam Integer idKey) {
		Patient patient = patientDAO.findPatientByPrimaryKey(idKey);
		patientService.deletePatient(patient);
		return "forward:/indexPatient";
	}

	/**
	 * Show all Worker entities by Patient
	 * 
	 */
	@RequestMapping("/listPatientWorkers")
	public ModelAndView listPatientWorkers(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(idKey));
		mav.setViewName("patient/workers/listWorkers.jsp");

		return mav;
	}

	/**
	 * Select the child Address entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePatientAddress")
	public ModelAndView confirmDeletePatientAddress(@RequestParam Integer patient_id, @RequestParam Integer related_address_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", addressDAO.findAddressByPrimaryKey(related_address_id));
		mav.addObject("patient_id", patient_id);
		mav.setViewName("patient/address/deleteAddress.jsp");

		return mav;
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newPatient")
	public ModelAndView newPatient() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("patient/editPatient.jsp");

		return mav;
	}
}