package com.latte.admin.web.dto.host;

import com.latte.admin.domain.host.Host;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HostSaveRequestDto {
    private String hid;
    private String hpass;
    private String hname;
    private String hphone;
    private String hemail;
    private String hnickname;
    private String cname;
    private String cloc;
    private String cphone;
    private String cpic;
    private String copen;
    private String cstatus;

    @Builder
    public HostSaveRequestDto(String hid,String hpass,String hname,String hphone,String hemail,String hnickname,
                String cname,String cloc,String cphone,String cpic,String copen,String cstatus) {
        this.hid = hid;
        this.hpass = hpass;
        this.hname = hname;
        this.hphone = hphone;
        this.hemail = hemail;
        this.hnickname = hnickname;
        this.cname = cname;
        this.cloc = cloc;
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cstatus = cstatus;
    }

    public Host toEntity() {
        return Host.builder()
                .hid(hid)
                .hpass(hpass)
                .hname(hname)
                .hphone(hphone)
                .hemail(hemail)
                .hnickname(hnickname)
                .cname(cname)
                .cloc(cloc)
                .cphone(cphone)
                .cpic(cpic)
                .copen(copen)
                .cstatus(cstatus)
                .build();
    }
}
