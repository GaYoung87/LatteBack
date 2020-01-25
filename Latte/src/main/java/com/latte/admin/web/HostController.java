package com.latte.admin.web;

import com.latte.admin.service.GuestService;
import com.latte.admin.service.HostService;
import com.latte.admin.web.dto.guest.GuestSaveRequestDto;
import com.latte.admin.web.dto.guest.GuestUpdateRequestDto;
import com.latte.admin.web.dto.host.CafeListResponseDto;
import com.latte.admin.web.dto.host.CafeUpdateRequestDto;
import com.latte.admin.web.dto.host.HostSaveRequestDto;
import com.latte.admin.web.dto.host.HostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;


    // 회원 가입
    @PostMapping("/latte/host/signup")
    public void signUp(@RequestBody HostSaveRequestDto hostSaveRequestDto) {
        hostService.signUp(hostSaveRequestDto);
    }

    // 아이디 중복 확인
    @PostMapping("/latte/host/checkid/{hid}")
    public void checkId(@PathVariable String hid) {
        hostService.checkId(hid);
    }

    // 아이디 찾기
    @PostMapping("/latte/host/findid/{hname}/{hemail}")
    public Map findId(@PathVariable String hname, @PathVariable String hemail) {
        Map<String, String> map = new HashMap<>();
        map.put("id", hostService.findId(hname,hemail));
        return map;
    }

    // 비밀번호 찾기
    @PostMapping("/latte/host/findpass/{hid}/{hemail}")
    public Map findPass(@PathVariable String hid, @PathVariable String hemail) {
        Map<String, String> map = new HashMap<>();
        map.put("email", hostService.findPass(hid, hemail));
        return map;
    }

    // 회원 정보 수정 -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/latte/host/update/{hid}")
    public Map hostUpdate(@PathVariable String hid, @RequestBody HostUpdateRequestDto hostUpdateRequestDto) {
        Map<String,String> map = new HashMap<>();
        map.put("id",hostService.hostUpdate(hid, hostUpdateRequestDto));

        return map;
    }

    // 삭제
    @DeleteMapping("/latte/host/delete/{hid}")
    public void delete(@PathVariable String hid) {
        // 세션 해제 추가~!~!~
        hostService.delete(hid);
    }



    // 카페 승인상태 변경

    // 카페 리스트 보여주기
    @GetMapping("/latte/cafe/all")
    public List<CafeListResponseDto> selectAll(){
        return hostService.findAllDesc();
    }


    // 카페 정보 수정
    @PutMapping("/latte/cafe/update/{ccid}")
    public Map cafeUpdate(@PathVariable Long ccid, @RequestBody CafeUpdateRequestDto cafeUpdateRequestDto) {
        Map<String,Long> map = new HashMap<>();
        map.put("cafe",hostService.cafeUpdate(ccid, cafeUpdateRequestDto));

        return map;
    }


    // 카페 삭제
    @DeleteMapping("/latte/cafe/delete/{ccid}")
    public void delete(@PathVariable Long ccid) {
        // 세션 해제 추가~!~!~
        hostService.delete(ccid);
    }

}
