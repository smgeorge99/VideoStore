package com.excella.bootcamp.videostore.dao;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RottenTomatoesMovieSearchResult {
	private Integer total;
	private List<RTMovie> movies;
	
	public final Integer getTotal() {
		return total;
	}
	public final void setTotal(Integer total) {
		this.total = total;
	}
	public final List<RTMovie> getMovies() {
		return movies;
	}
	public final void setMovies(List<RTMovie> movies) {
		this.movies = movies;
	}
	
}
