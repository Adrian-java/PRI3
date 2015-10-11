package com.eclinic.service;

import com.eclinic.dao.DoctorDAO;
import com.eclinic.dao.PatientDAO;
import com.eclinic.dao.RecipeDAO;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Recipe entities
 * 
 */

@Service("RecipeService")
@Transactional
public class RecipeServiceImpl implements RecipeService {

	/**
	 * DAO injected by Spring that manages Doctor entities
	 * 
	 */
	@Autowired
	private DoctorDAO doctorDAO;

	/**
	 * DAO injected by Spring that manages Patient entities
	 * 
	 */
	@Autowired
	private PatientDAO patientDAO;

	/**
	 * DAO injected by Spring that manages Recipe entities
	 * 
	 */
	@Autowired
	private RecipeDAO recipeDAO;

	/**
	 * Instantiates a new RecipeServiceImpl.
	 *
	 */
	public RecipeServiceImpl() {
	}

	/**
	 * Return all Recipe entity
	 * 
	 */
	@Transactional
	public List<Recipe> findAllRecipes(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Recipe>(recipeDAO.findAllRecipes(startResult, maxRows));
	}

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	@Transactional
	public void deleteRecipe(Recipe recipe) {
		recipeDAO.remove(recipe);
		recipeDAO.flush();
	}

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	@Transactional
	public void saveRecipe(Recipe recipe) {
		Recipe existingRecipe = recipeDAO.findRecipeByPrimaryKey(recipe.getIdr());

		if (existingRecipe != null) {
			if (existingRecipe != recipe) {
				existingRecipe.setIdr(recipe.getIdr());
				existingRecipe.setDate(recipe.getDate());
				existingRecipe.setDrug(recipe.getDrug());
			}
			recipe = recipeDAO.store(existingRecipe);
		} else {
			recipe = recipeDAO.store(recipe);
		}
		recipeDAO.flush();
	}

	/**
	 */
	@Transactional
	public Recipe findRecipeByPrimaryKey(Integer idr) {
		return recipeDAO.findRecipeByPrimaryKey(idr);
	}

	/**
	 * Save an existing Patient entity
	 * 
	 */
	@Transactional
	public Recipe saveRecipePatient(Integer idr, Patient related_patient) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(idr, -1, -1);
		Patient existingpatient = patientDAO.findPatientByPrimaryKey(related_patient.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpatient != null) {
			existingpatient.setId(related_patient.getId());
			existingpatient.setName(related_patient.getName());
			existingpatient.setSurname(related_patient.getSurname());
			existingpatient.setDateOfBirth(related_patient.getDateOfBirth());
			existingpatient.setEMail(related_patient.getEMail());
			existingpatient.setPhoneNr(related_patient.getPhoneNr());
			existingpatient.setConfirmed(related_patient.getConfirmed());
			related_patient = existingpatient;
		}

		recipe.setPatient(related_patient);
		related_patient.getRecipes().add(recipe);
		recipe = recipeDAO.store(recipe);
		recipeDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		return recipe;
	}

	/**
	 * Load an existing Recipe entity
	 * 
	 */
	@Transactional
	public Set<Recipe> loadRecipes() {
		return recipeDAO.findAllRecipes();
	}

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	@Transactional
	public Recipe saveRecipeDoctor(Integer idr, Doctor related_doctor) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(idr, -1, -1);
		Doctor existingdoctor = doctorDAO.findDoctorByPrimaryKey(related_doctor.getId());

		// copy into the existing record to preserve existing relationships
		if (existingdoctor != null) {
			existingdoctor.setId(related_doctor.getId());
			existingdoctor.setName(related_doctor.getName());
			existingdoctor.setSurname(related_doctor.getSurname());
			related_doctor = existingdoctor;
		} else {
			related_doctor = doctorDAO.store(related_doctor);
			doctorDAO.flush();
		}

		recipe.setDoctor(related_doctor);
		related_doctor.getRecipes().add(recipe);
		recipe = recipeDAO.store(recipe);
		recipeDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		return recipe;
	}

	/**
	 * Return a count of all Recipe entity
	 * 
	 */
	@Transactional
	public Integer countRecipes() {
		return ((Long) recipeDAO.createQuerySingleResult("select count(o) from Recipe o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	@Transactional
	public Recipe deleteRecipeDoctor(Integer recipe_idr, Integer related_doctor_id) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipe_idr, -1, -1);
		Doctor related_doctor = doctorDAO.findDoctorByPrimaryKey(related_doctor_id, -1, -1);

		recipe.setDoctor(null);
		related_doctor.getRecipes().remove(recipe);
		recipe = recipeDAO.store(recipe);
		recipeDAO.flush();

		related_doctor = doctorDAO.store(related_doctor);
		doctorDAO.flush();

		doctorDAO.remove(related_doctor);
		doctorDAO.flush();

		return recipe;
	}

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	@Transactional
	public Recipe deleteRecipePatient(Integer recipe_idr, Integer related_patient_id) {
		Recipe recipe = recipeDAO.findRecipeByPrimaryKey(recipe_idr, -1, -1);
		Patient related_patient = patientDAO.findPatientByPrimaryKey(related_patient_id, -1, -1);

		recipe.setPatient(null);
		related_patient.getRecipes().remove(recipe);
		recipe = recipeDAO.store(recipe);
		recipeDAO.flush();

		related_patient = patientDAO.store(related_patient);
		patientDAO.flush();

		patientDAO.remove(related_patient);
		patientDAO.flush();

		return recipe;
	}
}
