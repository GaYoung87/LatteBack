package com.latte.admin.service;

import com.latte.admin.domain.orderdetail.OrderDetailRepository;
import com.latte.admin.web.dto.orderdetail.OrderDetailResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    // 전체 선택 -> order하나에 대한 orderDetail 보여주기
    @Transactional
    public List<OrderDetailResponseDto> findAllDesc(Long odid){
        return orderDetailRepository.findAllByOoid(odid).stream()
                .map(OrderDetailResponseDto::new)
                .collect(Collectors.toList());
    }
}
