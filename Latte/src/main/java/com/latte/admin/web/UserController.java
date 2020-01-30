package com.latte.admin.web;

import com.latte.admin.service.UserService;
import com.latte.admin.web.dto.user.UserSaveRequestDto;
import com.latte.admin.web.dto.user.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    // 회원 가입
    @PostMapping("/latte/user/signup")
    public void signUp(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        userService.signUp(userSaveRequestDto);
    }

    // 아이디 중복 확인
    @PostMapping("/latte/user/checkid/{uid}")
    public void checkId(@PathVariable String uid) {
        userService.checkId(uid);
    }

    // 아이디 찾기
    @PostMapping("/latte/user/findid/{uname}/{uemail}")
    public Map findId(@PathVariable String uname, @PathVariable String uemail) {
        Map<String, String> map = new HashMap<>();
        map.put("id", userService.findId(uname,uemail));
        return map;
    }

    // 비밀번호 찾기
    @PostMapping("/latte/user/findpass/{uid}/{uemail}")
    public Map findPass(@PathVariable String uid, @PathVariable String uemail) {
        Map<String, String> map = new HashMap<>();
        map.put("email", userService.findPass(uid, uemail));
        return map;
    }

    // 비밀번호 확인 -> login로직에서 있으면 안하고, 없으면 한다!!!!!!!!!!

    // 회원 정보 수정 -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/latte/user/update/{uid}")
    public Map update(@PathVariable String uid, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
        Map<String,String> map = new HashMap<>();
        map.put("id", userService.update(uid, userUpdateRequestDto));

        return map;
    }

    // 탈퇴(삭제)
    @DeleteMapping("/latte/user/delete/{uid}")
    public void delete(@PathVariable String uid) {
        // 세션 해제 추가~!~!~
        userService.delete(uid);
    }
}
