package com.latte.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HostUpdateRequestDto {
    private String cafepic;
    private String cafestatus;
    private String cafeopen;

    @Builder
    public HostUpdateRequestDto(String cafepic, String cafestatus, String cafeopen) {
        this.cafepic = cafepic;
        this.cafestatus = cafestatus;
        this.cafeopen = cafeopen;
    }
}
