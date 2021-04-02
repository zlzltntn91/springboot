package com.soo.book.springboot.web;

import com.soo.book.springboot.domain.posts.PostsRepository;
import com.soo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Slf4j
@ToString
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	public PostsRepository postsRepository;

	@After
	public void tearDown() throws Exception {
		postsRepository.deleteAll();
	}

	@Test
	public void Post등록() {
		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
				.title("Title is im Dto")
				.content("Data transfer object")
				.author("zlamstn91@gmail.com")
				.build();
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity("/api/v1/posts", requestDto, Long.class);
		assertThat(responseEntity.getStatusCode().value()).isEqualTo(200);
		assertThat(responseEntity.getBody()).isEqualTo(1L);
		log.info(postsRepository.findAll().toString());
	}
}