package com.winocencio.swapi.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.winocencio.swapi.util.Util;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Specie implements Serializable  {
	
	private static final long serialVersionUID = 3867296793589733823L;
	
	private Integer id;
	private String name;
	private String classification;
	private String designation;
	
	private String averageHeight;
	private String averageLifespan;
	private String eyeColors;
	private String hairColors;
	private String skinColors;
	
	private String language;
	private Integer homeworldId;
	private List<Integer> peopleIds;
	private List<Integer> filmIds;
	
	@JsonGetter("averageHeight")
	public String getAverageHeight() {
		return averageHeight;
	}

	@JsonSetter("average_height")
	public void setAverageHeight(String averageHeight) {
		this.averageHeight = averageHeight;
	}

	@JsonGetter("id")
	public Integer getId() {
		return id;
	}

	@JsonSetter("url")
	public void setId(String url) {
		this.id = Util.getIdFromUrl(url);
	}

	@JsonGetter("averageLifespan")
	public String getAverageLifespan() {
		return averageLifespan;
	}

	@JsonSetter("average_hifespan")
	public void setAverageLifespan(String averageLifespan) {
		this.averageLifespan = averageLifespan;
	}

	@JsonGetter("eyeColors")
	public String getEyeColors() {
		return eyeColors;
	}

	@JsonSetter("eye_colors")
	public void setEyeColors(String eyeColors) {
		this.eyeColors = eyeColors;
	}

	@JsonGetter("hairColors")
	public String getHairColors() {
		return hairColors;
	}

	@JsonSetter("hair_colors")
	public void setHairColors(String hairColors) {
		this.hairColors = hairColors;
	}

	@JsonGetter("skinColors")
	public String getSkinColors() {
		return skinColors;
	}

	@JsonSetter("skin_colors")
	public void setSkinColors(String skinColors) {
		this.skinColors = skinColors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonGetter("homeworldId")
	public Integer getHomeworldId() {
		return homeworldId;
	}

	@JsonSetter("homeworld")
	public void setHomeworldId(String homeworldUrl) {
		this.homeworldId = Util.getIdFromUrl(homeworldUrl);
	}

	@JsonGetter("peopleIds")
	public List<Integer> getPeopleIds() {
		return peopleIds;
	}

	@JsonSetter("people")
	public void setPeopleIds(List<String> peopleIds) {
		this.peopleIds = Util.getIdsFromUrls(peopleIds);
	}

	@JsonGetter("filmIds")
	public List<Integer> getFilmIds() {
		return filmIds;
	}

	@JsonSetter("films")
	public void setFilmIds(List<String> filmIds) {
		this.filmIds = Util.getIdsFromUrls(filmIds);
	}
}
