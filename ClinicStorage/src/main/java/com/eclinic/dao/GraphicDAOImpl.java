package com.eclinic.dao;

import com.eclinic.domain.Graphic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage Graphic entities.
 * 
 */
@Repository("GraphicDAO")
@Transactional
public class GraphicDAOImpl extends AbstractJpaDao<Graphic> implements
		GraphicDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Graphic.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new GraphicDAOImpl
	 *
	 */
	public GraphicDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findGraphicByPrimaryKey
	 *
	 */
	@Transactional
	public Graphic findGraphicByPrimaryKey(Integer id) throws DataAccessException {

		return findGraphicByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findGraphicByPrimaryKey
	 *
	 */

	@Transactional
	public Graphic findGraphicByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGraphicByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Graphic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllGraphics
	 *
	 */
	@Transactional
	public Set<Graphic> findAllGraphics() throws DataAccessException {

		return findAllGraphics(-1, -1);
	}

	/**
	 * JPQL Query - findAllGraphics
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Graphic> findAllGraphics(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllGraphics", startResult, maxRows);
		return new LinkedHashSet<Graphic>(query.getResultList());
	}

	/**
	 * JPQL Query - findGraphicByDayBefore
	 *
	 */
	@Transactional
	public Set<Graphic> findGraphicByDayBefore(java.util.Calendar day) throws DataAccessException {

		return findGraphicByDayBefore(day, -1, -1);
	}

	/**
	 * JPQL Query - findGraphicByDayBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Graphic> findGraphicByDayBefore(java.util.Calendar day, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGraphicByDayBefore", startResult, maxRows, day);
		return new LinkedHashSet<Graphic>(query.getResultList());
	}

	/**
	 * JPQL Query - findGraphicByDay
	 *
	 */
	@Transactional
	public Set<Graphic> findGraphicByDay(java.util.Calendar day) throws DataAccessException {

		return findGraphicByDay(day, -1, -1);
	}

	/**
	 * JPQL Query - findGraphicByDay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Graphic> findGraphicByDay(java.util.Calendar day, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGraphicByDay", startResult, maxRows, day);
		return new LinkedHashSet<Graphic>(query.getResultList());
	}

	/**
	 * JPQL Query - findGraphicById
	 *
	 */
	@Transactional
	public Graphic findGraphicById(Integer id) throws DataAccessException {

		return findGraphicById(id, -1, -1);
	}

	/**
	 * JPQL Query - findGraphicById
	 *
	 */

	@Transactional
	public Graphic findGraphicById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findGraphicById", startResult, maxRows, id);
			return (com.eclinic.domain.Graphic) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findGraphicByDayAfter
	 *
	 */
	@Transactional
	public Set<Graphic> findGraphicByDayAfter(java.util.Calendar day) throws DataAccessException {

		return findGraphicByDayAfter(day, -1, -1);
	}

	/**
	 * JPQL Query - findGraphicByDayAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Graphic> findGraphicByDayAfter(java.util.Calendar day, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findGraphicByDayAfter", startResult, maxRows, day);
		return new LinkedHashSet<Graphic>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Graphic entity) {
		return true;
	}
}
