package com.latte.admin.web;

import com.latte.admin.service.OrderDetailService;
import com.latte.admin.web.dto.orderdetail.OrderDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    // 주문메뉴 리스트 보여주기
    @GetMapping("/latte/orderdetail/all")
    public List<OrderDetailResponseDto> selectAll(Long ooid) {
        return orderDetailService.findAllDesc(ooid);
    }

}
