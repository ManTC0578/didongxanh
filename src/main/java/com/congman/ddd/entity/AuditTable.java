package com.congman.ddd.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class AuditTable implements Serializable {
    private int activeFlag;
    @CreationTimestamp
    private Date createDate;

    @UpdateTimestamp
    private Date updateDate;
}
