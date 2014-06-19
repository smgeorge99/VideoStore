package com.excella.bootcamp.videostore.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.excella.bootcamp.videostore.dao.RTMovie;

public interface MovieSearchManager {

	List<RTMovie> searchForMoviesByTitle(String titleSearch) 
		throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException;
}
