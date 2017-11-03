/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.adventureworks2012;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class EmployeeDepartmentHistoryId implements Serializable {

    private Integer businessEntityId;
    private Short departmentId;
    private Short shiftId;
    private Date startDate;

    public Integer getBusinessEntityId() {
        return this.businessEntityId;
    }

    public void setBusinessEntityId(Integer businessEntityId) {
        this.businessEntityId = businessEntityId;
    }

    public Short getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Short departmentId) {
        this.departmentId = departmentId;
    }

    public Short getShiftId() {
        return this.shiftId;
    }

    public void setShiftId(Short shiftId) {
        this.shiftId = shiftId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDepartmentHistory)) return false;
        final EmployeeDepartmentHistory employeeDepartmentHistory = (EmployeeDepartmentHistory) o;
        return Objects.equals(getBusinessEntityId(), employeeDepartmentHistory.getBusinessEntityId()) &&
                Objects.equals(getDepartmentId(), employeeDepartmentHistory.getDepartmentId()) &&
                Objects.equals(getShiftId(), employeeDepartmentHistory.getShiftId()) &&
                Objects.equals(getStartDate(), employeeDepartmentHistory.getStartDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusinessEntityId(),
                getDepartmentId(),
                getShiftId(),
                getStartDate());
    }
}