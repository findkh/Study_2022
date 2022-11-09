package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	//RequestMapping 사용
	@RequestMapping(value="/domain", method= RequestMethod.POST)
	public String postExample() {
		return "Hello Post API";
	}
	
	//@RequestBody와 Map 활용 POST API 구현
	//@RequestBody는 HTTP의 Body 내용을 해당 어노텡션이 지정한 객체에 매핑하는 역할을 한다.
	//http://localhost:8080/api/v1/post-api/member
	@PostMapping(value="/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//DTO 객체를 활용한 POST API 
	//http://localhost:8080/api/v1/post-api/member2
	@PostMapping(value="/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
}
