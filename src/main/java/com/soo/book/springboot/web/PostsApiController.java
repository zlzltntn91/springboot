package com.soo.book.springboot.web;

import com.soo.book.springboot.service.posts.PostService;
import com.soo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/v1")
public class PostsApiController {
	private final PostService postService;

	@PostMapping("posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto){
		return postService.save(requestDto);
	}


//	public PostRe (){
////	}

}
