package com.latte.admin.domain.order;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ooid;

    @Column(nullable = false)
    private Long ccid;

    @Column(nullable = false)
    private Long ggid;

    @Builder
    public Order(Long ccid,Long ggid) {
        this.ccid=ccid;
        this.ggid=ggid;
    }
}
