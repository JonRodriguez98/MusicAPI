package com.playlist.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playlist.music.model.Artist;
import com.playlist.music.service.ArtistService;

@Controller
@RequestMapping("/api")
public class ArtistController {

	@Autowired
	ArtistService artistService;
	
	@GetMapping("/artists")
	public List<Artist> getArtist() {
		return artistService.getArtists();
	}
	
	@PostMapping("/artists")
	public Artist addArtist(@RequestBody Artist artist) {
		return artistService.addArtist(artist);
	}
	
	@DeleteMapping("/artists/{artistId}")
	public void deleteArtist(@PathVariable(value="artistId")Long Id) {
		artistService.deleteArtist(Id);
	}

	@PutMapping("/artists/{artistId}")
	public Artist updateArtist(@PathVariable(value="artistId") Long Id, @RequestBody Artist artist) {
		return artistService.updateArtist(Id, artist);
	}
	
}
