package com.example.user.model.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
    private Timestamp transactionTime;

    private String resultCode;

    private String resultMsg;

    private T data;

    private PaginationData pagination;

    public static <T> Header<T> ok() {
        return Header.<T>builder()
                .transactionTime(Timestamp.from(Instant.now()))
                .resultCode("0000")
                .resultMsg("OK")
                .build();
    }

    public static <T> Header<T> ok(T data) {
        return Header.<T>builder()
                .transactionTime(Timestamp.from(Instant.now()))
                .resultCode("0000")
                .resultMsg("OK")
                .data(data)
                .build();
    }

    public static <T> Header<T> ok(T data, PaginationData pagination) {
        return Header.<T>builder()
                .transactionTime(Timestamp.from(Instant.now()))
                .resultCode("0000")
                .resultMsg("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }

    public static <T> Header<T> error() {
        return Header.<T>builder()
                .transactionTime(Timestamp.from(Instant.now()))
                .resultCode("E000")
                .resultMsg("ERROR")
                .build();
    }

    public static <T> Header<T> error(String msg) {
        return Header.<T>builder()
                .transactionTime(Timestamp.from(Instant.now()))
                .resultCode("E000")
                .resultMsg(msg)
                .build();
    }

}