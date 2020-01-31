package com.latte.admin.web;

import com.latte.admin.service.OrderSimpleService;
import com.latte.admin.web.dto.menu.MenuResponseDto;
import com.latte.admin.web.dto.menu.MenuSaveRequestDto;
import com.latte.admin.web.dto.ordersimple.OrderSimpleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class OrderSimpleController {

    private final OrderSimpleService orderSimpleService;

    // cafe별 리스트 보여주기
    @GetMapping("/latte/order/all")
    public List<OrderSimpleResponseDto> selectAll(Long ccid) {
        return orderSimpleService.selectAll(ccid);
    }

    // order하나 보여주기 (그 안에는 많은 orderDetail존재)
    @GetMapping("/latte/order/one/{ooid}")
    public OrderSimpleResponseDto selectOne(@PathVariable Long ooid){
        return orderSimpleService.selectOne(ooid);
    }

//    // 저장
//    @PostMapping("/latte/order/{ooid}")
//    public Map save(@RequestBody MenuSaveRequestDto menuSaveRequestDto, @PathVariable Long ccid) {
//        Map<String,String> map=new HashMap<>();
//
//        if(orderSimpleService.save(menuSaveRequestDto,ccid)>0) map.put("Result","Success");
//        else map.put("Result","Fail");
//
//        return map;
//    }


}
