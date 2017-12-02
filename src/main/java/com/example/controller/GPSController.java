package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GPSController {
	
	@RequestMapping(value="/pc",method=RequestMethod.GET)
	public String HomePage()
	{
		return "mobile";
	}
}
