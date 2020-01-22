package com.latte.admin.web;

import com.latte.admin.service.MemberService;
import com.latte.admin.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/saveUser/{role}")
    public Map saveMember(@RequestBody MemberRequestDto memberRequestDto, @PathVariable int role) {
        Map<String,String> map=new HashMap<>();
        if (memberService.save(role, memberRequestDto) != 0) map.put("result", "success");
        else map.put("result", "fail");
        return map;
    }
}
