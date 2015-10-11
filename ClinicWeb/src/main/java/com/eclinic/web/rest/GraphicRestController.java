package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.GraphicDAO;
import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;
import com.eclinic.service.GraphicService;

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
 * Spring Rest controller that handles CRUD requests for Graphic entities
 * 
 */
@Path("/Graphic")
@Component("GraphicRestController")
public class GraphicRestController {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Graphic entities
	 * 
	 */
	@Autowired
	private GraphicDAO graphicDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Graphic entities
	 * 
	 */
	@Autowired
	private GraphicService graphicService;

	public GraphicRestController() {
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
	 * Create a new Doctor entity
	 * 
	 */
	
	@Path("/{graphic_id}/doctor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newGraphicDoctor(@PathParam("graphic_id") Integer graphic_id,
			Doctor doctor) {
		graphicService.saveGraphicDoctor(graphic_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}


	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{graphic_id}")
	@DELETE
	public void deleteGraphic(@PathParam("graphic_id") Integer graphic_id) {
		Graphic graphic = graphicDAO.findGraphicByPrimaryKey(graphic_id);
		graphicService.deleteGraphic(graphic);
	}

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	
	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGraphic(Graphic graphic) {
		graphicService.saveGraphic(graphic);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic.getId())).build();
	}

	/**
	 * Show all Graphic entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGraphics() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(graphicService.loadGraphics())).build();
	}

	/**
	 * View an existing Doctor entity
	 * 
	 */
	
	@GET
	@Path("/{graphic_id}/doctor/{doctor_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadGraphicDoctor(@PathParam("graphic_id") Integer graphic_id,
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
	@Path("/{graphic_id}/doctor/{doctor_id}")
	public Response deleteDoctorSickLeaves(@PathParam("graphic_id") Integer graphic_id,
			@PathParam("related_doctor_id") Integer related_doctor_id) {
		return Response.ok(graphicService.deleteGraphicDoctor(graphic_id, related_doctor_id)).build();
	}
	/**
	 * Get Doctor entity by Graphic
	 * 
	 */
	@GET
	@Path("/{graphic_id}/doctor")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGraphicDoctor(@PathParam("graphic_id") Integer graphic_id) {
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic_id).getDoctor()).build();
	}

	/**
	 * Create a new Graphic entity
	 * 
	 */
	
	
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newGraphic( Graphic graphic) {
		graphicService.saveGraphic(graphic);
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic.getId())).build();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{graphic_id}/doctor")
	@PUT
	public Response saveGraphicDoctor(@PathParam("graphic_id") Integer graphic_id,
			Doctor doctor) {
		graphicService.saveGraphicDoctor(graphic_id, doctor);
		return Response.ok(doctorDAO.findDoctorByPrimaryKey(doctor.getId())).build();
	}

	/**
	 * Select an existing Graphic entity
	 * 
	 */

	
	@GET
	@Path("/{graphic_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadGraphic(@PathParam("graphic_id") Integer graphic_id) {
		return Response.ok(graphicDAO.findGraphicByPrimaryKey(graphic_id)).build();
	}
}