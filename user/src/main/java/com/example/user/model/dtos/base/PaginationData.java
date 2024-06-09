package com.example.user.model.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaginationData {
    private int numberOfElements;

    private long totalElements;

    private int totalPages;

    private int currentPageNumber;

    private int pageSize;

}
