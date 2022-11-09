package com.springboot.api.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.dto.MemberDto;


@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
	
	//http://localhost:8080/api/v1/get-api/hello
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String getHello() {
		return "Hello world";
	}
	
	//매개변수가 없는 GET 메서드 구현
	//http://localhost:8080/api/v1/get-api/name
	@GetMapping(value="/name")
	public String getName() {
		return "Sudal";
	}
	
	//@PathVariable을 활용한 GET 메서드 구현
	//중괄호로 표시된 위치의 값을 받아 요청하는 한다.
	//규칙
	//1. @GetMapping 어노테이션의 값으로 URL을 입력할 떄 중괄호를 사용해 어느 위치에서 값을 받을지 지정해야 함
	//2. 메서드의 매개변수와 그 값을 연결하기 위해 @PathVariable을 명시해야하고, @GetMapping 어노테이션과 @PathVariable에 지정된 변수의 이름을 맞춰야함
	//http://localhost:8080/api/v1/get-api/variable1/{String 값}
	@GetMapping(value="/variable1/{variable}")
	public String getVariable1(@PathVariable String variable) {
		return variable;
	}
	
	//@PathVariable에 변수명을 매핑하는 방법
	//http://localhost:8080/api/v1/get-api/variable1/{String 값}
	@GetMapping(value="/variable2/{variable}")
	public String getVariable2(@PathVariable ("variable") String var) {
		return var;
	}
	
	//@RequestParam 활용 GET 메서드
	//http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
	@GetMapping(value="/request1")
	public String getRequestParam1(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String organization
			) {
		return name + " " + email + " " + organization;
	}
	
	//@RequestParam + Map 조합한 GET 메서드
	//http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
	@GetMapping(value="/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		return sb.toString();
	}
	
	//DTO 객체를 활용한 GET 메서드 구현
	//http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
	@GetMapping(value="/request3")
	public String getRequestParam3(MemberDto memberDto) {
		return memberDto.toString();
	}
}
