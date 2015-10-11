package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.SickLeaveDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.SickLeave;
import com.eclinic.domain.Visit;
import com.eclinic.service.SickLeaveService;




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
 * Spring Rest controller that handles CRUD requests for SickLeave entities
 * 
 */
@Path("/SickLeave")
@Component("SickLeaveRestController")
public class SickLeaveRestController {

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
	 * DAO injected by Spring that manages SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveDAO sickLeaveDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SickLeave entities
	 * 
	 */
	@Autowired
	private SickLeaveService sickLeaveService;

	
	public SickLeaveRestController() {
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


	@GET
	@Path("/{sickleave_id}/visit/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSickLeaveVisit(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_visit_id") Integer related_visit_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visit_id, -1, -1);

		return Response.ok(visit).build();
	}
	/**
	 * Select an existing SickLeave entity
	 * 
	 */

	@GET
	@Path("/{sickleave_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSickLeave(@PathParam("sickleave_id") Integer sickleave_id) {
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id)).build();
	}


	/**
	 * Delete an existing Visit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}/visit/{visit_id}")
	public Response deleteSickLeaveVisit(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_visit_id") Integer related_visit_id) {
		return Response.ok(sickLeaveService.deleteSickLeaveVisit(sickleave_id, related_visit_id)).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Path("/{sickleave_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSickLeaveDoctor(@PathParam("sickleave_id") Integer sickleave_id,
			Doctor doctor) {
		sickLeaveService.saveSickLeaveDoctor(sickleave_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */

	

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}/patient/{patient_id}")
	public Response deleteSickLeavePatient(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		return Response.ok(sickLeaveService.deleteSickLeavePatient(sickleave_id, related_patient_id)).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}/doctor/{doctor_id}")
	public Response deleteSickLeaveDoctor(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(sickLeaveService.deleteSickLeaveDoctor(sickleave_id, related_doctor_id)).build();
	}

	/**
	 * Save an existing SickLeave entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSickLeave(SickLeave sickleave) {
		sickLeaveService.saveSickLeave(sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}
	/**
	 * Create a new Patient entity
	 * 
	 */

	
	@Path("/{sickleave_id}/patient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSickLeavePatient(@PathParam("sickleave_id") Integer sickleave_id,
			Patient patient) {
		sickLeaveService.saveSickLeavePatient(sickleave_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Get Patient entity by SickLeave
	 * 
	 */

	@GET
	@Path("/{sickleave_id}/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSickLeavePatient(@PathParam("sickleave_id") Integer sickleave_id) {
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getPatient()).build();
	}

	/**
	 * Create a new SickLeave entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSickLeave(SickLeave sickleave) {
		sickLeaveService.saveSickLeave(sickleave);
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave.getId())).build();
	}

	/**
	 * Create a new Visit entity
	 * 
	 */
	
	
	@Path("/{sickleave_id}/visit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSickLeaveVisit(@PathParam("sickleave_id") Integer sickleave_id,
			Visit visit) {
		sickLeaveService.saveSickLeaveVisit(sickleave_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Delete an existing SickLeave entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}")
	@DELETE
	public void deleteSickLeave(@PathParam("sickleave_id") Integer sickleave_id) {
		SickLeave sickleave = sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id);
		sickLeaveService.deleteSickLeave(sickleave);
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}/visit")
	@PUT
	public Response saveSickLeaveVisit(@PathParam("sickleave_id") Integer sickleave_id,
			Visit visit) {
		sickLeaveService.saveSickLeaveVisit(sickleave_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Get Doctor entity by SickLeave
	 * 
	 */
	
	
	@GET
	@Path("/{sickleave_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSickLeaveDoctor(@PathParam("sickleave_id") Integer sickleave_id) {
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getDoctor()).build();
	}

	/**
	 * Get Visit entity by SickLeave
	 * 
	 */

	
	@GET
	@Path("/{sickleave_id}/visit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSickLeaveVisit(@PathParam("sickleave_id") Integer sickleave_id) {
		return Response.ok(sickLeaveDAO.findSickLeaveByPrimaryKey(sickleave_id).getVisit()).build();
	}

	/**
	 * Show all SickLeave entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSickLeaves() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(sickLeaveService.loadSickLeaves())).build();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{sickleave_id}/patient")
	@PUT
	public Response saveDoctorSpecializations(@PathParam("sickleave_id") Integer sickleave_id,
			Patient patient) {
		sickLeaveService.saveSickLeavePatient(sickleave_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */

	
	@Path("/{sickleave_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSickLeaveDoctor(@PathParam("sickleave_id") Integer sickleave_id,
			Doctor doctor) {
		sickLeaveService.saveSickLeaveDoctor(sickleave_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{sickleave_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSickLeaveDoctor(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);
		return Response.ok(doctor).build();
	}

	
	/**
	 * View an existing Patient entity
	 * 
	 */

	
	@GET
	@Path("/{sickleave_id}/patient/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSickLeavePatient(@PathParam("sickleave_id") Integer sickleave_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return Response.ok(patient).build();
	}
}