package com.latte.admin.web.dto.orderdetail;

import com.latte.admin.domain.orderdetail.OrderDetail;
import lombok.Getter;

@Getter
public class OrderDetailResponseDto {
    private Long odid;
    private Long ooid;

    public OrderDetailResponseDto(OrderDetail entity) {
        this.odid = entity.getOdid();
        this.ooid = entity.getOrder().getOoid();
    }
}
