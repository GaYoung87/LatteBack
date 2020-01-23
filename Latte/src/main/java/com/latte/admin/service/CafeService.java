package com.latte.admin.service;

import com.latte.admin.domain.cafe.CafeRepository;
import com.latte.admin.web.dto.CafeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    @Transactional
    public Long save(int cid, CafeRequestDto cafeRequestDto) {
        return cafeRepository.save(cafeRequestDto.toEntity()).getCid();
    }


}
