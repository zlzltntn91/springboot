package com.soo.book.springboot.web;

import com.soo.book.springboot.service.posts.PostService;
import com.soo.book.springboot.web.dto.PostResponseDto;
import com.soo.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController("/api/v1")
public class PostsApiController {
	private final PostService postService;

	@PostMapping("posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto){
		return postService.save(requestDto);
	}

//	@PutMapping("posts/{id}")
//	public PostResponseDto findById(@PathVariable long id){
//		return
//	}

}
