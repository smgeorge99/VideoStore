package com.excella.bootcamp.videostore.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.excella.bootcamp.videostore.dao.MovieSearchDAO;
import com.excella.bootcamp.videostore.dao.RTMovie;

@Component
public class MovieSearchManagerImpl implements MovieSearchManager {

	@Autowired
	private MovieSearchDAO movieSearchDAO;
	
	@Override
	public List<RTMovie> searchForMoviesByTitle(String titleSearch) 
		throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException {
		
		return movieSearchDAO.searchForMovieByTitle(titleSearch);
	}

}
