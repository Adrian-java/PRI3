package com.eclinic.service;

import com.eclinic.domain.Doctor;
import com.eclinic.domain.Graphic;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Graphic entities
 * 
 */
public interface GraphicService {

	/**
	 * Delete an existing Graphic entity
	 * 
	 */
	public void deleteGraphic(Graphic graphic);

	/**
	 * Delete an existing Doctor entity
	 * 
	 */
	public Graphic deleteGraphicDoctor(Integer graphic_id, Integer related_doctor_id);

	/**
	 * Save an existing Doctor entity
	 * 
	 */
	public Graphic saveGraphicDoctor(Integer id, Doctor related_doctor);

	/**
	 * Return all Graphic entity
	 * 
	 */
	public List<Graphic> findAllGraphics(Integer startResult, Integer maxRows);

	/**
	 */
	public Graphic findGraphicByPrimaryKey(Integer id_1);

	/**
	 * Return a count of all Graphic entity
	 * 
	 */
	public Integer countGraphics();

	/**
	 * Save an existing Graphic entity
	 * 
	 */
	public void saveGraphic(Graphic graphic_1);

	/**
	 * Load an existing Graphic entity
	 * 
	 */
	public Set<Graphic> loadGraphics();
}