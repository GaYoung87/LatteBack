package com.latte.admin.domain.orderdetail;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    // fk -> 1:1 = orderDetail:menu
    @OneToOne
    private Menu menu;

    // fk -> 1:N = order:orderDetail
    @ManyToOne(optional = false)
    @JsonBackReference
    private Order order;

    public OrderDetail(Long odid){
        this.odid=odid;
    }

    @Builder
    public OrderDetail(Order order) {
        this.order = order;
    }
}
