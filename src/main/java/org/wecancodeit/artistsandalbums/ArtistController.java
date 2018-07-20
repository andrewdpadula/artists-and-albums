package org.wecancodeit.artistsandalbums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtistController {
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

	@RequestMapping("/")
	public String home() {
		return "redirect:/artists";
	}

	@RequestMapping("/artists")
	public String getArtists(Model model) {
		model.addAttribute("artists", artistRepo.findAll());
		return "artists";
	}

	@RequestMapping("/artists/{id}")
	public String getArtist(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("artist", artistRepo.findOne(id));
		return "artist";
	}

	@RequestMapping("album/{id}")
	public String getAlbum(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("album", albumRepo.findOne(id));
		return "album";
	}

	@RequestMapping("song/{id}")
	public String getSong(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("song", songRepo.findOne(id));
		return "song";
	}

	@RequestMapping(value = "/album/{id}", method = RequestMethod.POST)
	public String addAlbumComment(@PathVariable(name = "id") Long id, String userName, String comment, Album album) {
		albumCommentRepo.save(new AlbumComment(userName, comment, albumRepo.findOne(id)));
		return "redirect:/album/" + id;
	}
	@RequestMapping(value = "/song/{id}", method = RequestMethod.POST)
	public String addSongComment(@PathVariable(name = "id") Long id, String userName, String comment, Song song) {
		songCommentRepo.save(new SongComment(userName, comment, songRepo.findOne(id)));
		return "redirect:/song/" + id;
	}
}
