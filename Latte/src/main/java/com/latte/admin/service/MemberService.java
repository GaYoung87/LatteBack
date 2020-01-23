package com.latte.admin.service;

import com.latte.admin.domain.member.Member;
import com.latte.admin.domain.member.MemberRepository;
import com.latte.admin.domain.member.Role;
import com.latte.admin.web.dto.MemberSaveRequestDto;
import com.latte.admin.web.dto.MemeberUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    // 저장 -> 사장별, 손님별 보기
    @Transactional
    public Long save(int role, MemberSaveRequestDto memberSaveRequestDto) {
        if (role==1) return memberRepository.save(memberSaveRequestDto.toEntity(Role.HOST)).getUid();
        else return memberRepository.save(memberSaveRequestDto.toEntity(Role.GUEST)).getUid();
    }

    // 업데이트
    @Transactional
    public Long update(Long uid, MemeberUpdateRequestDto memeberUpdateRequestDto) {
        Member members=memberRepository.findById(uid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. id="+uid));

        members.update(memeberUpdateRequestDto.getPass(),memeberUpdateRequestDto.getPhone(),
                memeberUpdateRequestDto.getNickname(),memeberUpdateRequestDto.getUpicture());

        return uid;
    }

    // 삭제
    @Transactional
    public void delete(Long uid){
        Member members=memberRepository.findById(uid)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+uid));


        memberRepository.delete(members);
    }

}
