package com.latte.admin.web.dto;

import com.latte.admin.domain.host.Host;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HostSaveRequestDto {
    private String cafename;
    private String cafeloc;
    private String cafephone;
    private String cafepic;
    private String cafestatus;
    private String cafeopen;

    @Builder
    public HostSaveRequestDto(String cafename, String cafeloc, String cafephone, String cafepic, String cafestatus, String cafeopen) {
        this.cafename = cafename;
        this.cafeloc = cafeloc;
        this.cafephone = cafephone;
        this.cafepic = cafepic;
        this.cafestatus = cafestatus;
        this.cafeopen = cafeopen;
    }

    public Host toEntity() {
        return Host.builder()
                .cafename(cafename)
                .cafeloc(cafeloc)
                .cafephone(cafephone)
                .cafepic(cafepic)
                .cafestatus(cafestatus)
                .cafeopen(cafeopen)
                .build();
    }
}
