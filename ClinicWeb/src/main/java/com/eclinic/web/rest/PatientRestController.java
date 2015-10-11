package com.eclinic.web.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * Spring Rest controller that handles CRUD requests for Patient entities
 * 
 */
@Path("/Patient")
@Component("PatientRestController")
public class PatientRestController {

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

	public PatientRestController() {
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
	 * Save an existing Recipe entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/recipes")
	@PUT
	public Response savePatientRecipes(@PathParam("patient_id") Integer patient_id,
			Recipe recipes) {
		patientService.savePatientRecipes(patient_id, recipes);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipes.getIdr())).build();
	}

	/**
	 * Show all SickLeave entities by Patient
	 * 
	 */
	
	
	@GET
	@Path("/{patient_id}/sickLeaves")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientSickLeaves(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id).getSickLeaves()).build();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/sickLeaves/{sickleave_id}")
	public Response deletePatientSickLeaves(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		return Response.ok(patientService.deletePatientSickLeaves(patient_id, related_sickleaves_id)).build();
	}

	/**
	 * Create a new Address entity
	 * 
	 */

	
	@Path("/{patient_id}/address")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientAddress(@PathParam("patient_id") Integer patient_id,
			Address address) {
		patientService.savePatientAddress(patient_id, address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(address.getId())).build();
	}

	/**
	 * Select an existing Patient entity
	 * 
	 */

	
	@GET
	@Path("/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatient(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id)).build();
	}


	/**
	 * Show all Worker entities by Patient
	 * 
	 */

	
	@GET
	@Path("/{patient_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientWorkers(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id).getWorkers()).build();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/sickLeaves")
	@PUT
	public Response savePatientSickLeaves(@PathParam("patient_id") Integer patient_id,
			SickLeave sickleaves) {
		patientService.savePatientSickLeaves(patient_id, sickleaves);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId())).build();
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */

	
	@GET
	@Path("/{doctor_id}/patientCards/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientPatientCards(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);
		return Response.ok(patientcard).build();
	}

	/**
	 * Show all Patient entities
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPatients() {
//		ObjectMapper mapper = new ObjectMapper();
		try {
			 return  Response.ok( new ObjectMapper().writeValueAsString(patientService.loadPatients())).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */

	
	@GET
	@Path("/{patient_id}/sickLeaves/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientSickLeaves(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);
		return Response.ok(sickleave).build();
	}

	/**
	 * Create a new Recipe entity
	 * 
	 */

	
	@Path("/{patient_id}/recipes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientRecipes(@PathParam("patient_id") Integer patient_id,
			Recipe recipe) {
		patientService.savePatientRecipes(patient_id, recipe);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe.getIdr())).build();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	
	

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}")
	@DELETE
	public void deletePatient(@PathParam("patient_id") Integer patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patient_id);
		patientService.deletePatient(patient);
	}

	/**
	 * View an existing Worker entity
	 * 
	 */

	
	@GET
	@Path("/{patient_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientWorkers(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return Response.ok(worker).build();
	}

	/**
	 * View an existing Address entity
	 * 
	 */

	
	@GET
	@Path("/{patient_id}/address/{address_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientAddress(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_address_id") Integer related_address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(related_address_id, -1, -1);

		return Response.ok(address).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */


	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/workers")
	@PUT
	public Response savePatientWorkers(@PathParam("patient_id") Integer patient_id,
			Worker workers) {
		patientService.savePatientWorkers(patient_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}
	/**
	 * Create a new PatientCard entity
	 * 
	 */

	
	@Path("/{patient_id}/patientCards")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientPatientCards(@PathParam("patient_id") Integer patient_id,
			PatientCard patientcard) {
		patientService.savePatientPatientCards(patient_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}


	/**
	 * Create a new Worker entity
	 * 
	 */

	
	@Path("/{patient_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientPatientCards(@PathParam("patient_id") Integer patient_id,
			Worker worker) {
		patientService.savePatientWorkers(patient_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */

	
	@Path("/{patient_id}/sickLeaves")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientSickLeaves(@PathParam("patient_id") Integer patient_id,
			SickLeave sickleave) {
		patientService.savePatientSickLeaves(patient_id, sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/recipes/{recipe_idr}")
	public Response deletePatientRecipes(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		return Response.ok(patientService.deletePatientRecipes(patient_id, related_recipes_idr)).build();
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */

	@GET
	@Path("/{patient_id}/recipes/{recipe_idr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientRecipes(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		return Response.ok(recipe).build();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePatient(Patient patient) {
		patientService.savePatient(patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}


	/**
	 * Show all Recipe entities by Patient
	 * 
	 */
	
	

	@GET
	@Path("/{patient_id}/recipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientRecipes(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id).getRecipes()).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/workers/{worker_id}")
	public Response deletePatientWorkers(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(patientService.deletePatientWorkers(patient_id, related_workers_id)).build();
	}

	/**
	 * Show all PatientCard entities by Patient
	 * 
	 */
	
	
	@GET
	@Path("/{patient_id}/patientCards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientPatientCards(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id).getPatientCards()).build();
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/patientCards")
	@PUT
	public Response savePatientWorkers(@PathParam("patient_id") Integer patient_id,
			PatientCard patientcards) {
		patientService.savePatientPatientCards(patient_id, patientcards);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcards.getId())).build();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/patientCards/{patientcard_id}")
	public Response deletePatientPatientCards(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		return Response.ok(patientService.deletePatientPatientCards(patient_id, related_patientcards_id)).build();
	}


	/**
	 * Delete an existing Address entity
	 * 
	 */
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/address/{address_id}")
	public Response deletePatientAddress(@PathParam("patient_id") Integer patient_id,
			@PathParam("related_address_id") Integer related_address_id) {
		return Response.ok(		patientService.deletePatientAddress(patient_id, related_address_id)).build();
	}


	/**
	 * Get Address entity by Patient
	 * 
	 */


	@GET
	@Path("/{patient_id}/address")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientAddress(@PathParam("patient_id") Integer patient_id) {
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient_id).getAddress()).build();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatient(Patient patient) {
		patientService.savePatient(patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/address")
	@PUT
	public Response savePatientAddress(@PathParam("patient_id") Integer patient_id,
			Address address) {
		patientService.savePatientAddress(patient_id, address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(address.getId())).build();
	}


	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}/address")
	@PUT
	public Response confirmedPatient(@PathParam("id") Integer id) {
		Patient p  = patientDAO.findPatientByPrimaryKey(id);
		p.setConfirmed(1);
		patientService.savePatient(p);
		Map<String, String> map = new HashMap<String,String>();
		return Response.ok(map.put("status","zmieniono")).build();
	}
}