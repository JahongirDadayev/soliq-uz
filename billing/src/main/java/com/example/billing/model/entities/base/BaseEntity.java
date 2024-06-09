package com.example.billing.model.entities.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @UuidGenerator
    @Column(unique = true)
    protected UUID id;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    protected Timestamp modifiedAt;

    @CreatedBy
    @Column(name = "created_by", nullable = false, updatable = false)
    protected UUID createdBy;

    @LastModifiedBy
    @Column(name = "modified_by")
    private UUID modifiedBy;

}
