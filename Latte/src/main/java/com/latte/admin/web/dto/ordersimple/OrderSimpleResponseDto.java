package com.latte.admin.web.dto.ordersimple;

import com.latte.admin.domain.ordersimple.OrderSimple;
import lombok.Getter;

@Getter
public class OrderSimpleResponseDto {
    private Long ooid;
    private Long ccid;
    private Long uuid;

    public OrderSimpleResponseDto(OrderSimple entity) {
        this.ooid = entity.getOoid();
        this.ccid = entity.getCafeorder().getCcid();
        this.uuid = entity.getUserorder().getUuid();
    }
}
