package com.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rest.Entity.ArtistEntity;

@Repository
public class ArtistRepository {

	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	@PersistenceContext
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void save(ArtistEntity artistEntity) {
		em.persist(artistEntity);
	}

	@Transactional
	public List<ArtistEntity> getallArtists() {
		Query query = em.createQuery("SELECT a from ArtistEntity a");
		List<ArtistEntity> artists = query.getResultList();
		return artists;

	}
	@Transactional
	public ArtistEntity getArtistById(long id){
		return (ArtistEntity) em.find(ArtistEntity.class, id);
	}

	public List<ArtistEntity> getArtistByName(String name) {
		Query query = em.createQuery("SELECT a from ArtistEntity a.name = :name");
		query.setParameter("name", name);
		List<ArtistEntity> artists = query.getResultList();
		return artists;
	}

}
