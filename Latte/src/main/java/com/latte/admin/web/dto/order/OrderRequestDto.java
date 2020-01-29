package com.latte.admin.web.dto.order;

import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequestDto {

    public Order toEntity(Long ccid) {
        return Order.builder()
                .cafeorder(new Cafe(ccid))
                .build();
    }

}
