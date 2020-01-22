package com.latte.admin.web.dto;

import com.latte.admin.domain.member.Member;
import com.latte.admin.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String id;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String nickname;
    private Role role;

    @Builder
    public MemberRequestDto(String id,String pass, String name,String phone,String email,String nickname,Role role) {
        this.id=id;
        this.name=name;
        this.pass=pass;
        this.phone=phone;
        this.email=email;
        this.nickname=nickname;
        this.role=role;
    }

    public Member toEntity(Role role) {
        return Member.builder()
                .id(id)
                .pass(pass)
                .name(name)
                .phone(phone)
                .email(email)
                .nickname(nickname)
                .role(role)
                .build();


    }
}
