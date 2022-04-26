package com.playlist.music;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.playlist.music.model.Artist;
import com.playlist.music.model.Music;
import com.playlist.music.repository.MusicRepository;


@SpringBootTest
class MusicApplicationTests {
	
	@Autowired
	MusicRepository musicRepo;
	
	@Test
	public void testCreate() {
		long num = 1;
		Music song = new Music();
		Artist artist = new Artist();
		song.setId(10L);
		song.setName("Song Name");
		song.setGenre("The Best");
		song.setArtists(artist);
		song.setDurationInSeconds(100);
		musicRepo.save(song);
		assertNotNull(musicRepo.findById(10L).get());
	}
	
	@Test
	public void testReadAll () {
		List<Music> list = musicRepo.findAll();
		assertNotEquals(list.size(), 0);
	}

	@Test
	public void testSong() {
		Music song = musicRepo.findById(8L).get();
		assertEquals("genre IS ROCK", song.getGenre());
		
	}

	@Test
	public void testUpdate() {
		Music song = musicRepo.findById(9L).get();
		song.setGenre("PUNK");
		musicRepo.save(song);
		assertNotEquals("ROCK", musicRepo.findById(9L).get().getGenre());
	}

	@Test
	public void testDelete() {
		//musicRepo.deleteById(7L); (already deleted)
		assertTrue(musicRepo.findById(7L).isEmpty());
	}
}
