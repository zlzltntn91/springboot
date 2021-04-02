package com.soo.book.springboot.web;

import com.soo.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/hello/dto/requestParam")
	public HelloResponseDto helloResponseDto_requestParam(@RequestParam("name") String name, @RequestParam("amount") int amout) {
		return new HelloResponseDto(name, amout);
	}

	@GetMapping("/hello/dto/pathVariable/{name}/{amount}")
	public HelloResponseDto helloResponseDto_pathVariable(@PathVariable("name") String name, @PathVariable("amount") int amout) {
		return new HelloResponseDto(name, amout);
	}
}

