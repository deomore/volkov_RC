package com.vlsu.volkov.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddContractDto {
    private LocalDate date;
    private Boolean type;
    private String contractUrl;
}
