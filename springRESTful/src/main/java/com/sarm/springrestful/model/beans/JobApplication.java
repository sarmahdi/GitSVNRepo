/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sarm
 */
@Entity
@Table(name = "APPLICATION")
public class JobApplication {
    
     @Id
    private Long applicationId;
    /**
     * ID of the job for which the application is made for
     */
    @NotNull
    @Column(name = "JOB_ID")
    private String jobId;
    
    
    /**
     * Valid values for Application type can be Contractor, Pull Time Permanent,
     * Part time
     */
    @NotNull
    @Column(name = "APP_TYPE")
    private String applicationType;
    
    @NotNull
    @Column(name = "DEPTCODE")
    private String department;
    
//    @NotNull
//    @Column(name = "APP_TYPE")
//    private String applicationType;
//    
    
    @OneToOne
    @JoinColumn(name="APPLICANT_ID", nullable=false)
    private JobApplicant applicant;
    
   @Embe
    
  
}
