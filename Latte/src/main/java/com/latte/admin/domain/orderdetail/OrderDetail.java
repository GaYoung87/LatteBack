package com.latte.admin.domain.orderdetail;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.menu.Menu;
import com.latte.admin.domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long odid;

    // fk -> 1:N = order:orderDetail
    // 주문 정보 받아옴
    @ManyToOne(optional = false)
    @JsonBackReference
    private Order order;

    // fk -> 1:1 = orderDetail:menu
    @OneToOne(cascade = CascadeType.ALL)
    private Menu menu;

    @Builder
    public OrderDetail(Order order, Menu menu) {
        this.order=order;
        this.menu=menu;
    }
}
