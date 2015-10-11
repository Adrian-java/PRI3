package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.SystemErrorDAO;
import com.eclinic.domain.SystemError;
import com.eclinic.service.SystemErrorService;





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
 * Spring Rest controller that handles CRUD requests for SystemError entities
 * 
 */
@Path("/SystemError")
@Component("SystemErrorRestController")
public class SystemErrorRestController {

	/**
	 * DAO injected by Spring that manages SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorDAO systemErrorDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for SystemError entities
	 * 
	 */
	@Autowired
	private SystemErrorService systemErrorService;
	
	public SystemErrorRestController(){}
	
	
	
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
	 * Save an existing SystemError entity
	 * 
	 */

	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSystemError(SystemError systemerror) {
		systemErrorService.saveSystemError(systemerror);
		return Response.ok(systemErrorDAO.findSystemErrorByPrimaryKey(systemerror.getId())).build();
	}

	/**
	 * Delete an existing SystemError entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{systemerror_id}")
	@DELETE
	public void deleteSystemError(@PathParam("systemerror_id") Integer systemerror_id) {
		SystemError systemerror = systemErrorDAO.findSystemErrorByPrimaryKey(systemerror_id);
		systemErrorService.deleteSystemError(systemerror);
	}

	/**
	 * Show all SystemError entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSystemErrors() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(systemErrorService.loadSystemErrors())).build();
	}

	/**
	 * Create a new SystemError entity
	 * 
	 */

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSystemError( SystemError systemerror) {
		systemErrorService.saveSystemError(systemerror);
		return Response.ok(systemErrorDAO.findSystemErrorByPrimaryKey(systemerror.getId())).build();
	}

	/**
	 * Select an existing SystemError entity
	 * 
	 */

	
	@GET
	@Path("/{systemerror_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSystemError(@PathParam("systemerror_id") Integer systemerror_id) {
		return Response.ok(systemErrorDAO.findSystemErrorByPrimaryKey(systemerror_id)).build();
	}

	
}