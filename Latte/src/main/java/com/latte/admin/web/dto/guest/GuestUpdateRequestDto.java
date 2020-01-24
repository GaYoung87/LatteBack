package com.latte.admin.web.dto.guest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GuestUpdateRequestDto {
    private String gpass;
    private String gphone;
    private String gnickname;

    @Builder
    public GuestUpdateRequestDto(String gpass, String gphone, String gnickname) {
        this.gpass = gpass;
        this.gphone = gphone;
        this.gnickname = gnickname;
    }
}
