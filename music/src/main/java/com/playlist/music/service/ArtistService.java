package com.playlist.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.music.model.Artist;
import com.playlist.music.repository.ArtistRepository;

@Service
public class ArtistService {
	@Autowired
	ArtistRepository artistRepository;

	
	//GET REQUEST
	public List<Artist> getArtists() {
		return artistRepository.findAll();
	}
	
	//POST REQUEST
	public Artist addArtist(Artist artist) {
		return artistRepository.save(artist);
		
	}
	
	//DELETE REQUEST
	public void deleteArtist(Long artistId) {
		artistRepository.deleteById(artistId);
	}
	
	//PUT REQUEST
	public Artist updateArtist(Long artistId, Artist artist) {
		Artist currentArtist = artistRepository.findById(artistId).get();
		currentArtist.setFirstName(artist.getFirstName());
		currentArtist.setLastName(artist.getLastName());
		return artistRepository.save(currentArtist);
	}

}
