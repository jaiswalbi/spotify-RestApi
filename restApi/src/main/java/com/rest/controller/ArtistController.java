package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.dto.ArtistDtos;
import com.rest.services.ArtistService;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController {

	@Autowired
	public ArtistService artistService;
	
	//http://localhost:8080/restApi/artist/
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void hello(@RequestBody ArtistDtos artistDto) {
		artistService.saveArtist(artistDto);

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<ArtistDtos> getArtist() {
		return artistService.getallArtists();

	}

	// http://localhost:8000/spotify/artist/id?artistId=10&name=abinash
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public ArtistDtos getArtistById(@RequestParam(value = "artistId") int id,
			@RequestParam(required = false) String name) {
		return artistService.getallArtistsById(id);
	}

	// http://localhost:8000/spotify/artist/id/60/details
	@RequestMapping(value = "/id/{id}/details", method = RequestMethod.GET)
	public ArtistDtos getArtistDetailsById(@PathVariable int id) {
		return artistService.getallArtistsById(id);
	}
	//http://localhost:8080/restApi/artist/genre?artistGenre=Blues
	@RequestMapping(value="/genre", method=RequestMethod.GET)
	public ArtistDtos getArtistByGenre(@RequestParam(value="artistGenre") String genre,
			@RequestParam(required = false) String name) {
		return artistService.getallArtistsByGenre(genre);
	}
	
}
