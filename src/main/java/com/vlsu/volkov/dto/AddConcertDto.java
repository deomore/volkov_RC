package com.vlsu.volkov.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddConcertDto {
    private Integer artistId;
    private String city;
    private LocalDate date;
    private Float price;
}

