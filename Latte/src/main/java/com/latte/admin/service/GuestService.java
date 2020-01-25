package com.latte.admin.service;

import com.latte.admin.domain.guest.Guest;
import com.latte.admin.domain.guest.GuestRepository;
import com.latte.admin.web.dto.guest.GuestSaveRequestDto;
import com.latte.admin.web.dto.guest.GuestUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    // 회원 가입
    // 완료하면 알아서 login페이지로 보내기!
    @Transactional
    public void signUp(GuestSaveRequestDto guestSaveRequestDto) {
        // insert 전에 테이블을 검색해서 중복된 이메일이 있는지 확인한다.
        if(guestRepository.findByEmail(guestSaveRequestDto.getGemail()) == null)
            return;

        // 이메일 인증 추가 필요~!~!~!~! 1.회원가입완료하면 이메일로 보내준다. OR 2.유효한 이메일인지 확인
        // 2번일 경우 테이블에 승인 상태 추가해야 됨

        guestRepository.save(guestSaveRequestDto.toEntity()).getGgid();
    }

    // 아이디 중복 확인
    @Transactional
    public void checkId(String gid) {
        Guest guest = guestRepository.findByGid(gid).orElseThrow(()
                -> new IllegalArgumentException("사용 가능한 아이디입니다."));

        new IllegalArgumentException("사용 불가능한 아이디입니다.");
    }

    // 아이디 찾기
    @Transactional
    public String findId(String gname, String gemail) {
        Guest guest= guestRepository.findByNameEmail(gname, gemail).orElseThrow(()
                -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        return guest.getGid();
    }

    // 비밀번호 찾기
    @Transactional
    public String findPass(String gid, String gemail) {
        Guest guest = guestRepository.findByGid(gid).orElseThrow(()
        -> new IllegalArgumentException("존재하지 않는 ID입니다."));

        if(guest.getGemail().equals(gemail)) {
            // 이메일로 비밀번호 쏴주고!!
            // 테이블에 있는 회원 비밀번호 그걸로 수정!!!!!

        } else {
            new IllegalArgumentException("존재하지 않는 ID입니다.");
        }

        return guest.getGemail();
    }

    // 비밀번호 확인 -> login로직에서 있으면 안하고, 없으면 한다!!!!!!!!!!

    // 회원 정보 수정
    @Transactional
    public String update(String gid, GuestUpdateRequestDto guestUpdateRequestDto) {
        Guest guest= guestRepository.findByGid(gid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다."));

        guest.update(guestUpdateRequestDto.getGpass(), guestUpdateRequestDto.getGphone(),
                guestUpdateRequestDto.getGnickname());

        return gid;
    }

    // 탈퇴
    @Transactional
    public void delete(String gid){
        Guest guest= guestRepository.findByGid(gid)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다."));

        guestRepository.delete(guest);
    }

    // 로그아웃 추가~~~~~~~~~~
}
