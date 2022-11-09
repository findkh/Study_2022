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
	//RequestMapping ���
	@RequestMapping(value="/domain", method= RequestMethod.POST)
	public String postExample() {
		return "Hello Post API";
	}
	
	//@RequestBody�� Map Ȱ�� POST API ����
	//@RequestBody�� HTTP�� Body ������ �ش� ����޼��� ������ ��ü�� �����ϴ� ������ �Ѵ�.
	//http://localhost:8080/api/v1/post-api/member
	@PostMapping(value="/member")
	public String postMember(@RequestBody Map<String, Object> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//DTO ��ü�� Ȱ���� POST API 
	//http://localhost:8080/api/v1/post-api/member2
	@PostMapping(value="/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
}
