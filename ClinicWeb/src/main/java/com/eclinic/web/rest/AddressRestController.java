package com.eclinic.web.rest;

import java.io.IOException;

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

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;
import com.eclinic.service.AddressService;

/**
 * Spring Rest controller that handles CRUD requests for Address entities
 * 
 */

@Path("/Address")
@Component("AddressRestController")
public class AddressRestController {

	/**
	 * DAO injected by Spring that manages Address entities
	 * 
	 */
	
	@Autowired
	private AddressDAO addressDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Address
	 * entities
	 * 
	 */
	@Autowired
	private AddressService addressService;

	
	public AddressRestController() {
	}
	
	/**
	 * Register custom, context-specific property editors
	 * 
	 *
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register
																				// static
																				// property
																				// editors.
		binder.registerCustomEditor(java.util.Calendar.class,
				new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(
				byte[].class,
				new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						false));
		binder.registerCustomEditor(Boolean.class,
				new org.skyway.spring.util.databinding.EnhancedBooleanEditor(
						true));
		binder.registerCustomEditor(java.math.BigDecimal.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class,
				new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class,
				new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Long.class, true));
		binder.registerCustomEditor(Double.class,
				new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(
						Double.class, true));
	}
	

	/**
	 * Select an existing Address entity
	 * 
	 */
	@GET
	@Path("/{address_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAddress(@PathParam("address_id") Integer address_id) {
		return Response.ok(addressDAO.findAddressByPrimaryKey(address_id)).build();
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@Path("/{address_id}/patients")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAddressPatients(@PathParam("address_id") Integer address_id,
			 Patient patient) {
		addressService.saveAddressPatients(address_id, patient);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patient.getId())).build();
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveAddress( Address address) {
		addressService.saveAddress(address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(address.getId())).build();
	}

	/**
	 * Show all Address entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAddresss() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(addressService.loadAddresss())).build();
	}

	/**
	 * Create a new Address entity
	 * 
	 */
	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newAddress( Address address) {
		Integer addedId = addressService.saveAddress(address);
		return Response.ok(addressDAO.findAddressByPrimaryKey(addedId)).build();
	}

	/**
	 * View an existing Patient entity
	 * 
	 */
	@GET
	@Path("/{address_id}/patients/{patient_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAddressPatients(@PathParam("address_id") Integer address_id,
			@PathParam("related_patients_id") Integer related_patients_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(
				related_patients_id, -1, -1);

		return Response.ok(patient).build();
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address_id}/patients/{patient_id}")
	public Response deleteAddressPatients(@PathParam("address_id") Integer address_id,
			@PathParam("related_patients_id") Integer related_patients_id) {
		return Response.ok(addressService.deleteAddressPatients(address_id, related_patients_id)).build();
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address_id}/patients")
	@PUT
	public Response saveAddressPatients(@PathParam("address_id") Integer address_id,
			 Patient patients) {
		addressService.saveAddressPatients(address_id, patients);
		return Response.ok(patientDAO.findPatientByPrimaryKey(patients.getId())).build();
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address_id}")
	@DELETE
	public void deleteAddress(@PathParam("address_id") Integer address_id) {
		Address address = addressDAO.findAddressByPrimaryKey(address_id);
		addressService.deleteAddress(address);
	}

	/**
	 * Show all Patient entities by Address
	 * 
	 */
	@GET
	@Path("/{address_id}/patients")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddressPatients(@PathParam("address_id") Integer address_id) {
		return Response.ok(addressDAO
				.findAddressByPrimaryKey(address_id).getPatients()).build();
	}

}