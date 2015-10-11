package com.eclinic.web;

import com.eclinic.dao.AddressDAO;
import com.eclinic.dao.PatientDAO;

import com.eclinic.domain.Address;
import com.eclinic.domain.Patient;

import com.eclinic.service.AddressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for Address entities
 * 
 */

@Controller("AddressController")
public class AddressController {

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
	 * Service injected by Spring that provides CRUD operations for Address entities
	 * 
	 */
	@Autowired
	private AddressService addressService;

	/**
	 * View an existing Patient entity
	 * 
	 */
	@RequestMapping("/selectAddressPatients")
	public ModelAndView selectAddressPatients(@RequestParam Integer address_id, @RequestParam Integer patients_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patients_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("address_id", address_id);
		mav.addObject("patient", patient);
		mav.setViewName("address/patients/viewPatients.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Address entities
	 * 
	 */
	public String indexAddress() {
		return "redirect:/indexAddress";
	}

	/**
	 * Create a new Patient entity
	 * 
	 */
	@RequestMapping("/newAddressPatients")
	public ModelAndView newAddressPatients(@RequestParam Integer address_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("address_id", address_id);
		mav.addObject("patient", new Patient());
		mav.addObject("newFlag", true);
		mav.setViewName("address/patients/editPatients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Patient entity
	 * 
	 */
	@RequestMapping("/editAddressPatients")
	public ModelAndView editAddressPatients(@RequestParam Integer address_id, @RequestParam Integer patients_id) {
		Patient patient = patientDAO.findPatientByPrimaryKey(patients_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("address_id", address_id);
		mav.addObject("patient", patient);
		mav.setViewName("address/patients/editPatients.jsp");

		return mav;
	}

	/**
	 * Select the Address entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAddress")
	public ModelAndView confirmDeleteAddress(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", addressDAO.findAddressByPrimaryKey(idKey));
		mav.setViewName("address/deleteAddress.jsp");

		return mav;
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
	 * Delete an existing Patient entity
	 * 
	 */
	@RequestMapping("/deleteAddressPatients")
	public ModelAndView deleteAddressPatients(@RequestParam Integer address_id, @RequestParam Integer related_patients_id) {
		ModelAndView mav = new ModelAndView();

		Address address = addressService.deleteAddressPatients(address_id, related_patients_id);

		mav.addObject("address_id", address_id);
		mav.addObject("address", address);
		mav.setViewName("address/viewAddress.jsp");

		return mav;
	}

	/**
	 * Save an existing Address entity
	 * 
	 */
	@RequestMapping("/saveAddress")
	public String saveAddress(@ModelAttribute Address address) {
		addressService.saveAddress(address);
		return "forward:/indexAddress";
	}

	/**
	 * Show all Address entities
	 * 
	 */
	@RequestMapping("/indexAddress")
	public ModelAndView listAddresss() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("addresss", addressService.loadAddresss());

		mav.setViewName("address/listAddresss.jsp");

		return mav;
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@RequestMapping("/saveAddressPatients")
	public ModelAndView saveAddressPatients(@RequestParam Integer address_id, @ModelAttribute Patient patients) {
		Address parent_address = addressService.saveAddressPatients(address_id, patients);

		ModelAndView mav = new ModelAndView();
		mav.addObject("address_id", address_id);
		mav.addObject("address", parent_address);
		mav.setViewName("address/viewAddress.jsp");

		return mav;
	}

	/**
	 * Select the child Patient entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAddressPatients")
	public ModelAndView confirmDeleteAddressPatients(@RequestParam Integer address_id, @RequestParam Integer related_patients_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("patient", patientDAO.findPatientByPrimaryKey(related_patients_id));
		mav.addObject("address_id", address_id);
		mav.setViewName("address/patients/deletePatients.jsp");

		return mav;
	}

	/**
	 * Edit an existing Address entity
	 * 
	 */
	@RequestMapping("/editAddress")
	public ModelAndView editAddress(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", addressDAO.findAddressByPrimaryKey(idKey));
		mav.setViewName("address/editAddress.jsp");

		return mav;
	}

	/**
	 * Delete an existing Address entity
	 * 
	 */
	@RequestMapping("/deleteAddress")
	public String deleteAddress(@RequestParam Integer idKey) {
		Address address = addressDAO.findAddressByPrimaryKey(idKey);
		addressService.deleteAddress(address);
		return "forward:/indexAddress";
	}

	/**
	 * Show all Patient entities by Address
	 * 
	 */
	@RequestMapping("/listAddressPatients")
	public ModelAndView listAddressPatients(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", addressDAO.findAddressByPrimaryKey(idKey));
		mav.setViewName("address/patients/listPatients.jsp");

		return mav;
	}

	/**
	 * Select an existing Address entity
	 * 
	 */
	@RequestMapping("/selectAddress")
	public ModelAndView selectAddress(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", addressDAO.findAddressByPrimaryKey(idKey));
		mav.setViewName("address/viewAddress.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/addressController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new Address entity
	 * 
	 */
	@RequestMapping("/newAddress")
	public ModelAndView newAddress() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("address", new Address());
		mav.addObject("newFlag", true);
		mav.setViewName("address/editAddress.jsp");

		return mav;
	}
}