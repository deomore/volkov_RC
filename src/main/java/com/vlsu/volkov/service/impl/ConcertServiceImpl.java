package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AddConcertDto;
import com.vlsu.volkov.model.Concert;
import com.vlsu.volkov.model.User;
import com.vlsu.volkov.repository.ArtistRepository;
import com.vlsu.volkov.repository.ConcertRepository;
import com.vlsu.volkov.repository.UserRepository;
import com.vlsu.volkov.service.ConcertService;
import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ConcertServiceImpl implements ConcertService {
	private final ConcertRepository concertRepository;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	private final ArtistRepository artistRepository;

	@Override
	@Transactional
	public Concert addConcert(AddConcertDto addConcertDto) {
		User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		Concert concert = new Concert();
		concert.setArtist(artistRepository.findById(addConcertDto.getArtistId()).get());
		concert.setCity(addConcertDto.getCity());
		concert.setUser(user);
		concert.setPrice(addConcertDto.getPrice());
		concert.setDate(addConcertDto.getDate());
		return concertRepository.save(concert);
	}
}
