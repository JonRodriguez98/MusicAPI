package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.playlist.music.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long>{

}
