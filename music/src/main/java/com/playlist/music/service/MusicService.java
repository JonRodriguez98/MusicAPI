package com.playlist.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.music.model.Artist;
import com.playlist.music.model.Music;
import com.playlist.music.repository.ArtistRepository;
import com.playlist.music.repository.MusicRepository;

@Service
public class MusicService {
	
	@Autowired
	MusicRepository musicRepository;
	@Autowired
	ArtistRepository artistRepository;
	
	//GET REQUEST
	public List<Music> getSongList() {
		return musicRepository.findAll();
	}
	
	//GET REQUEST BY ID
	public Music getSong(Long songId) {
		return musicRepository.getById(songId);
	}
	
	//POST REQUEST
	public Music addSong(Music song) {
		return musicRepository.save(song);
		
	}
	
	//DELETE REQUEST
	public void deleteSong(Long songId) {
		musicRepository.deleteById(songId);
	}
	
	//PUT REQUEST
	public Music updateSong(Long songId, Music song) {
		Music currentSong = musicRepository.findById(songId).get();
		currentSong.setName(song.getName());
		currentSong.setGenre(song.getGenre());
		currentSong.setArtists(song.getArtists());
		currentSong.setDurationInSeconds(song.getDurationInSeconds());
		return musicRepository.save(currentSong);
	}
	
	//PATCH REQUEST
	public Music patchSong(Long songId, String name) {
		Music currentSong = musicRepository.findById(songId).get();
		currentSong.setName(name);
		return musicRepository.save(currentSong);
	}
}
