/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.adventureworks2012.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.test_098.adventureworks2012.ErrorLog;


/**
 * ServiceImpl object for domain model class ErrorLog.
 *
 * @see ErrorLog
 */
@Service("AdventureWorks2012.ErrorLogService")
@Validated
public class ErrorLogServiceImpl implements ErrorLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorLogServiceImpl.class);


    @Autowired
    @Qualifier("AdventureWorks2012.ErrorLogDao")
    private WMGenericDao<ErrorLog, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ErrorLog, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "AdventureWorks2012TransactionManager")
    @Override
	public ErrorLog create(ErrorLog errorLog) {
        LOGGER.debug("Creating a new ErrorLog with information: {}", errorLog);
        ErrorLog errorLogCreated = this.wmGenericDao.create(errorLog);
        return errorLogCreated;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
	@Override
	public ErrorLog getById(Integer errorlogId) throws EntityNotFoundException {
        LOGGER.debug("Finding ErrorLog by id: {}", errorlogId);
        ErrorLog errorLog = this.wmGenericDao.findById(errorlogId);
        if (errorLog == null){
            LOGGER.debug("No ErrorLog found with id: {}", errorlogId);
            throw new EntityNotFoundException(String.valueOf(errorlogId));
        }
        return errorLog;
    }

    @Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
	@Override
	public ErrorLog findById(Integer errorlogId) {
        LOGGER.debug("Finding ErrorLog by id: {}", errorlogId);
        return this.wmGenericDao.findById(errorlogId);
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "AdventureWorks2012TransactionManager")
	@Override
	public ErrorLog update(ErrorLog errorLog) throws EntityNotFoundException {
        LOGGER.debug("Updating ErrorLog with information: {}", errorLog);
        this.wmGenericDao.update(errorLog);

        Integer errorlogId = errorLog.getErrorLogId();

        return this.wmGenericDao.findById(errorlogId);
    }

    @Transactional(value = "AdventureWorks2012TransactionManager")
	@Override
	public ErrorLog delete(Integer errorlogId) throws EntityNotFoundException {
        LOGGER.debug("Deleting ErrorLog with id: {}", errorlogId);
        ErrorLog deleted = this.wmGenericDao.findById(errorlogId);
        if (deleted == null) {
            LOGGER.debug("No ErrorLog found with id: {}", errorlogId);
            throw new EntityNotFoundException(String.valueOf(errorlogId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

	@Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
	@Override
	public Page<ErrorLog> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all ErrorLogs");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
    @Override
    public Page<ErrorLog> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all ErrorLogs");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service AdventureWorks2012 for table ErrorLog to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "AdventureWorks2012TransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}
