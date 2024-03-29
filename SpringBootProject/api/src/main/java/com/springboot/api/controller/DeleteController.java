package com.springboot.api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
	//@PathVariable을 활용한 DELETE 메서드 구현
	@DeleteMapping(value="/{variable}")
	public String DeleteVariable(@PathVariable String variable) {
		return variable;
	}
	
	//@RequestParam을 활용한 DELETE 메서드 구현
	//http://localhost:8080/api/v1/delete-api/request1?email=value
	@DeleteMapping(value="/request1")
	public String getRequestParam1(@RequestParam String email) {
		return "e-mail: " + email;
	}
}
