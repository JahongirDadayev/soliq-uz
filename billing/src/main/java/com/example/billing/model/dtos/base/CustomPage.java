package com.example.billing.model.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomPage<T> {
    private List<T> data;

    private PaginationData paginationData;

    public static <T> CustomPage<T> of(Page<T> page) {
        List<T> tList = page.getContent();
        return CustomPage.<T>builder()
                .paginationData(buildPaginationData(page))
                .data(tList)
                .build();
    }

    public static <T, E> CustomPage<T> of(Page<E> page, List<T> dtoList) {
        return CustomPage.<T>builder()
                .paginationData(buildPaginationData(page))
                .data(dtoList)
                .build();
    }

    private static <T> PaginationData buildPaginationData(Page<T> page) {
        return PaginationData.builder()
                .numberOfElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .pageSize(page.getSize())
                .currentPageNumber(page.getNumber())
                .build();
    }

}
