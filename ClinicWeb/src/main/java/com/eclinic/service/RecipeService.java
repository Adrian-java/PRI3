package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Patient;
import com.eclinic.domain.Recipe;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Recipe entities
 * 
 */
public interface RecipeService {

	/**
	 * Return all Recipe entity
	 * 
	 */
	public List<Recipe> findAllRecipes(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Recipe entity
	 * 
	 */
	public void deleteRecipe(Recipe recipe);

	/**
	 * Save an existing Recipe entity
	 * 
	 */
	public void saveRecipe(Recipe recipe_1);

	/**
	 */
	public Recipe findRecipeByPrimaryKey(Integer idr);

	/**
	 * Save an existing Patient entity
	 * 
	 */
	public Recipe saveRecipePatient(Integer idr_1, Patient related_patient);

	/**
	 * Load an existing Recipe entity
	 * 
	 */
	public Set<Recipe> loadRecipes();

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Recipe saveRecipeDoctor(Integer idr_2, Doctor related_doctor);

	/**
	 * Return a count of all Recipe entity
	 * 
	 */
	public Integer countRecipes();

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Recipe deleteRecipeDoctor(Integer recipe_idr, Integer related_doctor_id);

	/**
	 * Delete an existing Patient entity
	 * 
	 */
	public Recipe deleteRecipePatient(Integer recipe_idr_1, Integer related_patient_id);
}