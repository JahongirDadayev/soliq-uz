package com.example.billing.controller;

import com.example.billing.model.dtos.base.Header;
import com.example.billing.model.dtos.base.PaginationRequest;
import com.example.billing.model.dtos.card.CardCreateDto;
import com.example.billing.model.dtos.card.CardUpdateDto;
import com.example.billing.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.example.billing.commons.constants.RestConstants.BASE_URL;
import static com.example.billing.commons.constants.RestConstants.CARD;

@RestController
@RequestMapping(value = BASE_URL + CARD)
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping(path = "/{id}")
    public Header<?> getById(@PathVariable(name = "id") UUID id) {
        return Header.ok(cardService.getById(id));
    }

    @GetMapping(path = "/all")
    public Header<?> getById(PaginationRequest paginationRequest) {
        return Header.ok(cardService.getAll(paginationRequest));
    }

    @PostMapping
    public Header<?> create(@RequestBody @Valid CardCreateDto cardCreateDto) {
        return Header.ok(cardService.create(cardCreateDto));
    }

    @PutMapping(path = "/{id}")
    public Header<?> update(@PathVariable(name = "id") UUID id, @RequestBody @Valid CardUpdateDto cardUpdateDto) {
        return Header.ok(cardService.update(id, cardUpdateDto));
    }

    @DeleteMapping(path = "/{id}")
    public Header<?> delete(@PathVariable(name = "id") UUID id) {
        cardService.delete(id);
        return Header.ok();
    }

}
