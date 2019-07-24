package com.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.Entity.ArtistEntity;
import com.rest.dto.ArtistDtos;
import com.rest.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public void saveArtist(ArtistDtos artistDtos) {
		// System.out.println(artistDtos.toString());

		ArtistEntity artistEntity = new ArtistEntity();

		artistEntity.setName(artistDtos.getName());
		artistEntity.setGenre(artistDtos.getGenre());
		artistEntity.setCountry(artistDtos.getCountry());
		artistEntity.setEmail(artistDtos.getEmail());

		artistRepository.save(artistEntity);
	}

	public List<ArtistDtos> getallArtists() {
		List<ArtistEntity> artistEntities = artistRepository.getallArtists();

		List<ArtistDtos> artistDtos = new ArrayList<ArtistDtos>();
		for (ArtistEntity artist : artistEntities) {
			ArtistDtos artistDto = new ArtistDtos();
			artistDto.setName(artist.getName());
			artistDto.setGenre(artist.getGenre());
			artistDto.setCountry(artist.getCountry());
			artistDto.setEmail(artist.getEmail());

			artistDtos.add(artistDto);
		}

		return artistDtos;
	}

//	public List<ArtistDtos> getallArtists() {
//		List<ArtistDtos> allArtist = new ArrayList<ArtistDtos>();
//
//		ArtistDtos dummy1 = new ArtistDtos();
//
//		dummy1.setName("Taylor Swift");
//		dummy1.setGenre("pop");
//		dummy1.setCountry("USA");
//		dummy1.setEmail("Taylor@gmai)l.com");
//
//		allArtist.add(dummy1);
//		return allArtist;
//
//	}

	public ArtistDtos getallArtistsById(int id) {

		ArtistDtos dummy1 = new ArtistDtos();

		dummy1.setName("John Mayor");
		dummy1.setGenre("Blues");
		dummy1.setCountry("USA");
		dummy1.setEmail("Mayor@gmai)l.com");

		return dummy1;

	}

	public ArtistDtos getallArtistsByGenre(String genre) {

		ArtistDtos dummy1 = new ArtistDtos();

		dummy1.setName("AC/DC");
		dummy1.setGenre("Rock");
		dummy1.setCountry("USA");
		dummy1.setEmail("ACDC@gmai)l.com");

		return dummy1;
	}
}
