package com.vlsu.volkov.service.impl;

import com.vlsu.volkov.dto.AddReleaseDto;
import com.vlsu.volkov.model.Artist;
import com.vlsu.volkov.model.Release;
import com.vlsu.volkov.model.Source;
import com.vlsu.volkov.model.User;
import com.vlsu.volkov.repository.ArtistRepository;
import com.vlsu.volkov.repository.ReleaseRepository;
import com.vlsu.volkov.repository.SourceRepository;
import com.vlsu.volkov.repository.UserRepository;
import com.vlsu.volkov.service.ReleaseService;
import com.vlsu.volkov.utils.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReleaseServiceImpl implements ReleaseService {
	private final ReleaseRepository releaseRepository;
	private final SourceRepository sourceRepository;
	private final ArtistRepository artistRepository;
	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	@Override
	@Transactional
	public Release addRelease(AddReleaseDto addReleaseDto) {
		Source source = sourceRepository.findById(addReleaseDto.getSourceId()).get();
		Artist artist = artistRepository.findById(addReleaseDto.getArtistId()).get();
		String email = jwtProvider.getEmailFromToken(SecurityContextHolder.getContext().getAuthentication().getDetails().toString());
		User user = userRepository.findByEmail(email);
		Release release = new Release();
		release.setReleaseUrl(addReleaseDto.getReleaseUrl());
		release.setGenre(addReleaseDto.getGenre());
		release.setName(addReleaseDto.getName());
		release.setSource(source);
		release.setUser(user);
		release.setArtist(artist);
		return  releaseRepository.save(release);
	}
}
