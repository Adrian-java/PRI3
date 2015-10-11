package com.eclinic.dao;

import com.eclinic.domain.Doctor;

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
 * DAO to manage Doctor entities.
 * 
 */
@Repository("DoctorDAO")
@Transactional
public class DoctorDAOImpl extends AbstractJpaDao<Doctor> implements DoctorDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Doctor.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DoctorDAOImpl
	 *
	 */
	public DoctorDAOImpl() {
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
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */
	@Transactional
	public Set<Doctor> findDoctorBySurnameContaining(String surname) throws DataAccessException {

		return findDoctorBySurnameContaining(surname, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorBySurnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Doctor> findDoctorBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorBySurnameContaining", startResult, maxRows, surname);
		return new LinkedHashSet<Doctor>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */
	@Transactional
	public Set<Doctor> findDoctorBySurname(String surname) throws DataAccessException {

		return findDoctorBySurname(surname, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorBySurname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Doctor> findDoctorBySurname(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorBySurname", startResult, maxRows, surname);
		return new LinkedHashSet<Doctor>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */
	@Transactional
	public Set<Doctor> findDoctorByName(String name) throws DataAccessException {

		return findDoctorByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Doctor> findDoctorByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorByName", startResult, maxRows, name);
		return new LinkedHashSet<Doctor>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */
	@Transactional
	public Set<Doctor> findAllDoctors() throws DataAccessException {

		return findAllDoctors(-1, -1);
	}

	/**
	 * JPQL Query - findAllDoctors
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Doctor> findAllDoctors(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllDoctors", startResult, maxRows);
		return new LinkedHashSet<Doctor>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */
	@Transactional
	public Set<Doctor> findDoctorByNameContaining(String name) throws DataAccessException {

		return findDoctorByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Doctor> findDoctorByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDoctorByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Doctor>(query.getResultList());
	}

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */
	@Transactional
	public Doctor findDoctorByPrimaryKey(Integer id) throws DataAccessException {

		return findDoctorByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorByPrimaryKey
	 *
	 */

	@Transactional
	public Doctor findDoctorByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDoctorByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Doctor) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findDoctorById
	 *
	 */
	@Transactional
	public Doctor findDoctorById(Integer id) throws DataAccessException {

		return findDoctorById(id, -1, -1);
	}

	/**
	 * JPQL Query - findDoctorById
	 *
	 */

	@Transactional
	public Doctor findDoctorById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDoctorById", startResult, maxRows, id);
			return (com.eclinic.domain.Doctor) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Doctor entity) {
		return true;
	}
}
