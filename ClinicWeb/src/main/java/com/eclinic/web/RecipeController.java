package com.eclinic.web;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;

import com.eclinic.service.RecipeService;

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
 * Spring MVC controller that handles CRUD requests for Recipe entities
 * 
 */

@Controller("RecipeController")
public class RecipeController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

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
	 * Service injected by Spring that provides CRUD operations for Recipe entities
	 * 
	 */
	@Autowired
	private RecipeService recipeService;

	/**
	 * Edit an existing Doctor entity
	 * 
	 */
	@RequestMapping("/editRecipeDoctor")
	public ModelAndView editRecipeDoctor(@RequestParam Integer recipe_idr, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("doctor", doctor);
		mav.setViewName("recipe/doctor/editDoctor.jsp");

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
	 * Delete an existing Recipe entity
	 * 
	 */
	@RequestMapping("/deleteRecipe")
	public String deleteRecipe(@RequestParam Integer idrKey) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(idrKey);
		recipeService.deleteRecipe(recipe);
		return "forward:/indexRecipe";
	}

	/**
	 * Select the Recipe entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecipe")
	public ModelAndView confirmDeleteRecipe(@RequestParam Integer idrKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(idrKey));
		mav.setViewName("recipe/deleteRecipe.jsp");

		return mav;
	}

	/**
	 * Show all Patient entities by Recipe
	 * 
	 */
	@RequestMapping("/listRecipePatient")
	public ModelAndView listRecipePatient(@RequestParam Integer idrKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(idrKey));
		mav.setViewName("recipe/patient/listPatient.jsp");

		return mav;
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@RequestMapping("/deleteRecipeDoctor")
	public ModelAndView deleteRecipeDoctor(@RequestParam Integer recipe_idr, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		Recipe recipe = recipeService.deleteRecipeDoctor(recipe_idr, related_doctor_id);

		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("recipe", recipe);
		mav.setViewName("recipe/viewRecipe.jsp");

		return mav;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/saveRecipePatient")
	public ModelAndView saveRecipePatient(@RequestParam Integer recipe_idr, @ModelAttribute Patient patient) {
		Recipe parent_recipe = recipeService.saveRecipePatient(recipe_idr, patient);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("recipe", parent_recipe);
		mav.setViewName("recipe/viewRecipe.jsp");

		return mav;
	}

	/**
	 * Show all Recipe entities
	 * 
	 */
	@RequestMapping("/indexRecipe")
	public ModelAndView listRecipes() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipes", recipeService.loadRecipes());

		mav.setViewName("recipe/listRecipes.jsp");

		return mav;
	}

	/**
	 * Show all Doctor entities by Recipe
	 * 
	 */
	@RequestMapping("/listRecipeDoctor")
	public ModelAndView listRecipeDoctor(@RequestParam Integer idrKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(idrKey));
		mav.setViewName("recipe/doctor/listDoctor.jsp");

		return mav;
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectRecipePatient")
	public ModelAndView selectRecipePatient(@RequestParam Integer recipe_idr, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("patient", patient);
		mav.setViewName("recipe/patient/viewPatient.jsp");

		return mav;
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */
	@RequestMapping("/newRecipe")
	public ModelAndView newRecipe() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", new Recipe());
		mav.addObject("newFlag", true);
		mav.setViewName("recipe/editRecipe.jsp");

		return mav;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deleteRecipePatient")
	public ModelAndView deleteRecipePatient(@RequestParam Integer recipe_idr, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		Recipe recipe = recipeService.deleteRecipePatient(recipe_idr, related_patient_id);

		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("recipe", recipe);
		mav.setViewName("recipe/viewRecipe.jsp");

		return mav;
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	@RequestMapping("/selectRecipeDoctor")
	public ModelAndView selectRecipeDoctor(@RequestParam Integer recipe_idr, @RequestParam Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("doctor", doctor);
		mav.setViewName("recipe/doctor/viewDoctor.jsp");

		return mav;
	}

	/**
	 * Select the child Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecipePatient")
	public ModelAndView confirmDeleteRecipePatient(@RequestParam Integer recipe_idr, @RequestParam Integer related_patient_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(related_patient_id));
		mav.addObject("recipe_idr", recipe_idr);
		mav.setViewName("recipe/patient/deletePatient.jsp");

		return mav;
	}

	/**
	 * Select an existing Recipe entity
	 * 
	 */
	@RequestMapping("/selectRecipe")
	public ModelAndView selectRecipe(@RequestParam Integer idrKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(idrKey));
		mav.setViewName("recipe/viewRecipe.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editRecipePatient")
	public ModelAndView editRecipePatient(@RequestParam Integer recipe_idr, @RequestParam Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("patient", patient);
		mav.setViewName("recipe/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Recipe entities
	 * 
	 */
	public String indexRecipe() {
		return "redirect:/indexRecipe";
	}

	/**
	 */
	@RequestMapping("/recipeController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Recipe entity
	 * 
	 */
	@RequestMapping("/editRecipe")
	public ModelAndView editRecipe(@RequestParam Integer idrKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("recipe", recipeDAO.findRecipeByPrimaryKey(idrKey));
		mav.setViewName("recipe/editRecipe.jsp");

		return mav;
	}

	/**
	 * Select the child Doctor entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRecipeDoctor")
	public ModelAndView confirmDeleteRecipeDoctor(@RequestParam Integer recipe_idr, @RequestParam Integer related_doctor_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("doctor", doctorDAO.findDoctorByPrimaryKey(related_doctor_id));
		mav.addObject("recipe_idr", recipe_idr);
		mav.setViewName("recipe/doctor/deleteDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */
	@RequestMapping("/newRecipeDoctor")
	public ModelAndView newRecipeDoctor(@RequestParam Integer recipe_idr) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("doctor", new Doctor());
		mav.addObject("newFlag", true);
		mav.setViewName("recipe/doctor/editDoctor.jsp");

		return mav;
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newRecipePatient")
	public ModelAndView newRecipePatient(@RequestParam Integer recipe_idr) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("recipe/patient/editPatient.jsp");

		return mav;
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@RequestMapping("/saveRecipeDoctor")
	public ModelAndView saveRecipeDoctor(@RequestParam Integer recipe_idr, @ModelAttribute Doctor doctor) {
		Recipe parent_recipe = recipeService.saveRecipeDoctor(recipe_idr, doctor);

		ModelAndView mav = new ModelAndView();
		mav.addObject("recipe_idr", recipe_idr);
		mav.addObject("recipe", parent_recipe);
		mav.setViewName("recipe/viewRecipe.jsp");

		return mav;
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@RequestMapping("/saveRecipe")
	public String saveRecipe(@ModelAttribute Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return "forward:/indexRecipe";
	}
}