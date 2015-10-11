package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.LoginHistoryDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.LoginHistory;
import com.eclinic.domain.Worker;
import com.eclinic.service.LoginHistoryService;




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
 * Spring Rest controller that handles CRUD requests for LoginHistory entities
 * 
 */
@Path("/LoginHistory")
@Component("LoginHistoryRestController")
public class LoginHistoryRestController {

	/**
	 * DAO injected by Spring that manages LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryDAO loginHistoryDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for LoginHistory entities
	 * 
	 */
	@Autowired
	private LoginHistoryService loginHistoryService;

	public LoginHistoryRestController() {
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
	 * Get Worker entity by LoginHistory
	 * 
	 */

	
	@GET
	@Path("/{loginhistory_id}/worker")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLoginHistoryWorker(@PathParam("loginhistory_id") Integer loginhistory_id) {
		return Response.ok(loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id).getWorker()).build();
	}

	/**
	 * Save an existing Worker entity
	 * 
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{loginhistory_id}/worker")
	@PUT
	public Response saveLoginHistoryWorker(@PathParam("loginhistory_id") Integer loginhistory_id,
			Worker worker) {
		loginHistoryService.saveLoginHistoryWorker(loginhistory_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Select an existing LoginHistory entity
	 * 
	 */
	
	@GET
	@Path("/{loginhistory_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctor(@PathParam("loginhistory_id") Integer loginhistory_id) {
		return Response.ok(loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id)).build();
	}


	/**
	 * Create a new LoginHistory entity
	 * 
	 */
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newLoginHistory( LoginHistory loginhistory) {
		loginHistoryService.saveLoginHistory(loginhistory);
		return Response.ok(loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId())).build();
	}
	/**
	 * View an existing Worker entity
	 * 
	 */

	
	@GET
	@Path("/{loginhistory_id}/worker/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadDoctorGraphics(@PathParam("loginhistory_id") Integer loginhistory_id,
			@PathParam("related_worker_id") Integer related_worker_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_worker_id, -1, -1);

		return Response.ok(worker).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */

	
	@Path("/{loginhistory_id}/worker")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newLoginHistoryWorker(@PathParam("loginhistory_id") Integer loginhistory_id,
			Worker worker) {
		loginHistoryService.saveLoginHistoryWorker(loginhistory_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Save an existing LoginHistory entity
	 * 
	 */


	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveLoginHistory(LoginHistory loginhistory) {
		loginHistoryService.saveLoginHistory(loginhistory);
		return Response.ok(loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory.getId())).build();
	}
	/**
	 * Delete an existing Worker entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{loginhistory_id}/worker/{worker_id}")
	public Response deleteLoginHistoryWorker(@PathParam("loginhistory_id") Integer loginhistory_id,
			@PathParam("related_worker_id") Integer related_worker_id) {
		return Response.ok(loginHistoryService.deleteLoginHistoryWorker(loginhistory_id, related_worker_id)).build();
	}

	/**
	 * Show all LoginHistory entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listLoginHistorys() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(loginHistoryService.loadLoginHistorys())).build();
	}

	/**
	 * Delete an existing LoginHistory entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{loginhistory_id}")
	@DELETE
	public void deleteDoctor(@PathParam("loginhistory_id") Integer loginhistory_id) {
		LoginHistory loginhistory = loginHistoryDAO.findLoginHistoryByPrimaryKey(loginhistory_id);		
		loginHistoryService.deleteLoginHistory(loginhistory);
	}
}