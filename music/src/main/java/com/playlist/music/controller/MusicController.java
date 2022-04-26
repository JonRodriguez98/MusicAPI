package com.playlist.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.music.model.Artist;
import com.playlist.music.model.Music;
import com.playlist.music.service.ArtistService;
import com.playlist.music.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
	
	@Autowired
	MusicService musicService;
	
	@GetMapping("/tracks")
	public List<Music> getMusic() {
		return musicService.getSongList();
	}
	
	@GetMapping("/tracks/{songId}")
	public Music getSong(@PathVariable(value="songId")Long id) {
		return musicService.getSong(id);
	}
	
	@PostMapping("/tracks")
	public Music addSong(@RequestBody Music song) {
		return musicService.addSong(song);
	}
	
	@DeleteMapping("/tracks/{songId}")
	public void deleteSong(@PathVariable(value="songId")Long id) {
		musicService.deleteSong(id);
	}

	@PutMapping("/tracks/{songId}")
	public Music updateSong(@PathVariable(value="songId") Long id, @RequestBody Music song) {
		return musicService.updateSong(id, song);
	}
	
	@PatchMapping("/tracks/{songId}/{newName}")
	public Music patchSong(@PathVariable(value="songId") Long id, @PathVariable(value="newName") String name) {
		return musicService.patchSong(id, name);
	}
	
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
