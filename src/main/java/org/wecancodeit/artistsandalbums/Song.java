package org.wecancodeit.artistsandalbums;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	@Id
	@GeneratedValue
	private long id;
	private String songName;
	private String length;
	@Lob
	private String lyrics;
	private String rating;
	@ManyToOne
	@JsonIgnore
	private Album album;
	@ManyToOne
	@JsonIgnore
	private Artist artist;
	
	public Album getAlbum() {
		return album;
	}


	public Artist getArtist() {
		return artist;
	}

	@OneToMany(mappedBy = "song")
	private Collection<SongComment> songComments;
	
	public Song() {
		
	}


	public Song(String songName, String length, String lyrics, String rating, Album album,
			SongComment ... songComments) {
		this.songName = songName;
		this.length = length;
		this.lyrics = lyrics;
		this.rating = rating;
		this.album = album;
		this.songComments = Arrays.asList(songComments);
	}



	public long getId() {
		return id;
	}

	public String getSongName() {
		return songName;
	}

	public String getLength() {
		return length;
	}

	public String getLyrics() {
		return lyrics;
	}

	public String getRating() {
		return rating;
	}

	public Collection<SongComment> getSongComments() {
		return songComments;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", songName=" + songName + ", length=" + length + ", lyrics=" + lyrics + ", rating="
				+ rating + "]";
	}
	

}
