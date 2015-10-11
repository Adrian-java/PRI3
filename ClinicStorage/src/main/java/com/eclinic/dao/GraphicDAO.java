package com.eclinic.dao;

import com.eclinic.domain.Graphic;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Graphic entities.
 * 
 */
public interface GraphicDAO extends JpaDao<Graphic> {

	/**
	 * JPQL Query - findGraphicByPrimaryKey
	 *
	 */
	public Graphic findGraphicByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByPrimaryKey
	 *
	 */
	public Graphic findGraphicByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllGraphics
	 *
	 */
	public Set<Graphic> findAllGraphics() throws DataAccessException;

	/**
	 * JPQL Query - findAllGraphics
	 *
	 */
	public Set<Graphic> findAllGraphics(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDayBefore
	 *
	 */
	public Set<Graphic> findGraphicByDayBefore(java.util.Calendar day) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDayBefore
	 *
	 */
	public Set<Graphic> findGraphicByDayBefore(Calendar day, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDay
	 *
	 */
	public Set<Graphic> findGraphicByDay(java.util.Calendar day_1) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDay
	 *
	 */
	public Set<Graphic> findGraphicByDay(Calendar day_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicById
	 *
	 */
	public Graphic findGraphicById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicById
	 *
	 */
	public Graphic findGraphicById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDayAfter
	 *
	 */
	public Set<Graphic> findGraphicByDayAfter(java.util.Calendar day_2) throws DataAccessException;

	/**
	 * JPQL Query - findGraphicByDayAfter
	 *
	 */
	public Set<Graphic> findGraphicByDayAfter(Calendar day_2, int startResult, int maxRows) throws DataAccessException;

}