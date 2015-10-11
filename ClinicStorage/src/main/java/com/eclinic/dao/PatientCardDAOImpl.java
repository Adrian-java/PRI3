package com.eclinic.dao;

import com.eclinic.domain.Patient;
import com.eclinic.domain.PatientCard;

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
 * DAO to manage PatientCard entities.
 * 
 */
@Repository("PatientCardDAO")
@Transactional
public class PatientCardDAOImpl extends AbstractJpaDao<PatientCard> implements
		PatientCardDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { PatientCard.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PatientCardDAOImpl
	 *
	 */
	public PatientCardDAOImpl() {
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
	 * JPQL Query - findPatientCardById
	 *
	 */
	@Transactional
	public PatientCard findPatientCardById(Integer id) throws DataAccessException {

		return findPatientCardById(id, -1, -1);
	}

	/**
	 * JPQL Query - findPatientCardById
	 *
	 */

	@Transactional
	public PatientCard findPatientCardById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPatientCardById", startResult, maxRows, id);
			return (com.eclinic.domain.PatientCard) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllPatientCards
	 *
	 */
	@Transactional
	public Set<PatientCard> findAllPatientCards() throws DataAccessException {

		return findAllPatientCards(-1, -1);
	}

	/**
	 * JPQL Query - findAllPatientCards
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientCard> findAllPatientCards(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPatientCards", startResult, maxRows);
		return new LinkedHashSet<PatientCard>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientCardByPrimaryKey
	 *
	 */
	@Transactional
	public PatientCard findPatientCardByPrimaryKey(Integer id) throws DataAccessException {

		return findPatientCardByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findPatientCardByPrimaryKey
	 *
	 */

	@Transactional
	public PatientCard findPatientCardByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPatientCardByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.PatientCard) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDateBefore
	 *
	 */
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDateBefore(java.util.Calendar registerDate) throws DataAccessException {

		return findPatientCardByRegisterDateBefore(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDateBefore(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientCardByRegisterDateBefore", startResult, maxRows, registerDate);
		return new LinkedHashSet<PatientCard>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDateAfter
	 *
	 */
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDateAfter(java.util.Calendar registerDate) throws DataAccessException {

		return findPatientCardByRegisterDateAfter(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDateAfter(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientCardByRegisterDateAfter", startResult, maxRows, registerDate);
		return new LinkedHashSet<PatientCard>(query.getResultList());
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDate
	 *
	 */
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDate(java.util.Calendar registerDate) throws DataAccessException {

		return findPatientCardByRegisterDate(registerDate, -1, -1);
	}

	/**
	 * JPQL Query - findPatientCardByRegisterDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<PatientCard> findPatientCardByRegisterDate(java.util.Calendar registerDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPatientCardByRegisterDate", startResult, maxRows, registerDate);
		return new LinkedHashSet<PatientCard>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(PatientCard entity) {
		return true;
	}

	@Transactional
	public PatientCard findPatientCardByPatientId(Patient id){
		try {
			Query query = createNamedQuery("findPatientCardByPatientId",-1,-1,id);
			return (com.eclinic.domain.PatientCard) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
}
