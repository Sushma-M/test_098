/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.adventureworks2012.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.test_098.adventureworks2012.EmployeePayHistory;
import com.test_098.adventureworks2012.EmployeePayHistoryId;
import com.test_098.adventureworks2012.service.EmployeePayHistoryService;


/**
 * Controller object for domain model class EmployeePayHistory.
 * @see EmployeePayHistory
 */
@RestController("AdventureWorks2012.EmployeePayHistoryController")
@Api(value = "EmployeePayHistoryController", description = "Exposes APIs to work with EmployeePayHistory resource.")
@RequestMapping("/AdventureWorks2012/EmployeePayHistory")
public class EmployeePayHistoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePayHistoryController.class);

    @Autowired
	@Qualifier("AdventureWorks2012.EmployeePayHistoryService")
	private EmployeePayHistoryService employeePayHistoryService;

	@ApiOperation(value = "Creates a new EmployeePayHistory instance.")
@RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public EmployeePayHistory createEmployeePayHistory(@RequestBody EmployeePayHistory employeePayHistory) {
		LOGGER.debug("Create EmployeePayHistory with information: {}" , employeePayHistory);

		employeePayHistory = employeePayHistoryService.create(employeePayHistory);
		LOGGER.debug("Created EmployeePayHistory with information: {}" , employeePayHistory);

	    return employeePayHistory;
	}

@ApiOperation(value = "Returns the EmployeePayHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EmployeePayHistory getEmployeePayHistory(@RequestParam("businessEntityId") Integer businessEntityId,@RequestParam("rateChangeDate") LocalDateTime rateChangeDate) throws EntityNotFoundException {

        EmployeePayHistoryId employeepayhistoryId = new EmployeePayHistoryId();
        employeepayhistoryId.setBusinessEntityId(businessEntityId);
        employeepayhistoryId.setRateChangeDate(rateChangeDate);

        LOGGER.debug("Getting EmployeePayHistory with id: {}" , employeepayhistoryId);
        EmployeePayHistory employeePayHistory = employeePayHistoryService.getById(employeepayhistoryId);
        LOGGER.debug("EmployeePayHistory details with id: {}" , employeePayHistory);

        return employeePayHistory;
    }



    @ApiOperation(value = "Updates the EmployeePayHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public EmployeePayHistory editEmployeePayHistory(@RequestParam("businessEntityId") Integer businessEntityId,@RequestParam("rateChangeDate") LocalDateTime rateChangeDate, @RequestBody EmployeePayHistory employeePayHistory) throws EntityNotFoundException {

        employeePayHistory.setBusinessEntityId(businessEntityId);
        employeePayHistory.setRateChangeDate(rateChangeDate);

        LOGGER.debug("EmployeePayHistory details with id is updated with: {}" , employeePayHistory);

        return employeePayHistoryService.update(employeePayHistory);
    }


    @ApiOperation(value = "Deletes the EmployeePayHistory instance associated with the given composite-id.")
    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteEmployeePayHistory(@RequestParam("businessEntityId") Integer businessEntityId,@RequestParam("rateChangeDate") LocalDateTime rateChangeDate) throws EntityNotFoundException {

        EmployeePayHistoryId employeepayhistoryId = new EmployeePayHistoryId();
        employeepayhistoryId.setBusinessEntityId(businessEntityId);
        employeepayhistoryId.setRateChangeDate(rateChangeDate);

        LOGGER.debug("Deleting EmployeePayHistory with id: {}" , employeepayhistoryId);
        EmployeePayHistory employeePayHistory = employeePayHistoryService.delete(employeepayhistoryId);

        return employeePayHistory != null;
    }


    /**
     * @deprecated Use {@link #findEmployeePayHistories(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of EmployeePayHistory instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeePayHistory> searchEmployeePayHistoriesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering EmployeePayHistories list");
        return employeePayHistoryService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of EmployeePayHistory instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeePayHistory> findEmployeePayHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeePayHistories list");
        return employeePayHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of EmployeePayHistory instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<EmployeePayHistory> filterEmployeePayHistories(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering EmployeePayHistories list");
        return employeePayHistoryService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportEmployeePayHistories(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return employeePayHistoryService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of EmployeePayHistory instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countEmployeePayHistories( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting EmployeePayHistories");
		return employeePayHistoryService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getEmployeePayHistoryAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return employeePayHistoryService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service EmployeePayHistoryService instance
	 */
	protected void setEmployeePayHistoryService(EmployeePayHistoryService service) {
		this.employeePayHistoryService = service;
	}

}

