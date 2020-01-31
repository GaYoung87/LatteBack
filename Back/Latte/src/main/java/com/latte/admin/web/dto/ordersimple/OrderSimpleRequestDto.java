package com.latte.admin.web.dto.ordersimple;

import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.ordersimple.OrderSimple;
import com.latte.admin.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderSimpleRequestDto {

    public OrderSimple toEntity(Long ccid, Long uuid) {
        return OrderSimple.builder()
                .cafeorder(new Cafe(ccid))
                .userorder(new User(uuid))
                .build();
    }

}
