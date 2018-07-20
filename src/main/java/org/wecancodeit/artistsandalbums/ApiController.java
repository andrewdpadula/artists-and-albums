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

	//post songComment
	@RequestMapping(value = "/song/{id}", method = RequestMethod.POST)
	public Collection<SongComment> addSongComment(@RequestParam(value = "userName") String userName,
			@RequestParam(value = "comment") String comment,
			@PathVariable(name = "id") Long id){
			songCommentRepo.save(new SongComment(userName, comment, songRepo.findOne(id)));
			return (Collection<SongComment>) songCommentRepo.findAll();
	}

}