package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.SystemUserDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Admin;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.SystemUser;
import com.eclinic.domain.Worker;
import com.eclinic.service.WorkerService;





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
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;


/**
 * Spring Rest controller that handles CRUD requests for Worker entities
 * 
 */
@Path("/Worker")
@Component("WorkerRestController")
public class WorkerRestController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages SystemUser entities
	 * 
	 */
	@Autowired
	private SystemUserDAO systemUserDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Worker entities
	 * 
	 */
	@Autowired
	private WorkerService workerService;

	
	
	public WorkerRestController(){}
	
	
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
	 * Save an existing LoginHistory entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/loginHistories")
	@PUT
	public Response saveWorkerLoginHistories(@PathParam("worker_id") Integer worker_id,
			LoginHistory loginhistories) {
		workerService.saveWorkerLoginHistories(worker_id, loginhistories);
		return Response.ok(loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistories.getId())).build();
	}

	
	/**
	 * Get Admin entity by Worker
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/admin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerAdmin(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getAdmin()).build();
	}

	/**
	 * Create a new Doctor entity
	 * 
	 */


	@Path("/{worker_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerDoctor(@PathParam("worker_id") Integer worker_id,
			Doctor doctor) {
		workerService.saveWorkerDoctor(worker_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/patient")
	@PUT
	public Response saveWorkerPatient(@PathParam("worker_id") Integer worker_id,
			Patient patient) {
		workerService.saveWorkerPatient(worker_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Get Doctor entity by Worker
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerDoctor(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getDoctor()).build();
	}


	/**
	 * Save an existing SystemUser entity
	 * 
	 */


	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/systemUsers")
	@PUT
	public Response saveWorkerSystemUsers(@PathParam("worker_id") Integer worker_id,
			SystemUser systemusers) {
		workerService.saveWorkerSystemUsers(worker_id, systemusers);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemusers.getId())).build();
	}
	/**
	 * Save an existing Worker entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveWorker( Worker worker) {
		workerService.saveWorker(worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */

	
	@Path("/{worker_id}/receptionist")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerReceptionist(@PathParam("worker_id") Integer worker_id,
			Receptionist receptionist) {
		workerService.saveWorkerReceptionist(worker_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/admin")
	@PUT
	public Response saveWorkerAdmin(@PathParam("worker_id") Integer worker_id,
			Admin admin) {
		workerService.saveWorkerAdmin(worker_id, admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}

	/**
	 * Show all Worker entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listWorkers() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS, false).writeValueAsString(workerService.loadWorkers())).build();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */

	
	@Path("/{worker_id}/patient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerPatient(@PathParam("worker_id") Integer worker_id,
			Patient patient) {
		workerService.saveWorkerPatient(worker_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/patients/{patient_id}")
	public Response deleteWorkerPatient(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		return Response.ok(workerService.deleteWorkerPatient(worker_id, related_patient_id)).build();
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/receptionist")
	@PUT
	public Response saveWorkerReceptionist(@PathParam("worker_id") Integer worker_id,
			Receptionist receptionist) {
		workerService.saveWorkerReceptionist(worker_id, receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * View an existing SystemUser entity
	 * 
	 */
	
	
	@GET
	@Path("/{worker_id}/systemUsers/{systemuser_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerSystemUsers(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_systemusers_id") Integer related_systemusers_id) {
		SystemUser systemuser = systemUserDAO.findSystemUserByPrimaryKey(related_systemusers_id, -1, -1);

		return Response.ok(systemuser).build();
	}

	/**
	 * Get Receptionist entity by Worker
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/receptionist")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerReceptionist(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getReceptionist()).build();
	}

	/**
	 * Show all SystemUser entities by Worker
	 * 
	 */

	@GET
	@Path("/{worker_id}/systemUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerSystemUsers(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getSystemUsers()).build();
	}

	/**
	 * Create a new LoginHistory entity
	 * 
	 */

	
	@Path("/{worker_id}/loginHistories")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerLoginHistories(@PathParam("worker_id") Integer worker_id,
			LoginHistory loginhistory) {
		workerService.saveWorkerLoginHistories(worker_id, loginhistory);
		return Response.ok( loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId())).build();
	}

	/**
	 * Create a new Admin entity
	 * 
	 */

	
	@Path("/{worker_id}/admin")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerAdmin(@PathParam("worker_id") Integer worker_id,
			Admin admin) {
		workerService.saveWorkerAdmin(worker_id, admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}

	/**
	 * View an existing Receptionist entity
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/receptionist/{receptionist_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerReceptionist(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(related_receptionist_id, -1, -1);

		return Response.ok(receptionist).build();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/doctor/{doctor_id}")
	public Response deleteWorkerDoctor(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(workerService.deleteWorkerDoctor(worker_id, related_doctor_id)).build();
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/admin/{admin_id}")
	public Response deleteWorkerAdmin(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_admin_id") Integer related_admin_id) {
		return Response.ok(workerService.deleteWorkerAdmin(worker_id, related_admin_id)).build();
	}

	/**
	 * Show all LoginHistory entities by Worker
	 * 
	 */
	
	@GET
	@Path("/{worker_id}/loginHistories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerLoginHistories(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getLoginHistories()).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerDoctor(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		Doctor doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		return Response.ok(doctor).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/doctor")
	@PUT
	public Response saveWorkerDoctor(@PathParam("worker_id") Integer worker_id,
			Doctor doctor) {
		workerService.saveWorkerDoctor(worker_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * View an existing Admin entity
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/admin/{admin_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerAdmin(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_admin_id") Integer related_admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(related_admin_id, -1, -1);

		return Response.ok(admin).build();
	}

	/**
	 * Select an existing Worker entity
	 * 
	 */

	@GET
	@Path("/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorker(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id)).build();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */


	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/receptionist/{receptionist_id}")
	public Response deleteWorkerReceptionist(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_receptionist_id") Integer related_receptionist_id) {
		return Response.ok(workerService.deleteWorkerReceptionist(worker_id, related_receptionist_id)).build();
	}
	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/loginHistories/{loginhistory_id}")
	public Response deleteWorkerLoginHistories(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_loginhistories_id") Integer related_loginhistories_id) {
		return Response.ok(workerService.deleteWorkerLoginHistories(worker_id, related_loginhistories_id)).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorker(Worker worker) {
		workerService.saveWorker(worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * View an existing LoginHistory entity
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/loginHistories/{loginhistory_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerLoginHistories(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_loginhistories_id") Integer related_loginhistories_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(related_loginhistories_id, -1, -1);

		return Response.ok(loginhistory).build();
	}

	/**
	 * Delete an existing SystemUser entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}/systemUsers/{systemuser_id}")
	public Response deleteWorkerSystemUsers(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_systemusers_id") Integer related_systemusers_id) {
		return Response.ok(workerService.deleteWorkerSystemUsers(worker_id, related_systemusers_id)).build();
	}

	/**
	 * Create a new SystemUser entity
	 * 
	 */

	
	@Path("/{worker_id}/systemUsers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newWorkerSystemUsers(@PathParam("worker_id") Integer worker_id,
			SystemUser systemuser) {
		workerService.saveWorkerSystemUsers(worker_id, systemuser);
		return Response.ok(systemUserDAO.findSystemUserByPrimaryKey(systemuser.getId())).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{worker_id}")
	@DELETE
	public void deleteWorker(@PathParam("worker_id") Integer worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(worker_id);
		workerService.deleteWorker(worker);
	}

	/**
	 * View an existing Patient entity
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/patient/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadWorkerPatient(@PathParam("worker_id") Integer worker_id,
			@PathParam("related_patient_id") Integer related_patient_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		return Response.ok(patient).build();
	}

	/**
	 * Get Patient entity by Worker
	 * 
	 */

	
	@GET
	@Path("/{worker_id}/patient")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkerPatient(@PathParam("worker_id") Integer worker_id) {
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker_id).getPatient()).build();
	}
}
