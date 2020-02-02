package com.latte.admin.service;

import com.latte.admin.domain.order.OrderedRepository;
import com.latte.admin.web.dto.order.OrderedRequestDto;
import com.latte.admin.web.dto.order.OrderedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderedService {

    private final OrderedRepository orderedRepository;

    // 카페 기준 모든 주문 선택
    @Transactional
    public List<OrderedResponseDto> selectAll(Long ccid){
        return orderedRepository.findAllByCcid(ccid).stream()
                .map(OrderedResponseDto::new)
                .collect(Collectors.toList());
    }

    // 하나 주문 선택
    @Transactional
    public OrderedResponseDto selectOne(Long ooid){
        return new OrderedResponseDto(orderedRepository.findByOoid(ooid));
    }

    // 저장
    @Transactional
    public Long save(OrderedRequestDto orderedRequestDto, Long ccid, Long uuid) {
        return orderedRepository.save(orderedRequestDto.toEntity(ccid, uuid)).getOoid();
    }
}
