package com.example.jpa.dao;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zyd
 * @date 2019/04/04
 */
@Data
@MappedSuperclass
class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "id", strategy = "uuid")
    @GeneratedValue(generator = "id")
    @Column(length = 32)
    private String id;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date updatedAt;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreatedAt(now);
        setUpdatedAt(now);
    }
}
