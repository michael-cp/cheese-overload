package com.mcp.myslice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	
	@RequestMapping("/")
	public String home(){
		return "Welcome to My Slice.";
	}
	
}
