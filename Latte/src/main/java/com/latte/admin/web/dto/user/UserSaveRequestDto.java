package com.latte.admin.web.dto.user;

import com.latte.admin.domain.user.Role;
import com.latte.admin.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String uid;
    private String upass;
    private String uname;
    private String uphone;
    private String uemail;
    private String unickname;
    private String upicture;
    private Role role;

    @Builder
    public UserSaveRequestDto(String uid, String upass, String uname, String uphone, String uemail, String unickname, String upicture, Role role) {
        this.uid = uid;
        this.upass = upass;
        this.uname = uname;
        this.uphone = uphone;
        this.uemail = uemail;
        this.unickname = unickname;
        this.upicture = upicture;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .uid(uid)
                .upass(upass)
                .uname(uname)
                .uphone(uphone)
                .uemail(uemail)
                .unickname(unickname)
                .upicture(upicture)
                .role(role)
                .build();
    }
}
