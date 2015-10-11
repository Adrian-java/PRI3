package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.service.SpecializationService;




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
 * Spring Rest controller that handles CRUD requests for Specialization entities
 * 
 */
@Path("/Specialization")
@Component("SpecializationRestController")
public class SpecializationRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldDAO specalVisitFieldDAO;

	/**
	 * DAO injected by Spring that manages Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationDAO specializationDAO;

	/**
	 * DAO injected by Spring that manages VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerDAO visitSchedulerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Specialization entities
	 * 
	 */
	@Autowired
	private SpecializationService specializationService;

	
	
	public SpecializationRestController(){}
	
	
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
	 * Show all SpecalVisitField entities by Specialization
	 * 
	 */
	
	@GET
	@Path("/{specialization_id}/specalVisitFields")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecializationSpecalVisitFields(@PathParam("specialization_id") Integer specialization_id) {
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization_id).getSpecalVisitFields()).build();
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */

	
	@Path("/{specialization_id}/visitSchedulers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecializationVisitSchedulers(@PathParam("specialization_id") Integer specialization_id,
			VisitScheduler visitscheduler) {
		specializationService.saveSpecializationVisitSchedulers(specialization_id, visitscheduler);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId())).build();
	}

	/**
	 * Show all Specialization entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSpecializations() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(specializationService.loadSpecializations())).build();
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */

	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/visitSchedulers")
	@PUT
	public Response saveSpecializationVisitSchedulers(@PathParam("specialization_id") Integer specialization_id,
			VisitScheduler visitschedulers) {
		specializationService.saveSpecializationVisitSchedulers(specialization_id, visitschedulers);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitschedulers.getId())).build();
	}

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */

	
	@Path("/{specialization_id}/specalVisitFields")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecializationSpecalVisitFields(@PathParam("specialization_id") Integer specialization_id,
			SpecalVisitField specalvisitfield) {
		specializationService.saveSpecializationSpecalVisitFields(specialization_id, specalvisitfield);
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId())).build();
	}

	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/specalVisitFields")
	@PUT
	public Response saveSpecializationSpecalVisitFields(@PathParam("specialization_id") Integer specialization_id,
			SpecalVisitField specalvisitfields) {
		specializationService.saveSpecializationSpecalVisitFields(specialization_id, specalvisitfields);
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfields.getId())).build();
	}

	/**
	 * Select an existing Specialization entity
	 * 
	 */

	
	@GET
	@Path("/{specialization_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecialization(@PathParam("specialization_id") Integer specialization_id) {
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization_id)).build();
	}

	/**
	 * View an existing SpecalVisitField entity
	 * 
	 */

	
	@GET
	@Path("/{specialization_id}/specalVisitFields/{specalvisitfield_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecializationSpecalVisitFields(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_specalvisitfields_id") Integer related_specalvisitfields_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(related_specalvisitfields_id, -1, -1);

		return Response.ok(specalvisitfield).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/doctor")
	@PUT
	public Response saveSpecializationDoctor(@PathParam("specialization_id") Integer specialization_id,
			Doctor doctor) {
		specializationService.saveSpecializationDoctor(specialization_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/doctor/{doctor_id}")
	public Response deleteSpecializationDoctor(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(specializationService.deleteSpecializationDoctor(specialization_id, related_doctor_id)).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */

	
	@Path("/{specialization_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecializationDoctor(@PathParam("specialization_id") Integer specialization_id,
			Doctor doctor) {
		specializationService.saveSpecializationDoctor(specialization_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}")
	@DELETE
	public void deleteSpecialization(@PathParam("specialization_id") Integer specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(specialization_id);
		specializationService.deleteSpecialization(specialization);
	}

	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/specalVisitFields/{specalvisitfield_id}")
	public Response deleteSpecializationSpecalVisitFields(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_specalvisitfields_id") Integer related_specalvisitfields_id) {
		return Response.ok(specializationService.deleteSpecializationSpecalVisitFields(specialization_id, related_specalvisitfields_id)).build();
	}

	/**
	 * Get Doctor entity by Specialization
	 * 
	 */

	
	@GET
	@Path("/{specialization_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecializationDoctor(@PathParam("specialization_id") Integer specialization_id) {
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization_id).getDoctor()).build();
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */

	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecialization(Specialization specialization) {
		specializationService.saveSpecialization(specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specialization_id}/visitSchedulers/{visitscheduler_id}")
	public Response deleteSpecializationVisitSchedulers(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		return Response.ok(		specializationService.deleteSpecializationVisitSchedulers(specialization_id, related_visitschedulers_id)).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	
	
	@GET
	@Path("/{specialization_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecializationDoctor(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return Response.ok(doctor).build();
	}

	/**
	 * Show all VisitScheduler entities by Specialization
	 * 
	 */

	
	@GET
	@Path("/{specialization_id}/visitSchedulers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecializationVisitSchedulers(@PathParam("specialization_id") Integer specialization_id) {
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization_id).getVisitSchedulers()).build();
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSpecialization(Specialization specialization) {
		specializationService.saveSpecialization(specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * View an existing VisitScheduler entity
	 * 
	 */

	
	
	@GET
	@Path("/{specialization_id}/visitSchedulers/{visitscheduler_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecializationVisitSchedulers(@PathParam("specialization_id") Integer specialization_id,
			@PathParam("related_visitschedulers_id") Integer related_visitschedulers_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(related_visitschedulers_id, -1, -1);

		return Response.ok(visitscheduler).build();
	}


	
}