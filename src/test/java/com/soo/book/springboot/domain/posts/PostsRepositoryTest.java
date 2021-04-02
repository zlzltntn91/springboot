package com.soo.book.springboot.domain.posts;

import javafx.geometry.Pos;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanUp() {
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기() {
		postsRepository.save(Posts.builder()
									 .author("zlamstn91@gmail.com")
									 .content("내용테스트")
									 .title("제목")
									 .build());

		postsRepository.save(Posts.builder()
									 .author("zlamstn91@gmail.com")
									 .content("내용테스트2")
									 .title("제목")
									 .build());

		List<Posts> posts = postsRepository.findAll();

		Posts post = posts.get(0);
		assertThat(post.getAuthor()).isEqualTo("zlamstn91@gmail.com");
		assertThat(post.getContent()).isEqualTo("내용테스트");
		log.info(String.valueOf(posts.size()));
	}
}