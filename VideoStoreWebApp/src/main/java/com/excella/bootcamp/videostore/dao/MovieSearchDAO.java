/**
 * 
 */
package com.excella.bootcamp.videostore.dao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

/**
 * @author sean
 *
 */
public interface MovieSearchDAO {

	List<RTMovie> searchForMovieByTitle(String searchString) 
		throws UnsupportedEncodingException, JsonParseException, JsonMappingException, IOException;
}
