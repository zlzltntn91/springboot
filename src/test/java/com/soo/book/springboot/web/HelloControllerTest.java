package com.soo.book.springboot.web;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
@Slf4j
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void hello() throws Exception {
		mvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
	}

	@Test
	public void requestParam() throws Exception {

		mvc.perform(get("/hello/dto/requestParam")
							.param("name", "김은수")
							.param("amount", "3000")
							.characterEncoding("UTF-8")
		)
				.andExpect(jsonPath("$.name", is("김은수")))
				.andExpect(jsonPath("$.amount", is(3000)));
	}

	@Test
	public void requestParam_nonParam() throws Exception {
		mvc.perform(get("/hello/dto/requestParam"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void requestParam_pathVariable() throws Exception {
		mvc.perform(get("/hello/dto/pathVariable/김은수/3000"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is("김은수")))
				.andExpect(jsonPath("$.amount", is(3000)));

	}

	@Test
	public void requestParam_pathVariable_nonParam() throws Exception {
		mvc.perform(get("/hello/dto/pathVariable"))
				.andExpect(status().isNotFound());
	}


}