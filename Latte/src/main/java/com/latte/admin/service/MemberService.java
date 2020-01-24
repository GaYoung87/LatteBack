package com.latte.admin.service;

import com.latte.admin.domain.member.MemberRepository;
import com.latte.admin.domain.member.Role;
import com.latte.admin.web.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(int role, MemberRequestDto memberRequestDto) {
        if (role==1) return memberRepository.save(memberRequestDto.toEntity(Role.HOST)).getUid();
        else return memberRepository.save(memberRequestDto.toEntity(Role.GUEST)).getUid();
    }
}
