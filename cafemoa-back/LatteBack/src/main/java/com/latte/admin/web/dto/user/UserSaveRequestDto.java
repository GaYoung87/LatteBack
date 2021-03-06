package com.latte.admin.web.dto.user;

import com.latte.admin.domain.user.Role;
import com.latte.admin.domain.user.User;
import com.latte.admin.service.SHA256Util;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String uid;
    private String upass;
    private String uname;
    private String uphone;
    private String uemail;
    private String unickname;
    private Role role;
    private  String upic;

    @Builder
    public UserSaveRequestDto(String uid, String upass, String uname, String uphone, String uemail, String unickname, Role role, String upic) {
        this.uid = uid;
        this.upass = upass;
        this.uname = uname;
        this.uphone = uphone;
        this.uemail = uemail;
        this.unickname = unickname;
        this.role = role;
        this.upic=upic;
    }

    public User toEntity() {
        return User.builder()
                .uid(uid)
                .upass(upass)
                .uname(uname)
                .uphone(uphone)
                .uemail(uemail)
                .unickname(unickname)
                .role(role)
                .upic(upic)
                .build();
    }
}
