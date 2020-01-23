package com.latte.admin.web.dto;

import com.latte.admin.domain.member.Member;
import com.latte.admin.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {
    private String id;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String nickname;
    private String upicture;
    private Role role;

    @Builder
    public MemberSaveRequestDto(String id, String pass, String name, String phone, String email, String nickname, String upicture, Role role) {
        this.id=id;
        this.name=name;
        this.pass=pass;
        this.phone=phone;
        this.email=email;
        this.nickname=nickname;
        this.upicture=upicture;
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
                .upicture(upicture)
                .role(role)
                .build();
    }
}
