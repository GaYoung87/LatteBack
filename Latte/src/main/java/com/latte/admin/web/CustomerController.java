package com.latte.admin.web;

import com.latte.admin.service.CustomerService;
import com.latte.admin.web.dto.CustomerSaveRequestDto;
import com.latte.admin.web.dto.CustomerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    // 저장 -> 여러개 한번에 보기 MemberListResponseDto만들어서 이용하기

    // 저장 -> 사장별, 손님별로 보기
    @PostMapping("/api/savemember/{role}")
    public Map saveMember(@RequestBody CustomerSaveRequestDto customerSaveRequestDto, @PathVariable int role) {
        Map<String,String> map=new HashMap<>();
        if (customerService.save(role, customerSaveRequestDto) != 0) map.put("result", "success");
        else map.put("result", "fail");
        return map;
    }

    // 업데이트  -> mypage에서 pass, nickname, phone 변경 가능
    @PutMapping("/api/v1/member/{uid}")
    public Long update(@PathVariable Long uid, @RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) {
        return customerService.update(uid, customerUpdateRequestDto);
    }

    // insert -> 사장에 cafename, cafeloc 넣어보기

    // 삭제
    @DeleteMapping("/api/v1/member/{uid}")
    public Long delete(@PathVariable Long uid) {
        customerService.delete(uid);
        return uid;
    }
}
