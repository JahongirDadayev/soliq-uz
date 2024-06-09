package com.example.billing.model.dtos.transaction;

import com.example.billing.model.dtos.base.BaseDTO;
import com.example.billing.model.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto extends BaseDTO {
    private String senderCardNumber;

    private String recipientCardNumber;

    private Double amount;

    private LocalDateTime transactionDate;

    private TransactionStatus status;

    private UUID serviceId;

    private UUID senderId;

    private UUID recipientId;

}
