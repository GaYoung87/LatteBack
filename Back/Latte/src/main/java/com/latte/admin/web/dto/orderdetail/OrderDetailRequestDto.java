package com.latte.admin.web.dto.orderdetail;

import com.latte.admin.domain.order.Order;
import com.latte.admin.domain.orderdetail.OrderDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderDetailRequestDto {

    public OrderDetail toEntity(Long ooid) {
        return OrderDetail.builder()
                .orderSimple(new Order(ooid))
                .build();
    }
}
