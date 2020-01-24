package com.latte.admin.web;

import com.latte.admin.service.GuestService;
import com.latte.admin.web.dto.guest.GuestSaveRequestDto;
import com.latte.admin.web.dto.guest.GuestUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;


    // 회원 가입
    @PostMapping("/latte/guest/signup")
    public void signUp(@RequestBody GuestSaveRequestDto guestSaveRequestDto) {
        guestService.signUp(guestSaveRequestDto);
    }

    // 아이디 중복 확인
    @PostMapping("/latte/guest/checkid/{gid}")
    public void checkId(@PathVariable String gid) {
        guestService.checkId(gid);
    }

    // 아이디 찾기
    @PostMapping("/latte/guest/findid/{gname}/{gemail}")
    public Map findId(@PathVariable String gname, @PathVariable String gemail) {
        Map<String, String> map = new HashMap<>();
        map.put("id", guestService.findId(gname,gemail));
        return map;
    }

    // 비밀번호 찾기
    @PostMapping("/latte/guest/findpass/{gid}/{gemail}")
    public Map findPass(@PathVariable String gid, @PathVariable String gemail) {
        Map<String, String> map = new HashMap<>();
        map.put("email", guestService.findPass(gid, gemail));
        return map;
    }

    // 회원 정보 수정 -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/latte/guest/update/{gid}")
    public Map update(@PathVariable String gid, @RequestBody GuestUpdateRequestDto guestUpdateRequestDto) {
        Map<String,String> map = new HashMap<>();
        map.put("id",guestService.update(gid, guestUpdateRequestDto));

        return map;
    }

    // 삭제
    @DeleteMapping("/latte/guest/delete/{gid}")
    public void delete(@PathVariable String gid) {
        // 세션 해제 추가~!~!~
        guestService.delete(gid);
    }
}
