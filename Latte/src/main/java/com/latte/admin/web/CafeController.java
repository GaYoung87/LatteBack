package com.latte.admin.web;

import com.latte.admin.service.CafeService;
import com.latte.admin.web.dto.CafeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

//    @PostMapping("/api/savecafe")
//    public String save(@RequestBody CafeRequestDto cafeRequestDto) {
//        return cafeService.save(cafeRequestDto);
//    }
    @GetMapping("/api/saveCafe/{cid}")
    public Map saveCafe(@RequestBody CafeRequestDto cafeRequestDto, @PathVariable int cid) {
        Map<String, String> map = new HashMap<>();
        if (cafeService.save(cid, cafeRequestDto) != 0) map.put("result", "success");
        else map.put("result", "fail");
        return map;
    }

}
