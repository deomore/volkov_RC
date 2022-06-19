package com.vlsu.volkov.service;

import com.vlsu.volkov.dto.AddArtistDto;
import com.vlsu.volkov.model.Artist;

import java.util.List;

public interface ArtistService {
	Artist addArtist(AddArtistDto addArtistDto);

	List<Artist> getArtist();
}
