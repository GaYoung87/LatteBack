package com.latteback.admin.web;

import com.latteback.admin.service.PostsService;
import com.latteback.admin.web.dto.PostsListResponseDto;
import com.latteback.admin.web.dto.PostsResponseDto;
import com.latteback.admin.web.dto.PostsSaveRequestDto;
import com.latteback.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @GetMapping("/api/all")
    public List<PostsListResponseDto> selectAll(){
        return postsService.findAllDesc();
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
