package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.SpecalVisitFieldDAO;
import com.eclinic.dao.SpecializationDAO;
import com.eclinic.domain.SpecalVisitField;
import com.eclinic.domain.Specialization;
import com.eclinic.service.SpecalVisitFieldService;




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
 * Spring Rest controller that handles CRUD requests for SpecalVisitField entities
 * 
 */
@Path("/SpecalVisit")
@Component("SpecalVisitFieldRestController")
public class SpecalVisitFieldRestController {

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
	 * Service injected by Spring that provides CRUD operations for SpecalVisitField entities
	 * 
	 */
	@Autowired
	private SpecalVisitFieldService specalVisitFieldService;

	public SpecalVisitFieldRestController() {
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
	 * Show all SpecalVisitField entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listSpecalVisitFields() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(specalVisitFieldService.loadSpecalVisitFields())).build();
	}

	/**
	 * View an existing Specialization entity
	 * 
	 */

	@GET
	@Path("/{specalvisitfield_id}/specialization/{specialization_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecalVisitFieldSpecialization(@PathParam("specalvisitfield_id") Integer specalvisitfield_id,
			@PathParam("related_specialization_id") Integer related_specialization_id) {
		Specialization specialization = specializationDAO.findSpecializationByPrimaryKey(related_specialization_id, -1, -1);
		return Response.ok(specialization).build();
	}

	/**
	 * Select an existing SpecalVisitField entity
	 * 
	 */

	
	@GET
	@Path("/{specalvisitfield_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadSpecalVisitField(@PathParam("specalvisitfield_id") Integer specalvisitfield_id) {
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id)).build();
	}

	/**
	 * Save an existing Specialization entity
	 * 
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specalvisitfield_id}/specialization")
	@PUT
	public Response saveSpecalVisitFieldSpecialization(@PathParam("specalvisitfield_id") Integer specalvisitfield_id,
			Specialization specialization) {
		specalVisitFieldService.saveSpecalVisitFieldSpecialization(specalvisitfield_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}


	/**
	 * Save an existing SpecalVisitField entity
	 * 
	 */

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveSpecalVisitField(SpecalVisitField specalvisitfield) {
		specalVisitFieldService.saveSpecalVisitField(specalvisitfield);
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId())).build();
	}

	/**
	 * Delete an existing Specialization entity
	 * 
	 */

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specalvisitfield_id}/specialization/{specialization_id}")
	public Response deleteSpecalVisitFieldSpecialization(@PathParam("specalvisitfield_id") Integer specalvisitfield_id,
			@PathParam("related_specialization_id") Integer related_specialization_id) {
		return Response.ok(specalVisitFieldService.deleteSpecalVisitFieldSpecialization(specalvisitfield_id, related_specialization_id)).build();
	}


	/**
	 * Delete an existing SpecalVisitField entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{specalvisitfield_id}")
	@DELETE
	public void deleteSpecalVisitField(@PathParam("specalvisitfield_id") Integer specalvisitfield_id) {
		SpecalVisitField specalvisitfield = specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id);
		specalVisitFieldService.deleteSpecalVisitField(specalvisitfield);
	}

	/**
	 * Create a new Specialization entity
	 * 
	 */

	
	@Path("/{specalvisitfield_id}/specialization")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecalVisitFieldSpecialization(@PathParam("specalvisitfield_id") Integer specalvisitfield_id,
			Specialization specialization) {
		specalVisitFieldService.saveSpecalVisitFieldSpecialization(specalvisitfield_id, specialization);
		return Response.ok(specializationDAO.findSpecializationByPrimaryKey(specialization.getId())).build();
	}

	

	/**
	 * Create a new SpecalVisitField entity
	 * 
	 */

	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newSpecalVisitField( SpecalVisitField specalvisitfield) {
		specalVisitFieldService.saveSpecalVisitField(specalvisitfield);
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield.getId())).build();
	}

	/**
	 * Get Specialization entity by SpecalVisitField
	 * 
	 */

	@GET
	@Path("/{specalvisitfield_id}/specialization")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecalVisitFieldSpecialization(@PathParam("specalvisitfield_id") Integer specalvisitfield_id) {
		return Response.ok(specalVisitFieldDAO.findSpecalVisitFieldByPrimaryKey(specalvisitfield_id).getSpecialization()).build();
	}
	
}