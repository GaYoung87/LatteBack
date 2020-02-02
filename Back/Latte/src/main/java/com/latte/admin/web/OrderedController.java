package com.latte.admin.web;

import com.latte.admin.service.OrderedService;
import com.latte.admin.web.dto.order.OrderedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class OrderedController {

    private final OrderedService orderedService;

    // cafe별 리스트 보여주기
    @GetMapping("/latte/order/all")
    public List<OrderedResponseDto> selectAll(Long ccid) {
        return orderedService.selectAll(ccid);
    }

    // order하나 보여주기 (그 안에는 많은 orderDetail존재)
    @GetMapping("/latte/order/one/{ooid}")
    public OrderedResponseDto selectOne(@PathVariable Long ooid){
        return orderedService.selectOne(ooid);
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
