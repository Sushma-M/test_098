/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.salesdb.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.test_098.salesdb.Sales;

/**
 * Service object for domain model class {@link Sales}.
 */
public interface SalesService {

    /**
     * Creates a new Sales. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on Sales if any.
     *
     * @param salesInstance Details of the Sales to be created; value cannot be null.
     * @return The newly created Sales.
     */
	Sales create(@Valid Sales salesInstance);


	/**
	 * Returns Sales by given id if exists.
	 *
	 * @param salesId The id of the Sales to get; value cannot be null.
	 * @return Sales associated with the given salesId.
     * @throws EntityNotFoundException If no Sales is found.
	 */
	Sales getById(Integer salesId) throws EntityNotFoundException;

    /**
	 * Find and return the Sales by given id if exists, returns null otherwise.
	 *
	 * @param salesId The id of the Sales to get; value cannot be null.
	 * @return Sales associated with the given salesId.
	 */
	Sales findById(Integer salesId);


	/**
	 * Updates the details of an existing Sales. It replaces all fields of the existing Sales with the given salesInstance.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on Sales if any.
     *
	 * @param salesInstance The details of the Sales to be updated; value cannot be null.
	 * @return The updated Sales.
	 * @throws EntityNotFoundException if no Sales is found with given input.
	 */
	Sales update(@Valid Sales salesInstance) throws EntityNotFoundException;

    /**
	 * Deletes an existing Sales with the given id.
	 *
	 * @param salesId The id of the Sales to be deleted; value cannot be null.
	 * @return The deleted Sales.
	 * @throws EntityNotFoundException if no Sales found with the given id.
	 */
	Sales delete(Integer salesId) throws EntityNotFoundException;

	/**
	 * Find all Sales matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sales.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<Sales> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all Sales matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching Sales.
     *
     * @see Pageable
     * @see Page
	 */
    Page<Sales> findAll(String query, Pageable pageable);

    /**
	 * Exports all Sales matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Sales in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the Sales.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

