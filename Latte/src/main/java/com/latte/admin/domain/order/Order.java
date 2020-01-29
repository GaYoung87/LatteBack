package com.latte.admin.domain.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.orderdetail.OrderDetail;
import com.latte.admin.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ooid;

    // fk -> 1:N = cafe:order
    // 카페 정보 받아옴
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cafe cafeorder;

    // fk -> 1:N = user:order -> if role=1(손님)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Order userorder;

    // fk -> 1:N = order:orderDetail
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private Collection<OrderDetail> orderDetails=new ArrayList<>();


    public Order(Long ooid){
        this.ooid=ooid;
    }

    @Builder
    public Order(Cafe cafeorder, Order userorder){
        this.cafeorder=cafeorder;
        this.userorder=userorder;
    }

}
