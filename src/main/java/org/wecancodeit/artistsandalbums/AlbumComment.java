package org.wecancodeit.artistsandalbums;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class AlbumComment {
	@Id
	@GeneratedValue
	private Long id;
	private String userName;
	@Lob
	private String comment;
	@JsonIgnore
	@ManyToOne
	private Album album;
	
	public AlbumComment(String userName, String comment, Album album) {
		this.userName = userName;
		this.comment = comment;
		this.album = album;
	}
	
	public AlbumComment() {
		
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

	public Album getAlbum() {
		return album;
	}

	@Override
	public String toString() {
		return "AlbumComment [id=" + id + ", userName=" + userName + ", comment=" + comment + ", album=" + album + "]";
	}
	
	
}