package com.eclinic.dao;

import com.eclinic.domain.Receptionist;

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
 * DAO to manage Receptionist entities.
 * 
 */
@Repository("ReceptionistDAO")
@Transactional
public class ReceptionistDAOImpl extends AbstractJpaDao<Receptionist> implements
		ReceptionistDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Receptionist.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ReceptionistDAOImpl
	 *
	 */
	public ReceptionistDAOImpl() {
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
	 * JPQL Query - findAllReceptionists
	 *
	 */
	@Transactional
	public Set<Receptionist> findAllReceptionists() throws DataAccessException {

		return findAllReceptionists(-1, -1);
	}

	/**
	 * JPQL Query - findAllReceptionists
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findAllReceptionists(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllReceptionists", startResult, maxRows);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */
	@Transactional
	public Receptionist findReceptionistById(Integer id) throws DataAccessException {

		return findReceptionistById(id, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistById
	 *
	 */

	@Transactional
	public Receptionist findReceptionistById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReceptionistById", startResult, maxRows, id);
			return (com.eclinic.domain.Receptionist) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistBySurname(String surname) throws DataAccessException {

		return findReceptionistBySurname(surname, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistBySurname
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistBySurname(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistBySurname", startResult, maxRows, surname);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistByPhoneNr(String phoneNr) throws DataAccessException {

		return findReceptionistByPhoneNr(phoneNr, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistByPhoneNr
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistByPhoneNr(String phoneNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistByPhoneNr", startResult, maxRows, phoneNr);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistByName(String name) throws DataAccessException {

		return findReceptionistByName(name, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistByName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistByName(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistByName", startResult, maxRows, name);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistByNameContaining(String name) throws DataAccessException {

		return findReceptionistByNameContaining(name, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistByNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistByNameContaining(String name, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistByNameContaining", startResult, maxRows, name);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistByPhoneNrContaining(String phoneNr) throws DataAccessException {

		return findReceptionistByPhoneNrContaining(phoneNr, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistByPhoneNrContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistByPhoneNrContaining(String phoneNr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistByPhoneNrContaining", startResult, maxRows, phoneNr);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */
	@Transactional
	public Set<Receptionist> findReceptionistBySurnameContaining(String surname) throws DataAccessException {

		return findReceptionistBySurnameContaining(surname, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistBySurnameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Receptionist> findReceptionistBySurnameContaining(String surname, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReceptionistBySurnameContaining", startResult, maxRows, surname);
		return new LinkedHashSet<Receptionist>(query.getResultList());
	}

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */
	@Transactional
	public Receptionist findReceptionistByPrimaryKey(Integer id) throws DataAccessException {

		return findReceptionistByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findReceptionistByPrimaryKey
	 *
	 */

	@Transactional
	public Receptionist findReceptionistByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReceptionistByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Receptionist) query.getSingleResult();
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
	public boolean canBeMerged(Receptionist entity) {
		return true;
	}
}
