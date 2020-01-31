package com.latte.admin.web;

import com.latte.admin.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    // cafe별 리스트 보여주기
    @GetMapping("/latte/order/all")
    public List<OrderResponseDto> selectAll(Long ccid) {
        return orderService.selectAll(ccid);
    }

    // order하나 보여주기 (그 안에는 많은 orderDetail존재)
    @GetMapping("/latte/order/one/{ooid}")
    public OrderSimpleResponseDto selectOne(@PathVariable Long ooid){
        return orderService.selectOne(ooid);
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
