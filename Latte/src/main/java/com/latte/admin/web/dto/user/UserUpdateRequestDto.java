package com.latte.admin.web.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
    private String upass;
    private String uphone;
    private String unickname;

    @Builder
    public UserUpdateRequestDto(String upass, String uphone, String unickname) {
        this.upass = upass;
        this.uphone = uphone;
        this.unickname = unickname;
    }
}
