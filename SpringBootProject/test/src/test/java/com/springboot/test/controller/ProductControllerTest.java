package com.springboot.test.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.springboot.test.data.dto.ProductDto;
import com.springboot.test.data.dto.ProductResponseDto;
import com.springboot.test.service.impl.ProductServiceImpl;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	//실제 빈 객체가 아닌 Mock(가짜)객체를 생성해서 주입하는 역할을 수행한다. @MockBean이 선언된 객체는 실제 객체가 아니기 때문에 실제 행위를 수행하지 않는다.
	//개발자가 Mockito의 given() 메서드를 통해 동작을 정의해야 한다.
	
	ProductServiceImpl productService;
	
	@Test
	@DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
	void getProductTest() throws Exception {
	
		//given() 메서드를 통해 이 객체에서 어떤 메서드가 호출되고 어떤 파라미터를 주입받는지 가정한 후 
		// willReturn() 메서드를 통해 어떤 결과를 리턴할 것인지 정의하는 구조로 코드를 작성한다.
		given(productService.getProduct(123L)).willReturn(new ProductResponseDto(123L, "pen", 5000, 2000));
		
		String productId = "123";
		
		mockMvc.perform(get("/product?number=" + productId))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.number").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.price").exists())
			.andExpect(jsonPath("$.stock").exists())
			.andDo(print());
		
		verify(productService).getProduct(123L);
	}
	
	@Test
	@DisplayName("Product 데이터 생성 테스트")
	void createProductTest() throws Exception {
		//Mock 객체에서 특정 메서드가 실행되는 경우 실제 Return을 줄 수 없기 때문에 아래와 같이 가정 사항을 만들어줌
		given(productService.saveProduct(new ProductDto("pen", 5000, 2000))).willReturn(new ProductResponseDto(12315L, "pen", 5000, 2000));
		
		ProductDto productDto = ProductDto.builder()
				.name("pen")
				.price(5000)
				.stock(2000)
				.build();
		
		Gson gson = new Gson();
		String content = gson.toJson(productDto);
		mockMvc.perform(post("/product").content(content).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.number").exists())
			.andExpect(jsonPath("$.name").exists())
			.andExpect(jsonPath("$.price").exists())
			.andExpect(jsonPath("$.stock").exists())
			.andDo(print());
		
		verify(productService).saveProduct(new ProductDto("pen", 5000, 2000));
	}
}
