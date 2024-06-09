package com.example.billing.model.mappers;

import com.example.billing.model.dtos.card.CardCreateDto;
import com.example.billing.model.dtos.card.CardDto;
import com.example.billing.model.dtos.card.CardUpdateDto;
import com.example.billing.model.entities.Card;
import com.example.billing.model.mappers.base.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper extends GenericMapper<Card, CardDto, CardCreateDto, CardUpdateDto> {
}
