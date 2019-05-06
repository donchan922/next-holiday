package com.example.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Holiday {
    private final String date;
    private final String name;
    private final String image;
}
