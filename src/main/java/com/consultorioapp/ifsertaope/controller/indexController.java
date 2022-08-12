package com.consultorioapp.ifsertaope.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class indexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
