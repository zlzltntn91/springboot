package com.soo.book.springboot.web.dto;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
public class HelloResponseDtoTest {

	static HelloResponseDto dto;

	@BeforeClass
	public static void setUp() {
		dto = new HelloResponseDto("김은수", 3000);
	}

	@Test
	public void getName() {
		assertThat(dto.getName()).isEqualTo("김은수");
	}

	@Test
	public void getAmout() {
		assertThat(dto.getAmount()).isEqualTo(3000);
	}
}