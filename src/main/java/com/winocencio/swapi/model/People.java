package com.winocencio.swapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.winocencio.swapi.util.Util;

@JsonIgnoreProperties(ignoreUnknown = true)
public class People {
	
	private Integer id;
	private String name;
	private String birthYear;
	private String eyeColor;
	private String gender;
	private String hairColor;
	private String height;
	private String mass;
	private String skinColor;
	private Integer homeworldId;
	private List<Integer> filmIds;
	private List<Integer> specieIds;
	private List<Integer> starshipIds;
	private List<Integer> vehicleIds;
	private List<Integer> peopleSimiliarIds;
	
	@JsonSetter("films")
	public void setFilmIds(List<String> filmsUrl) {
		this.filmIds = Util.getIdsFromUrls(filmsUrl);
	}
	
	@JsonSetter("species")
	public void setSpecieIds(List<String> speciesUrl) {
		this.specieIds = Util.getIdsFromUrls(speciesUrl);
	}
	
	@JsonSetter("starships")
	public void setStarshipIds(List<String> starshipsUrl) {
		this.starshipIds = Util.getIdsFromUrls(starshipsUrl);
	}
	
	@JsonSetter("vehicles")
	public void setVehicleIds(List<String> vehiclesUrl) {
		this.vehicleIds = Util.getIdsFromUrls(vehiclesUrl);
	}
	
	@JsonGetter("id")
	public Integer getId() {
		return id;
	}

	@JsonSetter("url")
	public void setId(String id) {
		this.id = Integer.valueOf(id.split("/")[5]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonGetter("birthYear")
	public String getBirthYear() {
		return birthYear;
	}

	@JsonSetter("birth_year")
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	@JsonGetter("eyeColor")
	public String getEyeColor() {
		return eyeColor;
	}

	@JsonSetter("eye_color")
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonGetter("hairColor")
	public String getHairColor() {
		return hairColor;
	}

	@JsonSetter("hair_color")
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getMass() {
		return mass;
	}

	public void setMass(String mass) {
		this.mass = mass;
	}

	@JsonGetter("skinColor")
	public String getSkinColor() {
		return skinColor;
	}

	@JsonSetter("skin_color")
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	@JsonGetter("filmIds")
	public List<Integer> getFilmIds() {
		return filmIds;
	}

	@JsonGetter("specieIds")
	public List<Integer> getSpecieIds() {
		return specieIds;
	}

	@JsonGetter("starshipIds")
	public List<Integer> getStarshipIds() {
		return starshipIds;
	}

	@JsonGetter("vehicleIds")
	public List<Integer> getVehicleIds() {
		return vehicleIds;
	}

	public void setHomeworld(String homeworldUrl) {
		this.homeworldId = Util.getIdFromUrl(homeworldUrl);
	}
	
	public Integer getHomeworldId() {
		return homeworldId;
	}

	public void setHomeworldId(Integer homeworldId) {
		this.homeworldId = homeworldId;
	}

	public List<Integer> getPeopleSimiliarIds() {
		return peopleSimiliarIds;
	}

	public void setPeopleSimiliarIds(List<Integer> peopleSimiliarIds) {
		this.peopleSimiliarIds = peopleSimiliarIds;
	}
}
