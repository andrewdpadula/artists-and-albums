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
	@RequestMapping(value = "/album/{id}", method = RequestMethod.POST)
	public Collection<AlbumComment> addAlbumComment(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "comment") String comment,
			@PathVariable(name = "id") Long id){
		albumCommentRepo.save(new AlbumComment(userName, comment, albumRepo.findOne(id)));
		Collection<AlbumComment> albumComment = albumRepo.findOne(id).getAlbumComments();
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

	//post new artist
	@RequestMapping(value = "/artists/", method = RequestMethod.POST)
	public Collection<Artist> addArtist(@RequestParam(value = "name") String name,
			@RequestParam(value = "recordLabel") String recordLabel){
		if (artistRepo.findByName(name) == null) {
			artistRepo.save(new Artist(name, recordLabel));
		}
		return (Collection<Artist>) artistRepo.findAll();
	}
}
