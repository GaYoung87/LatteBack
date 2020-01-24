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
    private String cphone;
    private String cpic;
    private String copen;
    private String cstatus;  // -1:승인X, 0:대기, 1:승인

    @Builder
    public HostUpdateRequestDto(String hpass,String hphone,String hnickname,String cphone,String cpic,String copen,String cstatus) {
        this.hpass = hpass;
        this.hphone = hphone;
        this.hnickname = hnickname;
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cstatus = cstatus;
    }
}
