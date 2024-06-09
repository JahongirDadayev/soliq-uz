package com.example.user.model.dtos.base;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseDTO {
    protected UUID id;

    protected Timestamp createdAt;

    protected Timestamp modifiedAt;

    protected UUID createdBy;

    protected UUID modifiedBy;

}
