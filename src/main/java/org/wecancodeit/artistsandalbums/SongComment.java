package org.wecancodeit.artistsandalbums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
@Entity
public class SongComment {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	@Lob
	private String comment;
	@ManyToOne
	private Song song;
	
	public SongComment(String userName, String comment, Song song) {
		this.userName = userName;
		this.comment = comment;
		this.song = song;
	}
	public SongComment() {
		
	}
	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getComment() {
		return comment;
	}
	public Song getSong() {
		return song;
	}
	@Override
	public String toString() {
		return "SongComment [id=" + id + ", userName=" + userName + ", comment=" + comment + ", song=" + song + "]";
	}
	
	
}