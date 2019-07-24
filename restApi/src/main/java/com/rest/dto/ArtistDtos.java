package com.rest.dto;

public class ArtistDtos {
	private String name;
	private String genre;
	private String email;
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "ArtistDtos [name=" + name + ", genre=" + genre + ", email=" + email + ", country=" + country + "]";
	}

}
