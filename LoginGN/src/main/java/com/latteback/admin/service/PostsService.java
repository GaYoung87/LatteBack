package com.latteback.admin.service;

import com.latteback.admin.domain.posts.Posts;
import com.latteback.admin.domain.posts.PostsRepository;
import com.latteback.admin.web.dto.PostsListResponseDto;
import com.latteback.admin.web.dto.PostsResponseDto;
import com.latteback.admin.web.dto.PostsSaveRequestDto;
import com.latteback.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts=postsRepository.findById(id).orElseThrow(()
                        -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts posts=postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));


        postsRepository.delete(posts);
        //JpaRepository에서 이미 delete 메소드를 지원하고 있으니 이를 활용합니다.
        //엔티티를 파라미터로 삭제할 수도 있고, deleteById 메소드를 이용하면 id로 삭제할 수도 있습니다.
        //존재하는 Posts인지 확인을 위해 조회 후 그대로 삭제합니다.
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity=postsRepository.findById(id)
                .orElseThrow(()
                        ->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }


    @Transactional(readOnly = true)//여기서 readOnly=true 를 주면 트랜잭션 범위는 유지하되,
    // 조회 기능만 남겨두어 조회 속도가 개선되기 때문에 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천합니다.
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
        //.map(PostsListResponseDto::new) 는 .map(posts-> new PostsListResponseDto(posts)) 와 동일한 식입니다.
    }
    //즉 위 메소드는 postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListResponseDto 변환 -> List로 반환하는 메소드입니다.
}
