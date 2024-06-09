package com.example.auth.commons.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenerationCode {

    public static String generationCode() {
        return String.valueOf(new Random().nextInt(900000) + 100000);
    }

}