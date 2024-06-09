package com.example.user.model.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationRequest {
    private int page = 0;

    private int size = 20;

    public int getPage() {
        return Math.max(page, 0);
    }

    public int getSize() {
        return Math.max(size, 1);
    }

    public Pageable getPageRequest() {
        return PageRequest.of(getPage(), getSize());
    }

}
