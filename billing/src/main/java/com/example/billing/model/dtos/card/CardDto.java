package com.example.billing.model.dtos.card;

import com.example.billing.model.dtos.base.BaseDTO;
import com.example.billing.model.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto extends BaseDTO {
    private Long customerId;

    private String number;

    private LocalDate issueDate;

    private LocalDate expireDate;

    private Double balance;

    private String holderName;

    private CardStatus status;
}
