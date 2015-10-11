package com.eclinic.web.rest;

import java.io.IOException;

import com.eclinic.dao.ModuleDAO;
import com.eclinic.dao.PermissionDAO;
import com.eclinic.domain.Module;
import com.eclinic.domain.Permission;
import com.eclinic.service.ModuleService;




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
 * Spring Rest controller that handles CRUD requests for Module entities
 * 
 */
@Path("/Module")
@Component("ModuleRestController")
public class ModuleRestController {

	/**
	 * DAO injected by Spring that manages Module entities
	 * 
	 */
	@Autowired
	private ModuleDAO moduleDAO;

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Module entities
	 * 
	 */
	@Autowired
	private ModuleService moduleService;

	
	public ModuleRestController() {
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
	 * Save an existing Module entity
	 * 
	 */

	

	@PUT
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveModule(Module module) {
		moduleService.saveModule(module);
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module.getId())).build();
	}


	/**
	 * Save an existing Permission entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{module_id}/permissions")
	@PUT
	public Response saveModulePermissions(@PathParam("module_id") Integer module_id,
			Permission permissions) {
		moduleService.saveModulePermissions(module_id, permissions);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permissions.getId())).build();
	}

	/**
	 * View an existing Permission entity
	 * 
	 */

	
	@GET
	@Path("/{module_id}/permissions/{permission_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadModulePermissions(@PathParam("module_id") Integer module_id,
			@PathParam("related_permissions_id") Integer related_permissions_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permissions_id, -1, -1);
		return Response.ok(permission).build();
	}

	/**
	 * Show all Module entities
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * 
	 */

	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listModules() throws JsonGenerationException, JsonMappingException, IOException {
		return  Response.ok(new ObjectMapper().writeValueAsString(moduleService.loadModules())).build();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */

	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{module_id}/permissions/{permission_id}")
	public Response deleteModulePermissions(@PathParam("module_id") Integer module_id,
			@PathParam("related_permissions_id") Integer related_permissions_id) {
		return Response.ok(moduleService.deleteModulePermissions(module_id, related_permissions_id)).build();
	}

	/**
	 * Show all Permission entities by Module
	 * 
	 */

	
	@GET
	@Path("/{module_id}/permissions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getModulePermissions(@PathParam("module_id") Integer module_id) {
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module_id).getPermissions()).build();
	}

	/**
	 * Select an existing Module entity
	 * 
	 */

	
	@GET
	@Path("/{module_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadModule(@PathParam("module_id") Integer module_id) {
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module_id)).build();
	}

	

	/**
	 * Create a new Module entity
	 * 
	 */

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response newModule( Module module) {
		moduleService.saveModule(module);
		return Response.ok(moduleDAO.findModuleByPrimaryKey(module.getId())).build();
	}

	/**
	 * Delete an existing Module entity
	 * 
	 */

	
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{module_id}")
	@DELETE
	public void deleteModule(@PathParam("module_id") Integer module_id) {
		Module module = moduleDAO.findModuleByPrimaryKey(module_id);
		moduleService.deleteModule(module);
	}

	/**
	 * Create a new Permission entity
	 * 
	 */

	
	@Path("/{module_id}/permissions")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response newModulePermissions(@PathParam("module_id") Integer module_id, Permission permission) {
		moduleService.saveModulePermissions(module_id, permission);
		return Response.ok(permissionDAO.findPermissionByPrimaryKey(permission.getId())).build();
	}
}