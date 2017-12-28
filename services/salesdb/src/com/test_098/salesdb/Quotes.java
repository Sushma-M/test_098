/*Copyright (c) 2015-2016 imaginea-com All Rights Reserved.
 This software is the confidential and proprietary information of imaginea-com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with imaginea-com*/
package com.test_098.salesdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Quotes generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`QUOTES`")
public class Quotes implements Serializable {

    private Integer id;
    private Integer leadId;
    private Date entryDate;
    private Integer repId;
    private Integer estimatedSale;
    private List<FollowUps> followUpses;
    private Leads leads;
    private Reps reps;
    private List<Sales> saleses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`LEAD_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getLeadId() {
        return this.leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    @Column(name = "`ENTRY_DATE`", nullable = true)
    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Column(name = "`REP_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getRepId() {
        return this.repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    @Column(name = "`ESTIMATED_SALE`", nullable = true, scale = 0, precision = 10)
    public Integer getEstimatedSale() {
        return this.estimatedSale;
    }

    public void setEstimatedSale(Integer estimatedSale) {
        this.estimatedSale = estimatedSale;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "quotes")
    public List<FollowUps> getFollowUpses() {
        return this.followUpses;
    }

    public void setFollowUpses(List<FollowUps> followUpses) {
        this.followUpses = followUpses;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`LEAD_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_QUOTES_LEAD_ID`"))
    public Leads getLeads() {
        return this.leads;
    }

    public void setLeads(Leads leads) {
        if(leads != null) {
            this.leadId = leads.getId();
        }

        this.leads = leads;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`REP_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_QUOTES_REP_ID`"))
    public Reps getReps() {
        return this.reps;
    }

    public void setReps(Reps reps) {
        if(reps != null) {
            this.repId = reps.getId();
        }

        this.reps = reps;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "quotes")
    public List<Sales> getSaleses() {
        return this.saleses;
    }

    public void setSaleses(List<Sales> saleses) {
        this.saleses = saleses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quotes)) return false;
        final Quotes quotes = (Quotes) o;
        return Objects.equals(getId(), quotes.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
