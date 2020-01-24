package com.latte.admin.service;

import com.latte.admin.domain.guest.Guest;
import com.latte.admin.domain.host.Host;
import com.latte.admin.domain.host.HostRepository;
import com.latte.admin.web.dto.guest.GuestUpdateRequestDto;
import com.latte.admin.web.dto.host.CafeListResponseDto;
import com.latte.admin.web.dto.host.CafeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    // 카페 승인상태 변경
//    @Transactional
//    public void updateStatus(Long ccid, ) {
//
//    }

    // 카페 리스트 (대기 중인 카페를 맨 위에, 승인된 카페, 거부된 카페 순) -> 거절 이유?!
    @Transactional
    public List<CafeListResponseDto> findAllDesc() {
        return hostRepository.findAllDesc().stream()
                .map(CafeListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 카페 정보 수정
    @Transactional
    public Long update(Long ccid, CafeUpdateRequestDto cafeUpdateRequestDto) {
        Host host= hostRepository.findByCcid(ccid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다."));

        host.CafeUpdate(cafeUpdateRequestDto.getCphone(),cafeUpdateRequestDto.getCpic(),cafeUpdateRequestDto.getCopen(),
                cafeUpdateRequestDto.getCclose(),cafeUpdateRequestDto.getCdesc(),cafeUpdateRequestDto.getCstatus());

        return ccid;
    }

    // 탈퇴 = 카페 삭제
    @Transactional
    public void delete(Long ccid){
        Host host= hostRepository.findByCcid(ccid)
                .orElseThrow(()-> new IllegalArgumentException("카페 정보가 없습니다."));

        hostRepository.delete(host);
    }
}
