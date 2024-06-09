package com.example.billing.model.dtos.card;

import com.example.billing.model.dtos.base.BaseCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateDto implements BaseCreateDto {
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

}
