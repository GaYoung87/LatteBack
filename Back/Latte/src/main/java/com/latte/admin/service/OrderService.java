package com.latte.admin.service;

import com.latte.admin.domain.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 카페 기준 모든 주문 선택
    @Transactional
    public List<OrderResponseDto> selectAll(Long ccid){
        return orderRepository.findAllByCcid(ccid).stream()
                .map(OrderResponseDto::new)
                .collect(Collectors.toList());
    }

    // 하나 주문 선택
    @Transactional
    public OrderResponseDto selectOne(Long ooid){
        return new OrderResponseDto(orderRepository.findByOoid(ooid));
    }

    // 저장
    @Transactional
    public Long save(com.latte.admin.web.dto.order.OrderRequestDto orderRequestDto, Long ccid, Long uuid) {
        return orderRepository.save(orderRequestDto.toEntity(ccid, uuid)).getOoid();
    }
}
