package com.latte.admin.web.dto.order;

import com.latte.admin.domain.order.Ordered;
import com.latte.admin.domain.order.OrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDetailRequestDto {

    public OrderDetail toEntity(Long ooid) {
        return OrderDetail.builder()
                .orderSimple(new Ordered(ooid))
                .build();
    }
}
