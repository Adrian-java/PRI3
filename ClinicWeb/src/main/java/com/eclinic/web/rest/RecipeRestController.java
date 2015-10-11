package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;
import com.eclinic.service.RecipeService;




import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * Spring Rest controller that handles CRUD requests for Recipe entities
 * 
 */
@Path("/Recipe")
@Component("RecipeRestController")
public class RecipeRestController {

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

	public RecipeRestController() {
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
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{recipe_idr}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadRecipeDoctor(@PathParam("recipe_idr") Integer recipe_idr,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);
		return Response.ok(doctor).build();
	}

	/**
	 * Get Patient entity by Recipe
	 * 
	 */

	
	@GET
	@Path("/{recipe_idr}/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecipePatient(@PathParam("recipe_idr") Integer recipe_idr) {
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe_idr).getPatient()).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */


	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{recipe_idr}/doctor/{doctor_id}")
	public Response deleteRecipeDoctor(@PathParam("recipe_idr") Integer recipe_idr,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(recipeService.deleteRecipeDoctor(recipe_idr, related_doctor_id)).build();
	}
	
	
	/**
	 * Delete an existing Patient entity
	 * 
	 */
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{recipe_idr}/patient/{patient_id}")
	public Response deleteRecipePatient(@PathParam("recipe_idr") Integer recipe_idr,
			@PathParam("related_patient_id") Integer related_patient_id) {
		return Response.ok(recipeService.deleteRecipePatient(recipe_idr, related_patient_id)).build();
	}

	/**
	 * View an existing Patient entity
	 * 
	 */

	@GET
	@Path("/{recipe_idr}/patient/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadRecipePatient(@PathParam("recipe_idr") Integer recipe_idr,
			@PathParam("related_patient_id") Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return Response.ok(patient).build();
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */


	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{recipe_idr}")
	@DELETE
	public void deleteRecipe(@PathParam("recipe_idr") Integer recipe_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipe_idr);
		recipeService.deleteRecipe(recipe);
	}
	/**
	 * Create a new Patient entity
	 * 
	 */

	@Path("/{recipe_idr}/patient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newRecipePatient(@PathParam("recipe_idr") Integer recipe_idr,
			 Patient patient) {
		recipeService.saveRecipePatient(recipe_idr, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}
	

	/**
	 * Create a new Doctor entity
	 * 
	 */

	
	
	@Path("/{recipe_idr}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newRecipeDoctor(@PathParam("recipe_idr") Integer recipe_idr,
			Doctor doctor) {
		recipeService.saveRecipeDoctor(recipe_idr, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	

	/**
	 * Create a new Recipe entity
	 * 
	 */

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newRecipe( Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe.getIdr())).build();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{recipe_idr}/patient")
	@PUT
	public Response saveRecipePatient(@PathParam("recipe_idr") Integer recipe_idr,
			Patient patient) {
		recipeService.saveRecipePatient(recipe_idr, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}
	
	

	/**
	 * Show all Recipe entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listRecipes() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(recipeService.loadRecipes())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{recipe_idr}/doctor")
	@PUT
	public Response saveRecipeDoctor(@PathParam("recipe_idr") Integer recipe_idr,
			Doctor doctor) {
		recipeService.saveRecipeDoctor(recipe_idr, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */


	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRecipe(Recipe recipe) {
		recipeService.saveRecipe(recipe);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe.getIdr())).build();
	}
	/**
	 * Select an existing Recipe entity
	 * 
	 */

	@GET
	@Path("/{recipe_idr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadRecipe(@PathParam("recipe_idr") Integer recipe_idr) {
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe_idr)).build();
	}

	/**
	 * Get Doctor entity by Recipe
	 * 
	 */

	
	@GET
	@Path("/{recipe_idr}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRecipeDoctor(@PathParam("recipe_idr") Integer recipe_idr) {
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe_idr).getDoctor()).build();
	}
}