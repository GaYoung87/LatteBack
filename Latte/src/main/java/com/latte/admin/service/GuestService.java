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

    // 저장
    @Transactional
    public Long save(GuestSaveRequestDto guestSaveRequestDto) {
        return guestRepository.save(guestSaveRequestDto.toEntity()).getGgid();
    }

    // 업데이트
    @Transactional
    public String update(String gid, GuestUpdateRequestDto customerUpdateRequestDto) {
        Guest guest= guestRepository.findByGid(gid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. id="+gid));

        guest.update(customerUpdateRequestDto.getGpass(), customerUpdateRequestDto.getGphone(),
                customerUpdateRequestDto.getGnickname());

        return gid;
    }

    // 삭제
    @Transactional
    public void delete(Long uid){
        Guest members= guestRepository.findById(uid)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+uid));


        guestRepository.delete(members);
    }

}
