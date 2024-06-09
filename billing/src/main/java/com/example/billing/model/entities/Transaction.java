package com.example.billing.model.entities;

import com.example.billing.model.entities.base.BaseEntity;
import com.example.billing.model.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transactions")
@Builder
public class Transaction extends BaseEntity {
    @Column(name = "sender_card_number", nullable = false)
    private String senderCardNumber;

    @Column(name = "recipient_card_number", nullable = false)
    private String recipientCardNumber;

    @Column(name = "amount", nullable = false)
    private Double amount = 0.0;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Column(name = "service_id", nullable = false)
    private UUID serviceId;

    @Column(name = "sender_id", nullable = false)
    private UUID senderId;

    @Column(name = "recipient_id", nullable = false)
    private UUID recipientId;

}
