package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientCardDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;
import com.eclinic.domain.Visit;
import com.eclinic.service.PatientCardService;




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
 * Spring Rest controller that handles CRUD requests for PatientCard entities
 * 
 */
@Path("/PatientCard")
@Component("PatientCardRestController")
public class PatientCardRestController {

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
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for PatientCard entities
	 * 
	 */
	@Autowired
	private PatientCardService patientCardService;

	public PatientCardRestController() {
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
	 * Show all PatientCard entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPatientCards() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(patientCardService.loadPatientCards())).build();
	}

	/**
	 * Get Doctor entity by PatientCard
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientCardDoctor(@PathParam("patientcard_id") Integer patientcard_id) {
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getDoctor()).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */

	
	@Path("/{patientcard_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientCardDoctor(@PathParam("patientcard_id") Integer patientcard_id,
			Doctor doctor) {
		patientCardService.savePatientCardDoctor(patientcard_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Delete an existing PatientCard entity
	 * 
	 */


	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}")
	@DELETE
	public void deletePatientCard(@PathParam("patientcard_id") Integer patientcard_id) {
		PatientCard patientcard = patientCardDAO.findPatientCardByPrimaryKey(patientcard_id);
		patientCardService.deletePatientCard(patientcard);
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/patient")
	@PUT
	public Response savePatientCardPatient(@PathParam("patientcard_id") Integer patientcard_id,
			Patient patient) {
		patientCardService.savePatientCardPatient(patientcard_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@Path("/{patientcard_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientCardVisits(@PathParam("patientcard_id") Integer patientcard_id,
			Visit visit) {
		patientCardService.savePatientCardVisits(patientcard_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/patient/{patient_id}")
	public Response deletePatientCardPatient(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		return Response.ok(patientCardService.deletePatientCardPatient(patientcard_id, related_patient_id)).build();
	}

	/**
	 * Show all Visit entities by PatientCard
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientCardVisits(@PathParam("patientcard_id") Integer patientcard_id) {
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getVisits()).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/doctor")
	@PUT
	public Response savePatientCardDoctor(@PathParam("patientcard_id") Integer patientcard_id,
			Doctor doctor) {
		patientCardService.savePatientCardDoctor(patientcard_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/visits")
	@PUT
	public Response savePatientCardVisits(@PathParam("patientcard_id") Integer patientcard_id,
			Visit visits) {
		patientCardService.savePatientCardVisits(patientcard_id, visits);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visits.getId())).build();
	}

	/**
	 * Delete an existing Visit entity
	 * 
	 */


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/visits/{visit_id}")
	public Response deletePatientCardVisits(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(patientCardService.deletePatientCardVisits(patientcard_id, related_visits_id)).build();
	}
	/**
	 * Select an existing PatientCard entity
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientCard(@PathParam("patientcard_id") Integer patientcard_id) {
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard_id)).build();
	}

	/**
	 * Create a new PatientCard entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientCard( PatientCard patientcard) {
		patientCardService.savePatientCard(patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientCardDoctor(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return Response.ok(doctor).build();
	}

	/**
	 * View an existing Visit entity
	 * 
	 */
	
	
	@GET
	@Path("/{patientcard_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientCardVisits(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return Response.ok(visit).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patientcard_id}/doctor/{doctor_id}")
	public Response deletePatientCardDoctor(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(patientCardService.deletePatientCardDoctor(patientcard_id, related_doctor_id)).build();
	}

	/**
	 * Get Patient entity by PatientCard
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientCardPatient(@PathParam("patientcard_id") Integer patientcard_id) {
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard_id).getPatient()).build();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */

	@Path("/{patientcard_id}/patient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newPatientCardPatient(@PathParam("patientcard_id") Integer patientcard_id,
			Patient patient) {
		patientCardService.savePatientCardPatient(patientcard_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	

	/**
	 * View an existing Patient entity
	 * 
	 */

	
	@GET
	@Path("/{patientcard_id}/patient/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadPatientCardPatient(@PathParam("patientcard_id") Integer patientcard_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return Response.ok(patient).build();
	}

	/**
	 * Save an existing PatientCard entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePatientCard(PatientCard patientcard) {
		patientCardService.savePatientCard(patientcard);
		return Response.ok(patientCardDAO.findPatientCardByPrimaryKey(patientcard.getId())).build();
	}

}