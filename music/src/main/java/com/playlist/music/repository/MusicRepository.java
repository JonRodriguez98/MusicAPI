package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.playlist.music.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long>{

}
