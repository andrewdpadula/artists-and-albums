package org.wecancodeit.artistsandalbums;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	ArtistRepository artistRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	SongRepository songRepo;

	@Autowired
	AlbumCommentRepository albumCommentRepo;

	@Autowired
	SongCommentRepository songCommentRepo;

	//post albumComment
	@RequestMapping(value = "/album/{albumName}", method = RequestMethod.POST)
	public Collection<AlbumComment> addAlbumComment(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "comment") String comment,
			@PathVariable(name = "albumName") String albumName){
		albumCommentRepo.save(new AlbumComment(userName, comment, albumRepo.findByAlbumName(albumName)));
		Collection<AlbumComment> albumComment = albumRepo.findByAlbumName(albumName).getAlbumComments();
		return albumComment;
	}
	
	//post songComment	
	@RequestMapping(value = "/song/{id}", method = RequestMethod.POST)
	public Collection<SongComment> addSongComment(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "comment") String comment,
			@PathVariable(name = "id") Long id){
			songCommentRepo.save(new SongComment(userName, comment, songRepo.findOne(id)));
			Collection<SongComment> songComment = songRepo.findOne(id).getSongComments();
			return songComment;
	}

	//add an artist
	@RequestMapping(value = "/artists/", method = RequestMethod.POST)
	public Collection<Artist> addArtist(@RequestParam(value = "name") String name,
			@RequestParam(value = "recordLabel") String recordLabel){
		if (artistRepo.findByName(name) == null) {
			artistRepo.save(new Artist(name, recordLabel));
		}
		return (Collection<Artist>) artistRepo.findAll();
	}
	
	//add an album
	@RequestMapping(value = "/artists/{name}/album/", method = RequestMethod.POST)
	public Collection<Album> addAlbum(@PathVariable(name = "name") String name,
			@RequestParam(value = "albumName") String albumName,
			@RequestParam(value = "releaseDate") String releaseDate,
			@RequestParam(value = "genre") String genre){
			if(albumRepo.findByAlbumName(albumName) == null) {
				albumRepo.save(new Album(albumName, releaseDate, genre, null, artistRepo.findByName(name)));
		}
		return artistRepo.findByName(name).getAlbums();
	}
	
	//delete song
	@RequestMapping(value = "/album/{albumName}/song", method = RequestMethod.DELETE)
	public Collection<Song> deleteSong(@PathVariable(name = "albumName") String albumName,
			@RequestParam(value = "id") Long id){
		songRepo.delete(id);
		return albumRepo.findByAlbumName(albumName).getSongs();
	}
	
	//delete album
	@RequestMapping(value = "/artists/{name}/album", method = RequestMethod.DELETE)
	public Collection<Album> deleteAlbum(@PathVariable(name = "name") String name,
			@RequestParam(value = "albumName") String albumName){
		for (Song song : albumRepo.findByAlbumName(albumName).getSongs()) {
			songRepo.delete(song);
		}
		albumRepo.delete(albumRepo.findByAlbumName(albumName));
		return artistRepo.findByName(name).getAlbums();
	}
	
	
	//delete artist
	@RequestMapping(value = "/artists/", method = RequestMethod.DELETE)
	public Collection<Artist> deleteArtist(@RequestParam(name = "name") String name){
		for (Album album : artistRepo.findByName(name).getAlbums()) {
			albumRepo.delete(album);
		}
		artistRepo.delete(artistRepo.findByName(name));
		return (Collection<Artist>) artistRepo.findAll();
	}
}
