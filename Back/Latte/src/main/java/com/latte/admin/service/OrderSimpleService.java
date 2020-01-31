package com.latte.admin.service;

import com.latte.admin.domain.order.OrderRepository;
import com.latte.admin.web.dto.ordersimple.OrderSimpleRequestDto;
import com.latte.admin.web.dto.ordersimple.OrderSimpleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderSimpleService {

    private final OrderRepository orderRepository;

    // 카페 기준 모든 주문 선택
    @Transactional
    public List<OrderSimpleResponseDto> selectAll(Long ccid){
        return orderRepository.findAllByCcid(ccid).stream()
                .map(OrderSimpleResponseDto::new)
                .collect(Collectors.toList());
    }

    // 하나 주문 선택
    @Transactional
    public OrderSimpleResponseDto selectOne(Long ooid){
        return new OrderSimpleResponseDto(orderRepository.findByOoid(ooid));
    }

    // 저장
    @Transactional
    public Long save(OrderSimpleRequestDto orderSimpleRequestDto, Long ccid, Long uuid) {
        return orderRepository.save(orderSimpleRequestDto.toEntity(ccid, uuid)).getOoid();
    }

}
