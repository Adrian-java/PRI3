package com.eclinic.web.rest;

import java.io.IOException;

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
 * Spring Rest controller that handles CRUD requests for Doctor entities
 * 
 */


@Path("/Doctor")
@Component("DoctorRestController")
public class DoctorRestController {

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

	
	public DoctorRestController() {
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
	 * Create a new Graphic entity
	 * 
	 */
	@Path("/{doctor_id}/graphics")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			Graphic graphic) {
		doctorService.saveDoctorGraphics(doctor_id, graphic);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic.getId())).build();
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */
	@Path("/{doctor_id}/visitSchedulers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			VisitScheduler visitScheduler) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitScheduler);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitScheduler.getId())).build();
	}
	

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address_id}/patients")
	@PUT
	public Response saveDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			Graphic graphics) {
		doctorService.saveDoctorGraphics(doctor_id, graphics);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphics.getId())).build();
	}
	

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}")
	@DELETE
	public void deleteDoctor(@PathParam("doctor_id") Integer doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(doctor_id);
		doctorService.deleteDoctor(doctor);
	}
	/**
	 * Select an existing Doctor entity
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctor(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id)).build();
	}


	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visitSchedulers")
	@PUT
	public Response saveDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			VisitScheduler visitSchedulers) {
		doctorService.saveDoctorVisitSchedulers(doctor_id, visitSchedulers);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitSchedulers.getId())).build();
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */
	@GET
	@Path("/{doctor_id}/visitSchedulers/{visitscheduler_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		return Response.ok(visitscheduler).build();
	}

	/**
	 * View an existing Recipe entity
	 * 
	 */
	@GET
	@Path("/{doctor_id}/recipes/{recipe_idr}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(related_recipes_idr, -1, -1);

		return Response.ok(recipe).build();
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/recipes/{recipe_idr}")
	public Response deleteDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_recipes_idr") Integer related_recipes_idr) {
		return Response.ok(doctorService.deleteDoctorRecipes(doctor_id, related_recipes_idr)).build();
	}

	/**
	 * View an existing PatientCard entity
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/patientCards/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(related_patientcards_id, -1, -1);

		return Response.ok(patientcard).build();
	}

	/**
	 * Show all PatientCard entities by Doctor
	 * 
	 */

	@GET
	@Path("/{doctor_id}/patientCards")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getPatientCards()).build();
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/visits/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return Response.ok(visit).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/workers")
	@PUT
	public Response saveDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			Worker workers) {
		doctorService.saveDoctorWorkers(doctor_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}
	

	/**
	 * Show all Specialization entities by Doctor
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/specializations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSpecializations()).build();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/patientCards/{patientcard_id}")
	public Response deleteDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_patientcards_id") Integer related_patientcards_id) {
		return Response.ok(doctorService.deleteDoctorPatientCards(doctor_id, related_patientcards_id)).build();
	}

	/**
	 * Show all Graphic entities by Doctor
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/graphics")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorGraphics(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getGraphics()).build();
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */
	@GET
	@Path("/{doctor_id}/specializations/{specialization_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_specializations_id") Integer related_specializations_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specializations_id, -1, -1);

		return Response.ok(specialization).build();
	}

	/**
	 * View an existing SickLeave entity
	 * 
	 */
	@GET
	@Path("/{doctor_id}/sickLeaves/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(related_sickleaves_id, -1, -1);

		return Response.ok(sickleave).build();
	}
	/**
	 * Create a new Recipe entity
	 * 
	 */
	
	@Path("/{doctor_id}/recipes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			Recipe recipe) {
		doctorService.saveDoctorRecipes(doctor_id, recipe);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipe.getIdr())).build();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visits")
	@PUT
	public Response saveDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			Visit visits) {
		doctorService.saveDoctorVisits(doctor_id, visits);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visits.getId())).build();
	}
	/**
	 * Create a new Specialization entity
	 * 
	 */
	
	@Path("/{doctor_id}/specializations")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			Specialization specialization) {
		doctorService.saveDoctorSpecializations(doctor_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */
	
	@Path("/{doctor_id}/patientCards")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			PatientCard patientcard) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

	/**
	 * Show all Doctor entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listDoctors() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(doctorService.loadDoctors())).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctor( Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}


	/**
	 * Delete an existing Specialization entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/specializations/{specialization_id}")
	public Response deleteDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_specializations_id") Integer related_specializations_id) {
		return Response.ok(doctorService.deleteDoctorSpecializations(doctor_id, related_specializations_id)).build();
	}
	

	/**
	 * Save an existing Specialization entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/specializations")
	@PUT
	public Response saveDoctorSpecializations(@PathParam("doctor_id") Integer doctor_id,
			Specialization specializations) {
		doctorService.saveDoctorSpecializations(doctor_id, specializations);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specializations.getId())).build();
	}

	/**
	 * Show all Recipe entities by Doctor
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/recipes")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorRecipes(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getRecipes()).build();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */
	
	@Path("/{doctor_id}/sickLeaves")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			SickLeave sickleave) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visits/{visit_id}")
	public Response deleteDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(doctorService.deleteDoctorVisits(doctor_id, related_visits_id)).build();
	}

	/**
	 * View an existing Graphic entity
	 * 
	 */
	@GET
	@Path("/{doctor_id}/graphics/{graphic_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_graphics_id") Integer related_graphics_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(related_graphics_id, -1, -1);

		return Response.ok(graphic).build();
	}


	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@Path("/{doctor_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorVisits(@PathParam("doctor_id") Integer doctor_id,
			Visit visit) {
		doctorService.saveDoctorVisits(doctor_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/patientCards")
	@PUT
	public Response saveDoctorPatientCards(@PathParam("doctor_id") Integer doctor_id,
			PatientCard patientcards) {
		doctorService.saveDoctorPatientCards(doctor_id, patientcards);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcards.getId())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveDoctor(Doctor doctor) {
		doctorService.saveDoctor(doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Show all VisitScheduler entities by Doctor
	 * 
	 */

	
	@GET
	@Path("/{doctor_id}/visitSchedulers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisitSchedulers()).build();
	}


	/**
	 * View an existing Worker entity
	 * 
	 */

	
	@GET
	@Path("/{doctor_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);
		return Response.ok(worker).build();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/sickLeaves/{sickleave_id}")
	public Response deleteDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_sickleaves_id") Integer related_sickleaves_id) {
		return Response.ok(doctorService.deleteDoctorSickLeaves(doctor_id, related_sickleaves_id)).build();
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/recipes")
	@PUT
	public Response saveDoctorRecipes(@PathParam("doctor_id") Integer doctor_id,
			Recipe recipes) {
		doctorService.saveDoctorRecipes(doctor_id, recipes);
		return Response.ok(recipeDAO.findRecipeByPrimaryKey(recipes.getIdr())).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */

	@Path("/{doctor_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			Worker worker) {
		doctorService.saveDoctorWorkers(doctor_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Delete an existing Graphic entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/graphics/{graphic_id}")
	public Response deleteDoctorGraphics(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_graphics_id") Integer related_graphics_id) {
		return Response.ok(doctorService.deleteDoctorGraphics(doctor_id, related_graphics_id)).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/workers/{worker_id}")
	public Response deleteDoctorWorkers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(doctorService.deleteDoctorWorkers(doctor_id, related_workers_id)).build();
	}

	/**
	 * Show all Visit entities by Doctor
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorVisits(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getVisits()).build();
	}

	

	/**
	 * Show all Worker entities by Doctor
	 * 
	 */
	
	
	@GET
	@Path("/{doctor_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorWorkers(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getWorkers()).build();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/sickLeaves")
	@PUT
	public Response saveDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id,
			SickLeave sickleaves) {
		doctorService.saveDoctorSickLeaves(doctor_id, sickleaves);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleaves.getId())).build();
	}


	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{doctor_id}/visitSchedulers/{visitscheduler_id}")
	public Response deleteDoctorVisitSchedulers(@PathParam("doctor_id") Integer doctor_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		return Response.ok(doctorService.deleteDoctorVisitSchedulers(doctor_id, related_visitschedulers_id)).build();
	}

	/**
	 * Show all SickLeave entities by Doctor
	 * 
	 */
	
	@GET
	@Path("/{doctor_id}/sickLeaves")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDoctorSickLeaves(@PathParam("doctor_id") Integer doctor_id) {
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor_id).getSickLeaves()).build();
	}
}