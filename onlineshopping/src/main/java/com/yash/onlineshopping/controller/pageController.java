package com.yash.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to web mvc");

		return mv;

	}

	@RequestMapping(value = {"/test/{greeting}"})
	public ModelAndView test(@PathVariable(value ="greeting",required=false) String greeting) {
		if(greeting == null) {
			greeting ="Hellow there";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
		
		
	}
}
