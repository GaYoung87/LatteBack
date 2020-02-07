package com.latte.admin.web.dto.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuMainRequestDto {
    private Long mmid;
    private int mmain;

    @Builder
    public MenuMainRequestDto(Long mmid, int mmain) {
        this.mmid=mmid;
        this.mmain=mmain;
    }
}
