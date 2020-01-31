package com.latte.admin.web.dto.order;

import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.order.Order;
import com.latte.admin.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequestDto {

    public Order toEntity(Long ccid, Long uuid) {
        return Order.builder()
                .cafeorder(new Cafe(ccid))
                .userorder(new User(uuid))
                .build();
    }

}
