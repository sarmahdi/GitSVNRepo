/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

/**
 *This is the entity for a resume. A resume is an attachment uploaded by an 
 * applicant.
 * @author sarm
 */
@Embeddable
public class ApplicantAttachment implements Serializable {
    
    @OneToOne
    @Column(name = "ATT_ID",nullable=false)
    private Attachment resume;
    
    @OneToOne
    @Column(name="APPLICANT_ID", nullable=false)
    private JobApplicant applicant;

    public Attachment getResume() {
        return resume;
    }

    public void setResume(Attachment resume) {
        this.resume = resume;
    }

    
    public JobApplicant getApplicant() {
        return applicant;
    }

    public void setApplicant(JobApplicant applicant) {
        this.applicant = applicant;
    }
    
    
    
}
