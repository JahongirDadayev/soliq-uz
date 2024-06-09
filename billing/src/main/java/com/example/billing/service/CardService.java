package com.example.billing.service;

import com.example.billing.commons.constants.ErrorMessages;
import com.example.billing.commons.exception.GeneralApiException;
import com.example.billing.model.dtos.base.CustomPage;
import com.example.billing.model.dtos.base.PaginationRequest;
import com.example.billing.model.dtos.card.CardCreateDto;
import com.example.billing.model.dtos.card.CardDto;
import com.example.billing.model.dtos.card.CardUpdateDto;
import com.example.billing.model.entities.Card;
import com.example.billing.model.mappers.CardMapper;
import com.example.billing.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class CardService {

    private final CardMapper cardMapper;

    private final CardRepository cardRepository;

    public CardDto getById(UUID id) {
        return cardMapper.toDto(findById(id));
    }

    public CustomPage<CardDto> getAll(PaginationRequest paginationRequest) {
        Page<Card> cardPage = cardRepository.findAll(paginationRequest.getPageRequest());
        return CustomPage.of(cardPage, cardMapper.toDtoList(cardPage.getContent()));
    }

    public CardDto create(CardCreateDto cardCreateDto) {
        Card card = cardMapper.toEntity(cardCreateDto);
        cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public CardDto update(UUID id, CardUpdateDto cardUpdateDto) {
        Card card = findById(id);
        cardMapper.updateEntityFromDto(card, cardUpdateDto);
        cardRepository.save(card);
        return cardMapper.toDto(card);
    }

    public void delete(UUID id) {
        try {
            cardRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Card Service Error {}", e.getMessage());
            throw new GeneralApiException("Failed to delete card with id: " + id);
        }
    }

    private Card findById(UUID id) {
        return cardRepository
                .findById(id)
                .orElseThrow(() -> new GeneralApiException(String.format(ErrorMessages.NOT_FOUND, Card.class.getSimpleName())));
    }

}
