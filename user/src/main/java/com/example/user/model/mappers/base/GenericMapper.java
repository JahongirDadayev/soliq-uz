package com.example.user.model.mappers.base;

import com.example.user.model.dtos.base.BaseCreateDto;
import com.example.user.model.dtos.base.BaseDTO;
import com.example.user.model.dtos.base.BaseUpdateDto;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E, D extends BaseDTO, CD extends BaseCreateDto, UD extends BaseUpdateDto> {
    E toEntity(CD dto);

    E toEntity(UD dto);

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    void updateEntityFromDto(@MappingTarget E entity, UD model);

}

