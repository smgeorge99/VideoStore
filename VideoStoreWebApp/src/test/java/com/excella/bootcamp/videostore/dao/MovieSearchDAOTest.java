package com.excella.bootcamp.videostore.dao;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;

public class MovieSearchDAOTest {

	private MovieSearchDAO searchDAO = new MovieSearchDAOImpl();
	
	@Test
	public void testBasicMovieTitleSearch() throws JsonParseException, JsonMappingException, IOException {
		RTMovie toyStory3 = new RTMovie();
		toyStory3.setTitle("Toy Story 3");
		toyStory3.setYear(2010);
		toyStory3.setSynopsis("Pixar returns to their first success with Toy Story 3. The movie begins with Andy leaving for college and donating his beloved toys -- including Woody (Tom Hanks) and Buzz (Tim Allen) -- to a daycare. While the crew meets new friends, including Ken (Michael Keaton), they soon grow to hate their new surroundings and plan an escape. The film was directed by Lee Unkrich from a script co-authored by Little Miss Sunshine scribe Michael Arndt. ~ Perry Seibert, Rovi");
		toyStory3.setRuntime(103);
		toyStory3.setMpaaRating("G");
		List<RTMovie> expectedResult = new ArrayList<>();
		expectedResult.add(toyStory3);
		
		List<RTMovie> actualResult = searchDAO.searchForMovieByTitle("Toy Story 3");
		
		assertEquals(expectedResult, actualResult);
	}

}
