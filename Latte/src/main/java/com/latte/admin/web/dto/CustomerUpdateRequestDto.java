package com.latte.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerUpdateRequestDto {
    private String pass;
    private String phone;
    private String nickname;
    private String upicture;

    @Builder
    public CustomerUpdateRequestDto(String pass, String phone, String nickname, String upicture) {
        this.pass = pass;
        this.phone = phone;
        this.nickname = nickname;
        this.upicture = upicture;
    }
}
