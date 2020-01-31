package com.latte.admin.domain.ordersimple;

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
public class OrderSimple {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ooid;

    // fk -> 1:N = cafe:order
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cafe cafeorder;

    // fk -> 1:N = order:orderDetail
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "orderSimple")
    @JsonManagedReference
    private Collection<OrderDetail> orderDetails=new ArrayList<>();

    // fk -> 1:N = user:order -> if role=1(손님)
    @ManyToOne(optional = false)
    @JsonBackReference
    private User userorder;

    public OrderSimple(Long ooid){
        this.ooid=ooid;
    }

    @Builder
    public OrderSimple(Cafe cafeorder, User userorder){
        this.cafeorder=cafeorder;
        this.userorder=userorder;
    }

}
