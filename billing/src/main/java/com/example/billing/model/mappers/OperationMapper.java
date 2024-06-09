package com.example.billing.model.mappers;

import com.example.billing.model.dtos.operation.OperationCreateDto;
import com.example.billing.model.dtos.operation.OperationDto;
import com.example.billing.model.dtos.operation.OperationUpdateDto;
import com.example.billing.model.entities.Operation;
import com.example.billing.model.mappers.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OperationMapper extends GenericMapper<Operation, OperationDto, OperationCreateDto, OperationUpdateDto> {
}
