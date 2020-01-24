package com.latte.admin.web.dto.guest;

import com.latte.admin.domain.guest.Guest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class GuestSaveRequestDto {
    private String gid;
    private String gpass;
    private String gname;
    private String gphone;
    private String gemail;
    private String gnickname;

    @Builder
    public GuestSaveRequestDto(String gid, String gpass, String gname, String gphone, String gemail, String gnickname) {
        this.gid=gid;
        this.gpass=gpass;
        this.gname=gname;
        this.gphone=gphone;
        this.gemail=gemail;
        this.gnickname=gnickname;
    }

    public Guest toEntity() {
        return Guest.builder()
                .gid(gid)
                .gpass(gpass)
                .gname(gname)
                .gphone(gphone)
                .gemail(gemail)
                .gnickname(gnickname)
                .build();
    }
}
