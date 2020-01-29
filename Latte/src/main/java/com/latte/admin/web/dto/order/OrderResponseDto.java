package com.latte.admin.web.dto.order;

import com.latte.admin.domain.order.Order;
import lombok.Getter;

@Getter
public class OrderResponseDto {
    private Long ooid;
    private Long ccid;

    public OrderResponseDto(Order entity) {
        this.ooid = entity.getOoid();
        this.ccid = entity.getCafeorder().getCcid();
    }
}
