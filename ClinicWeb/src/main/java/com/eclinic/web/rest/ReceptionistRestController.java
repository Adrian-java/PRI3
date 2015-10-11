package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.ReceptionistDAO;
import com.eclinic.dao.VisitDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Receptionist;
import com.eclinic.domain.Visit;
import com.eclinic.domain.Worker;
import com.eclinic.service.ReceptionistService;




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
 * Spring Rest controller that handles CRUD requests for Receptionist entities
 * 
 */
@Path("/Receptionist")
@Component("ReceptionistRestController")
public class ReceptionistRestController {

	/**
	 * DAO injected by Spring that manages Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistDAO receptionistDAO;

	/**
	 * DAO injected by Spring that manages Visit entities
	 * 
	 */
	@Autowired
	private VisitDAO visitDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Receptionist entities
	 * 
	 */
	@Autowired
	private ReceptionistService receptionistService;

	public ReceptionistRestController() {
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
	 * Create a new Worker entity
	 * 
	 */
	
	
	
	@Path("/{doctor_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newReceptionistWorkers(@PathParam("receptionist_id") Integer receptionist_id,
			Worker worker) {
		receptionistService.saveReceptionistWorkers(receptionist_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * View an existing Visit entity
	 * 
	 */

	
	@GET
	@Path("/{receptionist_id}/visits/{visit_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadReceptionistVisits(@PathParam("receptionist_id") Integer receptionist_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		Visit visit = visitDAO.findVisitByPrimaryKey(related_visits_id, -1, -1);

		return Response.ok(visit).build();
	}

	/**
	 * Show all Receptionist entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listReceptionists() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(receptionistService.loadReceptionists())).build();
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{receptionist_id}/workers/{worker_id}")
	public Response deleteReceptionistWorkers(@PathParam("receptionist_id") Integer receptionist_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(receptionistService.deleteReceptionistWorkers(receptionist_id, related_workers_id)).build();
	}

	/**
	 * Create a new Receptionist entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newReceptionist( Receptionist receptionist) {
		receptionistService.saveReceptionist(receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * Select an existing Receptionist entity
	 * 
	 */
	
	
	
	@GET
	@Path("/{receptionist_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadReceptionist(@PathParam("receptionist_id") Integer receptionist_id) {
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist_id)).build();
	}

	/**
	 * Delete an existing Receptionist entity
	 * 
	 */
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{receptionist_id}")
	@DELETE
	public void deleteReceptionist(@PathParam("receptionist_id") Integer receptionist_id) {
		Receptionist receptionist = receptionistDAO.findReceptionistByPrimaryKey(receptionist_id);
		receptionistService.deleteReceptionist(receptionist);
	}

	/**
	 * Create a new Visit entity
	 * 
	 */

	
	@Path("/{receptionist_id}/visits")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newReceptionistVisits(@PathParam("receptionist_id") Integer receptionist_id,
			 Visit visit) {
		receptionistService.saveReceptionistVisits(receptionist_id, visit);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visit.getId())).build();
	}

	/**
	 * Save an existing Receptionist entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveReceptionist(Receptionist receptionist) {
		receptionistService.saveReceptionist(receptionist);
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist.getId())).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{receptionist_id}/workers")
	@PUT
	public Response saveReceptionistWorkers(@PathParam("receptionist_id") Integer receptionist_id,
			Worker workers) {
		receptionistService.saveReceptionistWorkers(receptionist_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}

	/**
	 * Show all Visit entities by Receptionist
	 * 
	 */

	
	@GET
	@Path("/{receptionist_id}/visits")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReceptionistVisits(@PathParam("receptionist_id") Integer receptionist_id) {
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist_id).getVisits()).build();
	}


	

	/**
	 * Delete an existing Visit entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{receptionist_id}/visits/{visit_id}")
	public Response deleteReceptionistVisits(@PathParam("receptionist_id") Integer receptionist_id,
			@PathParam("related_visits_id") Integer related_visits_id) {
		return Response.ok(receptionistService.deleteReceptionistVisits(receptionist_id, related_visits_id)).build();
	}

	/**
	 * Save an existing Visit entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{receptionist_id}/visits")
	@PUT
	public Response saveReceptionistVisits(@PathParam("receptionist_id") Integer receptionist_id,
			Visit visits) {
		receptionistService.saveReceptionistVisits(receptionist_id, visits);
		return Response.ok(visitDAO.findVisitByPrimaryKey(visits.getId())).build();
	}

	/**
	 * Show all Worker entities by Receptionist
	 * 
	 */

	
	@GET
	@Path("/{receptionist_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getReceptionistWorkers(@PathParam("receptionist_id") Integer receptionist_id) {
		return Response.ok(receptionistDAO.findReceptionistByPrimaryKey(receptionist_id).getWorkers()).build();
	}

	/**
	 * View an existing Worker entity
	 * 
	 */

	
	@GET
	@Path("/{receptionist_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadReceptionistWorkers(@PathParam("receptionist_id") Integer receptionist_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);
		return Response.ok(worker).build();
	}
}