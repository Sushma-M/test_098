/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/

package com.test_098.adventureworks2012.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

@Service
public class AdventureWorks2012ProcedureExecutorServiceImpl implements AdventureWorks2012ProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdventureWorks2012ProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("AdventureWorks2012WMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;


}


