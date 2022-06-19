package com.vlsu.volkov.repository;

import com.vlsu.volkov.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
