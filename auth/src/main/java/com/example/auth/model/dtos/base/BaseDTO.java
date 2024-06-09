package com.example.auth.model.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO {
    protected UUID id;

    protected Timestamp createdAt;

    protected Timestamp modifiedAt;

    protected UUID createdBy;

    protected UUID modifiedBy;

}
