package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AddArtistDto;
import com.vlsu.volkov.model.Artist;
import com.vlsu.volkov.model.Concert;
import com.vlsu.volkov.model.User;
import com.vlsu.volkov.repository.ArtistRepository;
import com.vlsu.volkov.repository.ConcertRepository;
import com.vlsu.volkov.repository.UserRepository;
import com.vlsu.volkov.service.ArtistService;
import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService {
	private final ArtistRepository artistRepository;
	private final UserRepository userRepository;
	private final ConcertRepository concertRepository;
	private final JwtProvider jwtProvider;

	private final com.vlsu.volkov.utils.exception.AuthHelper authHelper;
	@Override
	@Transactional
	public Artist addArtist(AddArtistDto addArtistDto) {
		Artist artist = new Artist();
		String userEmail = jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		User user = userRepository.findByEmail(userEmail);
		artist.setFio(addArtistDto.getFio());
		artist.setName(addArtistDto.getName());
		artist.setGenre(addArtistDto.getGenre());
		artist.setUser(user);
		return artistRepository.save(artist);
	}

	@Override
	@Transactional
	public List<Artist> getArtist() {
		User user = userRepository.findByEmail(authHelper.getUserEmail());
		List<Concert> concerts = concertRepository.findAll();
		concerts = concerts.stream()
				.filter(concert -> concert.getPrice() > 140000 && Period.between(concert.getDate(), LocalDate.now().minusMonths(3)).getMonths() < 3)
				.collect(Collectors.toList());
		List<Artist> allArtists = concerts.stream().map(Concert::getArtist).collect(Collectors.toList());
		return allArtists.stream()
				.filter(item -> item.getUser().equals(user))
				.filter(item -> item.getContract().getType())
				.collect(Collectors.toList());
	}
}


