package com.vlsu.volkov.service;

import com.vlsu.volkov.dto.AddReleaseDto;
import com.vlsu.volkov.model.Release;

public interface ReleaseService {
	Release addRelease(AddReleaseDto addReleaseDto);
}
