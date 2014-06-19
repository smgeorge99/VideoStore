/**
 * 
 */
package com.excella.bootcamp.videostore.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excella.bootcamp.videostore.dao.RTMovie;
import com.excella.bootcamp.videostore.service.MovieSearchManager;

/**
 * 
 * @author sean
 */
@Controller
public class MovieSearchController {

	@Autowired
	private MovieSearchManager movieSearchManager;
	
	@RequestMapping("/movieTitleSearchPage")
    public String goToMovieTitleSearchPage(Model model) {
		model.addAttribute("titleSearchForm", new MovieSearchForm());
        return "searchMoviesByTitle";
    }
	
	@RequestMapping("/searchForMoviesByTitle")
    public String searchForMoviesByTitle(MovieSearchForm searchForm, Model model) 
    	throws JsonParseException, JsonMappingException, UnsupportedEncodingException, IOException {
		
		List<RTMovie> searchResults = 
			movieSearchManager.searchForMoviesByTitle(searchForm.getTitleSearchString());
		model.addAttribute("movieSearchResults", searchResults);
		return "movieSearchResultList";
    }
}
