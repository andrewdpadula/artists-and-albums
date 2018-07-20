package org.wecancodeit.artistsandalbums;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Artist {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;
	private String recordLabel;

	@OneToMany(mappedBy = "artist")
	private Collection<Song> songs;

	public Artist() {

	}

	public Artist(String name, String recordLabel) {
		this.name = name;
		this.recordLabel = recordLabel;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	@Override
	public String toString() {
		return name;
	};

}
