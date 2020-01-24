package com.latte.admin.web.dto.host;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HostUpdateRequestDto {
    private String hpass;
    private String hphone;
    private String hnickname;

    @Builder
    public HostUpdateRequestDto(String hpass,String hphone,String hnickname) {
        this.hpass = hpass;
        this.hphone = hphone;
        this.hnickname = hnickname;
    }
}
