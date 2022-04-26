package com.playlist.music.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="music")
public class Music {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="name")
	private String name;
	@Column(name="genre")
	private String genre;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="artistid")
	private Artist artists;
	
	
	@Column(name="durationInSeconds")
	private int durationInSeconds;
	
	public Music() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}
	

	public Artist getArtists() {
		return artists;
	}

	public void setArtists(Artist artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", genre=" + genre + ", durationInSeconds="
				+ durationInSeconds + "]";
	}
	
	
	
}
