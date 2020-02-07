package com.latte.admin.web.dto.menu;

import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.menu.Menu;
import com.latte.admin.domain.menu.MenuSize;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MenuSaveRequestDto {

    private String mname;
    private List<MenuSizeRequestDto> menuSizeRequestDtos;
    private String mpic;
    private int mmain;

    @Builder
    public MenuSaveRequestDto(String mname,List<MenuSizeRequestDto> menuSizeRequestDtos,String mpic,int mmain) {
        this.mname = mname;
        this.menuSizeRequestDtos = menuSizeRequestDtos;
        this.mpic = mpic;
        this.mmain=mmain;
    }

    public Menu toEntity(Cafe cafe) {
        return Menu.builder()
                .cafemenu(cafe) //조인용
                .mname(mname)
                .mpic(mpic)
                .mmain(mmain)
                .build();
    }

}