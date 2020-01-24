package com.latte.admin.domain.orderdetail;

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

    @Column(nullable = false)
    private Long ooid;

    @Column(nullable = false)
    private Long mmid;

    public OrderDetail(Long ooid,Long mmid) {
        this.ooid=ooid;
        this.mmid=mmid;
    }
}
