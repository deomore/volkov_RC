package com.vlsu.volkov.dto;

import lombok.Data;

@Data
public class AddArtistDto {
    private String name;
    private String fio;
    private String genre;
    private Integer contractId;
}
