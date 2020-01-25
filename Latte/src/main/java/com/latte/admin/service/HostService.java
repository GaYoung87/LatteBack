package com.latte.admin.service;

import com.latte.admin.domain.host.Host;
import com.latte.admin.domain.host.HostRepository;
import com.latte.admin.web.dto.host.CafeListResponseDto;
import com.latte.admin.web.dto.host.CafeUpdateRequestDto;
import com.latte.admin.web.dto.host.HostSaveRequestDto;
import com.latte.admin.web.dto.host.HostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    // 회원 가입
    // 완료하면 알아서 login페이지로 보내기!
    @Transactional
    public void signUp(HostSaveRequestDto hostSaveRequestDto) {
        // insert 전에 테이블을 검색해서 중복된 이메일이 있는지 확인한다.
        if(hostRepository.findByEmail(hostSaveRequestDto.getHemail()) == null)
            return;

        // 이메일 인증 추가 필요~!~!~!~! 1.회원가입완료하면 이메일로 보내준다. OR 2.유효한 이메일인지 확인
        // 2번일 경우 테이블에 승인 상태 추가해야 됨

        hostRepository.save(hostSaveRequestDto.toEntity()).getCcid();
    }

    // 아이디 중복 확인
    @Transactional
    public void checkId(String hid) {
        Host host = hostRepository.findByHid(hid).orElseThrow(()
                -> new IllegalArgumentException("사용 가능한 아이디입니다."));

        new IllegalArgumentException("사용 불가능한 아이디입니다.");
    }

    // 아이디 찾기
    @Transactional
    public String findId(String hname, String hemail) {
        Host host= hostRepository.findByNameEmail(hname, hemail).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        return host.getHid();
    }

    // 비밀번호 찾기
    @Transactional
    public String findPass(String hid, String hemail) {
        Host host = hostRepository.findByHid(hid).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 ID입니다."));

        if(host.getHemail().equals(hemail)) {
            // 이메일로 비밀번호 쏴주고!!
            // 테이블에 있는 회원 비밀번호 그걸로 수정!!!!!

        } else {
            new IllegalArgumentException("존재하지 않는 ID입니다.");
        }

        return host.getHemail();
    }

    // 비밀번호 확인 -> login로직에서 있으면 안하고, 없으면 한다!!!!!!!!!!

    // 회원 정보 수정
    @Transactional
    public String hostUpdate(String hid, HostUpdateRequestDto hostUpdateRequestDto) {
        Host host= hostRepository.findByHid(hid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다."));

        host.HostUpdate(hostUpdateRequestDto.getHpass(), hostUpdateRequestDto.getHpass(),
                hostUpdateRequestDto.getHnickname());

        return hid;
    }

    // 탈퇴
    @Transactional
    public void delete(String hid){
        Host host= hostRepository.findByHid(hid)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다."));

        hostRepository.delete(host);
    }

    // 로그아웃 추가~~~~~~~~~~











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
    public Long cafeUpdate(Long ccid, CafeUpdateRequestDto cafeUpdateRequestDto) {
        Host cafe= hostRepository.findByCcid(ccid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다."));

        cafe.CafeUpdate(cafeUpdateRequestDto.getCphone(),cafeUpdateRequestDto.getCpic(),cafeUpdateRequestDto.getCopen(),
                cafeUpdateRequestDto.getCclose(),cafeUpdateRequestDto.getCdesc(),cafeUpdateRequestDto.getCstatus());

        return ccid;
    }

    // 탈퇴 = 카페 삭제
    @Transactional
    public void delete(Long ccid){
        Host cafe= hostRepository.findByCcid(ccid)
                .orElseThrow(()-> new IllegalArgumentException("카페 정보가 없습니다."));

        hostRepository.delete(cafe);
    }
}
