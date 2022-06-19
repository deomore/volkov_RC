package com.vlsu.volkov.service;

import com.vlsu.volkov.dto.AddConcertDto;
import com.vlsu.volkov.model.Concert;

public interface ConcertService {
	Concert addConcert(AddConcertDto addConcertDto);
}
