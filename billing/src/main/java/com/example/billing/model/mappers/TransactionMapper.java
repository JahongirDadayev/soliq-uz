package com.example.billing.model.mappers;

import com.example.billing.model.dtos.transaction.TransactionCreateDto;
import com.example.billing.model.dtos.transaction.TransactionDto;
import com.example.billing.model.dtos.transaction.TransactionUpdateDto;
import com.example.billing.model.entities.Transaction;
import com.example.billing.model.mappers.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper extends GenericMapper<Transaction, TransactionDto, TransactionCreateDto, TransactionUpdateDto> {
}
