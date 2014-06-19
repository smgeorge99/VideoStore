/**
 * 
 */
package com.excella.bootcamp.videostore.dao;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * @author sean
 *
 */
@Repository
public class MovieSearchDAOImpl implements MovieSearchDAO {

	/**
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @see com.excella.bootcamp.videostore.dao.MovieSearchDAO#searchForMovieByTitle(java.lang.String)
	 */
	@Override
	public List<RTMovie> searchForMovieByTitle(String searchString) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate rt = new RestTemplate();
		String urlEncodedSearchString = URLEncoder.encode(searchString, "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		String movie = 
			rt.getForObject("http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=gmpx67fws5dfu7h9g9qj4azx&q={title}&page_limit=10", 
				String.class, urlEncodedSearchString);
		System.out.println(StringUtils.trim(movie));
		RottenTomatoesMovieSearchResult result = mapper.readValue(movie, RottenTomatoesMovieSearchResult.class);
		return result.getMovies();
	}

}
