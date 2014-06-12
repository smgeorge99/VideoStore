/**
 * 
 */
package com.excella.bootcamp.videostore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author sean
 */
@Controller
public class HomePageController {

	@RequestMapping({"/home", "/"})
    public String goToHomePage(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
