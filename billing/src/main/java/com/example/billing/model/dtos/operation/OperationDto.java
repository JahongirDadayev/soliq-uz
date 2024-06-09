package com.example.billing.model.dtos.operation;

import com.example.billing.model.dtos.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationDto extends BaseDTO {
    private String name;

    private String description;

    private Double feeAmount;

}
