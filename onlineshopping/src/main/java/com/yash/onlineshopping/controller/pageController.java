package com.yash.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {

	System.Out.Println("for git clone test ");
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		System.Out.Println("for git clone test time 2 ");

		System.Out.Println("for git clone test time 2 ");
		return mv;

	}

	
}
