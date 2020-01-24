package com.latte.admin.web.dto.guest;

import com.latte.admin.domain.guest.Guest;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class GuestResponseDto {

    private Long ggid;
    private String gid;
    private String gpass;
    private String gname;
    private String gphone;
    private String gemail;
    private String gnickname;

    public GuestResponseDto(Guest entity) {
        this.ggid = entity.getGgid();
        this.gid = entity.getGid();
        this.gpass = entity.getGpass();
        this.gname = entity.getGname();
        this.gphone = entity.getGphone();
        this.gemail = entity.getGemail();
        this.gnickname = entity.getGnickname();
    }
}
