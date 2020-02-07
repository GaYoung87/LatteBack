package com.latte.admin.web.dto.menu;


import com.latte.admin.domain.menu.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuListResponseDto {
    private Long mmid;
    private String mname;
    private String mpic;

    @Builder
    public MenuListResponseDto(Menu entity) {
        this.mmid=entity.getMmid();
        this.mname=entity.getMname();
        this.mpic=entity.getMpic();
    }
}
