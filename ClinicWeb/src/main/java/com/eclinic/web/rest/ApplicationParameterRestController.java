package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.ApplicationParameterDAO;
import com.eclinic.domain.ApplicationParameter;
import com.eclinic.service.ApplicationParameterService;

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
 * Spring Rest controller that handles CRUD requests for ApplicationParameter entities
 * 
 */

@Path("/ApplicationParameter")
@Component("ApplicationParameterRestController")
public class ApplicationParameterRestController {

	
	/**
	 * DAO injected by Spring that manages ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterDAO applicationParameterDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for ApplicationParameter entities
	 * 
	 */
	@Autowired
	private ApplicationParameterService applicationParameterService;

	public ApplicationParameterRestController() {
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
	 * Save an existing ApplicationParameter entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveApplicationParameter( ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId())).build();
	}

	/**
	 * Create a new ApplicationParameter entity
	 * 
	 */
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newApplicationParameter( ApplicationParameter applicationparameter) {
		applicationParameterService.saveApplicationParameter(applicationparameter);
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter.getId())).build();
	}

	/**
	 * Show all ApplicationParameter entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listApplicationParameters() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(applicationParameterService.loadApplicationParameters())).build();
	}

	

	/**
	 * Delete an existing ApplicationParameter entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{applicationparameter_id}")
	@DELETE
	public void deleteApplicationParameter(@PathParam("applicationparameter_id") Integer applicationparameter_id) {
		ApplicationParameter applicationparameter = applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id);
		applicationParameterService.deleteApplicationParameter(applicationparameter);
	}

	/**
	 * Select an existing ApplicationParameter entity
	 * 
	 */

	@GET
	@Path("/{applicationparameter_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadApplicationParameter(@PathParam("applicationparameter_id") Integer applicationparameter_id) {
		return Response.ok(applicationParameterDAO.findApplicationParameterByPrimaryKey(applicationparameter_id)).build();
	}
}