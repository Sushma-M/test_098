/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.salesdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import com.test_098.salesdb.Reps;

/**
 * Specifies methods used to obtain and modify Reps related information
 * which is stored in the database.
 */
@Repository("salesdb.RepsDao")
public class RepsDao extends WMGenericDaoImpl<Reps, Integer> {

    @Autowired
    @Qualifier("salesdbTemplate")
    private HibernateTemplate template;

    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

