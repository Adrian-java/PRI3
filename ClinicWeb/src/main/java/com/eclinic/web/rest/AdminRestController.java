package com.eclinic.web.rest;


import java.io.IOException;

import com.eclinic.dao.AdminDAO;
import com.eclinic.dao.WorkerDAO;
import com.eclinic.domain.Admin;
import com.eclinic.domain.Worker;
import com.eclinic.service.AdminService;

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
 * Spring Rest controller that handles CRUD requests for Admin entities
 * 
 */


@Path("/Admin") 
@Component("AdminRestController")  
public class AdminRestController {

	/**
	 * DAO injected by Spring that manages Admin entities
	 * 
	 */
	
	@Autowired
	private AdminDAO adminDAO;

	/**
	 * DAO injected by Spring that manages Worker entities
	 * 
	 */
	@Autowired
	private WorkerDAO workerDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Admin entities
	 * 
	 */
	@Autowired
	private AdminService adminService;

	
	public AdminRestController() {
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
	 * Show all Admin entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAdmins() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().configure(Feature.FAIL_ON_EMPTY_BEANS, false).writeValueAsString(adminService.loadAdmins())).build();
	}

	/**
	 * View an existing Worker entity
	 * 
	 */
	
	
	@GET
	@Path("/{admin_id}/workers/{worker_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAdminWorkers(@PathParam("admin_id") Integer admin_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		Worker worker = workerDAO.findWorkerByPrimaryKey(related_workers_id, -1, -1);

		return Response.ok(worker).build();
	}


	/**
	 * Select an existing Admin entity
	 * 
	 */
	
	
	@GET
	@Path("/{admin_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAdmin(@PathParam("admin_id") Integer admin_id) {
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin_id)).build();
	}

	/**
	 * Create a new Worker entity
	 * 
	 */
	
	@Path("/{admin_id}/workers")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAdminWorkers(@PathParam("admin_id") Integer admin_id,
			 Worker worker) {
		adminService.saveAdminWorkers(admin_id, worker);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(worker.getId())).build();
	}

	/**
	 * Save an existing Admin entity
	 * 
	 */
	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAdmin( Admin admin) {
		adminService.saveAdmin(admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}

	/**
	 * Create a new Admin entity
	 * 
	 */
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAdmin( Admin admin) {
		adminService.saveAdmin(admin);
		return Response.ok(adminDAO.findAdminByPrimaryKey(admin.getId())).build();
	}
	

	/**
	 * Save an existing Worker entity
	 * 
	 */
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}/workers")
	@PUT
	public Response saveAdminWorkers(@PathParam("admin_id") Integer admin_id,
			 Worker workers) {
		adminService.saveAdminWorkers(admin_id, workers);
		return Response.ok(workerDAO.findWorkerByPrimaryKey(workers.getId())).build();
	}

	/**
	 * Delete an existing Admin entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}")
	@DELETE
	public void deleteAdmin(@PathParam("admin_id") Integer admin_id) {
		Admin admin = adminDAO.findAdminByPrimaryKey(admin_id);
		adminService.deleteAdmin(admin);
	}

	/**
	 * Delete an existing Worker entity
	 * 
	 */
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{admin_id}/workers/{worker_id}")
	public Response deleteAdminWorkers(@PathParam("admin_id") Integer admin_id,
			@PathParam("related_workers_id") Integer related_workers_id) {
		return Response.ok(adminService.deleteAdminWorkers(admin_id, related_workers_id)).build();
	}


	/**
	 * Show all Worker entities by Admin
	 * 
	 */
	
	@GET
	@Path("/{admin_id}/workers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdminWorkers(@PathParam("admin_id") Integer admin_id) {
		return Response.ok(adminDAO
				.findAdminByPrimaryKey(admin_id).getWorkers()).build();
	}

}
