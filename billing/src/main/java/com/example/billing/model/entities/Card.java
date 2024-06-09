package com.example.billing.model.entities;

import com.example.billing.model.entities.base.BaseEntity;
import com.example.billing.model.enums.CardStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cards")
@Builder
public class Card extends BaseEntity {
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    @Builder.Default
    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "holder_name", nullable = false)
    private String holderName;

    @Builder.Default
    @Column(name = "status", nullable = false)
    private CardStatus status = CardStatus.ACTIVE;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

}
