package com.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rest.Entity.AlbumEntity;
import com.rest.Entity.ArtistEntity;
import com.rest.Entity.SongEntity;
import com.rest.dto.AlbumDto;
import com.rest.dto.SongDto;
import com.rest.repository.AlbumRepository;
import com.rest.repository.ArtistRepository;

@Service
public class AlbumService {

	@Autowired
	private ArtistRepository artistRepository;
	@Autowired
	private AlbumRepository albumRepository;

	public void createAlbum(Long artistId, AlbumDto albumDto) {
		ArtistEntity artistEntity = artistRepository.getArtistById(artistId);
		if (artistEntity == null) {
			System.out.println("Artist doesnt exist with id : " + artistId);
		} else {
			AlbumEntity albumEntity = convert(albumDto);
			if (albumEntity != null) {
				albumEntity.setArtist(artistEntity);
				albumRepository.save(albumEntity);
			} else {
				System.out.println("albumdto is null for artist: " + artistId);
			}
		}
	}

	public void addSongsToAlbum(AlbumDto albumDto) {
		if (albumDto.getId() == null) {
			System.out.println("album is null");
		} else {
			AlbumEntity albumEntity = albumRepository.findById(albumDto.getId());
			if (albumEntity != null) {
				if (!CollectionUtils.isEmpty(albumDto.getSongs())) {
					List<SongEntity> songEntities = new ArrayList<SongEntity>();
					for (SongDto songDto : albumDto.getSongs()) {
						SongEntity song = new SongEntity();
						song.setTitle(songDto.getName());
						song.setDuration(songDto.getDuration());
						song.setAlbum(albumEntity);
						songEntities.add(song);
					}
					if (albumEntity.getSongs() != null) {
						albumEntity.getSongs().addAll(songEntities);
					} else {
						albumEntity.setSongs(songEntities);
					}
					albumRepository.update(albumEntity);
				}
			} else {
				System.out.println("no album found with id " + albumDto.getId());
			

			}
		}

	}

	private AlbumEntity convert(AlbumDto albumDto) {

		AlbumEntity album = null;
		if (albumDto != null) {
			album = new AlbumEntity();
			album.setName(albumDto.getName());
			album.setYear(albumDto.getYear());
			album.setCoverImage(albumDto.getAlbumCover());
		}
		return album;
	}

}
