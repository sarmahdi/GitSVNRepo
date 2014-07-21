/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sarm
 */
@Entity
@Table(name = "Applicant")
public class JobApplicant {
    @Id
    @Column(name= "APPLICANT_ID")
    private Long id;

    @NotNull
    @Column(name = "NUMBER")
    private String number;
    

    /**
     * Valid values for work status can be Citizen, Permanent Resident,
     * Temporary Work Visa
     */
    @NotNull
    @Column(name = "ELIGIBILITY")
    private String eligibility;

    /**
     * Valid values can be TFN, Visa number
     */
    @NotNull
    @Column(name = "TAX_ID")
    private String taxID;

    @NotNull
    @Column(name = "CONTACT")
    private String contact;

   
    @NotNull
    @Column(name = "ADDRESS")
    private String address;
    
    

}
