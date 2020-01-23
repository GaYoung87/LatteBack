package com.latte.admin.web;

import com.latte.admin.service.MemberService;
import com.latte.admin.web.dto.MemberSaveRequestDto;
import com.latte.admin.web.dto.MemeberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    // 저장 -> 여러개 한번에 보기 MemberListResponseDto만들어서 이용하기

    // 저장 -> 사장별, 손님별로 보기
    @PostMapping("/api/saveMember/{role}")
    public Map saveMember(@RequestBody MemberSaveRequestDto memberSaveRequestDto, @PathVariable int role) {
        Map<String,String> map=new HashMap<>();
        if (memberService.save(role, memberSaveRequestDto) != 0) map.put("result", "success");
        else map.put("result", "fail");
        return map;
    }

    // 업데이트  -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemeberUpdateRequestDto memeberUpdateRequestDto){
        return memberService.update(id,memeberUpdateRequestDto);
    }
}
