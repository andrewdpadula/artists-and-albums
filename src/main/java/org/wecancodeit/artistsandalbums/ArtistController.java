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

	@RequestMapping("/artists/{name}")
	public String getArtist(@PathVariable(name = "name") String name, Model model) {
		model.addAttribute("artist", artistRepo.findByName(name));
		return "artist";
	}

	@RequestMapping("/artists/{name}/album/{albumName}")
	public String getAlbum(@PathVariable(name = "name") String name,
			@PathVariable(name = "albumName") String albumName, Model model) {
		model.addAttribute("album", albumRepo.findByAlbumName(albumName));
		return "album";
	}

	@RequestMapping("/artists/{name}/album/{albumName}/song/{id}")
	public String getSong(@PathVariable(name = "name") String name,
			@PathVariable(name = "albumName") String albumName,			
			@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("song", songRepo.findOne(id));
		return "song";
	}
}
