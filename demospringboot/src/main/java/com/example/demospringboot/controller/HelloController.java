package com.example.demospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Hello world wide web!";
	}

	@GetMapping("/home")
	public String home(){
		return "home.html";
	}
}