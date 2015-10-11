package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.dao.VisitSchedulerDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Specialization;
import com.eclinic.domain.VisitScheduler;
import com.eclinic.service.VisitSchedulerService;




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
 * Spring Rest controller that handles CRUD requests for VisitScheduler entities
 * 
 */
@Path("/VisitScheduler")
@Component("VisitSchedulerRestController")
public class VisitSchedulerRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

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
	 * Service injected by Spring that provides CRUD operations for VisitScheduler entities
	 * 
	 */
	@Autowired
	private VisitSchedulerService visitSchedulerService;

	
	public VisitSchedulerRestController(){}
	
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
	 * Delete an existing Specialization entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}/specialization/{specialization_id}")
	public Response deleteVisitSchedulerSpecialization(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			@PathParam("related_specialization_id") Integer related_specialization_id) {
		return Response.ok(visitSchedulerService.deleteVisitSchedulerSpecialization(visitscheduler_id, related_specialization_id)).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */

	@Path("/{visitscheduler_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitSchedulerDoctor(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			Doctor doctor) {
		visitSchedulerService.saveVisitSchedulerDoctor(visitscheduler_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Create a new VisitScheduler entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitScheduler(VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId())).build();
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */

	
	@GET
	@Path("/{visitscheduler_id}/specialization/{specialization_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitSchedulerSpecialization(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			@PathParam("related_specialization_id") Integer related_specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);

		return Response.ok(specialization).build();
	}


	/**
	 * Select an existing VisitScheduler entity
	 * 
	 */

	
	@GET
	@Path("/{visitscheduler_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitScheduler(@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id)).build();
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */

	
	@Path("/{visitscheduler_id}/specialization")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newVisitSchedulerSpecialization(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			Specialization specialization) {
		visitSchedulerService.saveVisitSchedulerSpecialization(visitscheduler_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * Delete an existing VisitScheduler entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}")
	@DELETE
	public void deleteVisitScheduler(@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		VisitScheduler visitscheduler = visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id);
		visitSchedulerService.deleteVisitScheduler(visitscheduler);
	}

	
	/**
	 * Get Doctor entity by VisitScheduler
	 * 
	 */

	
	@GET
	@Path("/{visitscheduler_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitSchedulerDoctor(@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id).getDoctor()).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{visitscheduler_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadVisitSchedulerDoctor(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return Response.ok(doctor).build();
	}


	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}/doctor/{doctor_id}")
	public Response deleteVisitSchedulerDoctor(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(visitSchedulerService.deleteVisitSchedulerDoctor(visitscheduler_id, related_doctor_id)).build();
	}

	/**
	 * Show all VisitScheduler entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listVisitSchedulers() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(visitSchedulerService.loadVisitSchedulers())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}/doctor")
	@PUT
	public Response saveVisitSchedulerDoctor(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			Doctor doctor) {
		visitSchedulerService.saveVisitSchedulerDoctor(visitscheduler_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{visitscheduler_id}/specialization")
	@PUT
	public Response saveVisitSchedulerSpecialization(@PathParam("visitscheduler_id") Integer visitscheduler_id,
			Specialization specialization) {
		visitSchedulerService.saveVisitSchedulerSpecialization(visitscheduler_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	/**
	 * Save an existing VisitScheduler entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveVisitScheduler(VisitScheduler visitscheduler) {
		visitSchedulerService.saveVisitScheduler(visitscheduler);
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler.getId())).build();
	}

	/**
	 * Get Specialization entity by VisitScheduler
	 * 
	 */

	
	@GET
	@Path("/{visitscheduler_id}/specialization")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVisitSchedulerSpecialization(@PathParam("visitscheduler_id") Integer visitscheduler_id) {
		return Response.ok(visitSchedulerDAO.findVisitSchedulerByPrimaryKey(visitscheduler_id).getSpecialization()).build();
	}
}
