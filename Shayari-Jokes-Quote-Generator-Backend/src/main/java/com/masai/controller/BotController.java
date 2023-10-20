package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.TextGenerator;
import com.masai.service.TextGeneratorService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class BotController {
	
	
	@Autowired
	private TextGeneratorService textGeneratorService;
	
	
	@GetMapping("/text")
	public ResponseEntity<String> getText(@RequestBody TextGenerator textGenerator){
		return new ResponseEntity<String>(textGeneratorService.genrateText(textGenerator),HttpStatus.OK);
	}

}
