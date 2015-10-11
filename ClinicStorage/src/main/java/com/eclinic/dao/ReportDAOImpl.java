package com.eclinic.dao;

import com.eclinic.domain.Report;

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
 * DAO to manage Report entities.
 * 
 */
@Repository("ReportDAO")
@Transactional
public class ReportDAOImpl extends AbstractJpaDao<Report> implements ReportDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Report.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql1
	 *
	 */
	@PersistenceContext(unitName = "mysql1")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ReportDAOImpl
	 *
	 */
	public ReportDAOImpl() {
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
	 * JPQL Query - findReportByDateTo
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateTo(java.util.Calendar dateTo) throws DataAccessException {

		return findReportByDateTo(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateTo
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateTo(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateTo", startResult, maxRows, dateTo);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByDateFromAfter
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateFromAfter(java.util.Calendar dateFrom) throws DataAccessException {

		return findReportByDateFromAfter(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateFromAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateFromAfter(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateFromAfter", startResult, maxRows, dateFrom);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByDateFrom
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateFrom(java.util.Calendar dateFrom) throws DataAccessException {

		return findReportByDateFrom(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateFrom
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateFrom(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateFrom", startResult, maxRows, dateFrom);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByDescription
	 *
	 */
	@Transactional
	public Set<Report> findReportByDescription(String description) throws DataAccessException {

		return findReportByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByPrimaryKey
	 *
	 */
	@Transactional
	public Report findReportByPrimaryKey(Integer id) throws DataAccessException {

		return findReportByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findReportByPrimaryKey
	 *
	 */

	@Transactional
	public Report findReportByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReportByPrimaryKey", startResult, maxRows, id);
			return (com.eclinic.domain.Report) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReportByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Report> findReportByDescriptionContaining(String description) throws DataAccessException {

		return findReportByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByDateToBefore
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateToBefore(java.util.Calendar dateTo) throws DataAccessException {

		return findReportByDateToBefore(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateToBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateToBefore(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateToBefore", startResult, maxRows, dateTo);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllReports
	 *
	 */
	@Transactional
	public Set<Report> findAllReports() throws DataAccessException {

		return findAllReports(-1, -1);
	}

	/**
	 * JPQL Query - findAllReports
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findAllReports(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllReports", startResult, maxRows);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportByDateToAfter
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateToAfter(java.util.Calendar dateTo) throws DataAccessException {

		return findReportByDateToAfter(dateTo, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateToAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateToAfter(java.util.Calendar dateTo, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateToAfter", startResult, maxRows, dateTo);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * JPQL Query - findReportById
	 *
	 */
	@Transactional
	public Report findReportById(Integer id) throws DataAccessException {

		return findReportById(id, -1, -1);
	}

	/**
	 * JPQL Query - findReportById
	 *
	 */

	@Transactional
	public Report findReportById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findReportById", startResult, maxRows, id);
			return (com.eclinic.domain.Report) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findReportByDateFromBefore
	 *
	 */
	@Transactional
	public Set<Report> findReportByDateFromBefore(java.util.Calendar dateFrom) throws DataAccessException {

		return findReportByDateFromBefore(dateFrom, -1, -1);
	}

	/**
	 * JPQL Query - findReportByDateFromBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Report> findReportByDateFromBefore(java.util.Calendar dateFrom, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findReportByDateFromBefore", startResult, maxRows, dateFrom);
		return new LinkedHashSet<Report>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Report entity) {
		return true;
	}
}
