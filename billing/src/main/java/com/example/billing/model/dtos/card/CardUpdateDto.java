package com.example.billing.model.dtos.card;

import com.example.billing.model.dtos.base.BaseUpdateDto;
import com.example.billing.model.enums.CardStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CardUpdateDto implements BaseUpdateDto {
    @NotNull
    private Long customerId;

    @NotNull
    private String number;

    @NotNull
    private LocalDate issueDate;

    @NotNull
    private LocalDate expireDate;

    @NotNull
    private String holderName;

    @NotNull
    private CardStatus status;

}
