package com.latte.admin.web.dto.order;

import com.latte.admin.domain.order.OrderDetail;
import lombok.Getter;

@Getter
public class OrderDetailResponseDto {
    private Long odid;
    private Long ooid;

    public OrderDetailResponseDto(OrderDetail entity) {
        this.odid = entity.getOdid();
        this.ooid = entity.getOrdered().getOoid();
    }
}
