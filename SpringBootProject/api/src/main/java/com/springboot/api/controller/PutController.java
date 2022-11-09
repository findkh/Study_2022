package com.springboot.api.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;

//PUT�� �� ���ø����̼� ������ ���� �����ͺ��̽� ���� ����ҿ� �����ϴ� ���ҽ� ���� ������Ʈ�ϴµ� ����Ѵ�.

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

	//@RequestBody�� Map�� Ȱ���� PUT �޼��� ����
	//http://localhost:8080/api/v1/put-api/member
	@PutMapping(value="/member")
	public String postMember(@RequestBody Map<String, Object> putData) {
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	//DTO ��ü�� Ȱ���� PUT �޼��� ����
	//http://localhost:8080/api/v1/put-api/member1
	@PutMapping(value="/member1")
	public String postMemberDto1(@RequestBody MemberDto memberDto) {
		return memberDto.toString();
	}
	
	//http://localhost:8080/api/v1/put-api/member2
	@PutMapping(value="/member2")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto) {
		return memberDto;
	}
	
	//ResponseEntity�� Ȱ���� PUT �޼��� ����
	//http://localhost:8080/api/v1/put-api/member3
	@PutMapping(value="/member3")
	public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
	}
}
