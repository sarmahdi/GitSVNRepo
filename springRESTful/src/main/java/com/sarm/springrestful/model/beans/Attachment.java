/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 *This is an entity designed for any attachment. An attachment can be a resume, 
 * picture of an applicant, scans of documents, Offer Letter, Employment Letter, 
 * Resignation Letter, Termination Letter. 
 * @author sarm
 */
@Entity
@Table(name = "ATTACHMENT")
public class Attachment implements Serializable {
    
    @Id
    @Column(name = "ATT_ID")
    private Long id;
    
    @Column(name="ATT_SIZE")
    private long fileSize;
    
    @Column(name ="ATT_TYPE")
    private String fileType;
    
    @Lob
    @Column(name="ATT_FILE",length = 2147483647)
    private byte[] resumeFile;
    
    @Column(name ="ATT_TITLE")
    private String title;
    
    @Column(name="OWNER")
    private String ownerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getResumeFile() {
        return resumeFile;
    }

    public void setResumeFile(byte[] resumeFile) {
        this.resumeFile = resumeFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    
    
}
