package org.wecancodeit.artistsandalbums;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album {
	@Id
	@GeneratedValue
	private long id;
	private String albumName;
	private String releaseDate;
	private String genre;
	private String coverImage;
	
	@OneToMany(mappedBy = "album")
	@JsonIgnore
	private Collection<Song> songs;
	
	@ManyToOne
	@JsonIgnore
	private Artist artist;
	
	@OneToMany(mappedBy = "album")
	private Collection<AlbumComment> albumComments;

	public Album() {
		
	}

	public Album(String albumName, String releaseDate, String genre, String coverImage, Artist artist, AlbumComment ... albumComments) {
		this.albumName = albumName;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.coverImage = coverImage;
		this.artist = artist;
		this.albumComments = Arrays.asList(albumComments);
	}

	public long getId() {
		return id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getGenre() {
		return genre;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public Collection<AlbumComment> getAlbumComments() {
		return albumComments;
	}

	public Artist getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return albumName;
	}
	
	
}
