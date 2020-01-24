package com.latte.admin.web;

import com.latte.admin.service.GuestService;
import com.latte.admin.web.dto.guest.GuestSaveRequestDto;
import com.latte.admin.web.dto.guest.GuestUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    // 저장 -> 여러개 한번에 보기 MemberListResponseDto만들어서 이용하기

    // 저장 -> 사장별, 손님별로 보기
    @PostMapping("/api/savemember/{role}")
    public Map saveMember(@RequestBody GuestSaveRequestDto guestSaveRequestDto, @PathVariable int role) {
        Map<String,String> map=new HashMap<>();
        if (guestService.save(role, guestSaveRequestDto) != 0) map.put("result", "success");
        else map.put("result", "fail");
        return map;
    }

    // 업데이트  -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/api/v1/member/{uid}")
    public Long update(@PathVariable Long uid, @RequestBody GuestUpdateRequestDto customerUpdateRequestDto) {
        return guestService.update(uid, customerUpdateRequestDto);
    }

    // insert -> 사장에 cafename, cafeloc 넣어보기

    // 삭제
    @DeleteMapping("/api/v1/member/{uid}")
    public Long delete(@PathVariable Long uid) {
        guestService.delete(uid);
        return uid;
    }
}
