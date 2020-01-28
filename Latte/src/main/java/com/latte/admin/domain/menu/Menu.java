package com.latte.admin.domain.menu;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.cafe.CafeRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mmid;

    // fk -> 1:N = cafe:menu
    // 카페 정보 받아옴
    @ManyToOne(optional = false)
    @JsonBackReference
    private Cafe cafe;

    @Column(nullable = false)
    private String mname;

    @Column(nullable = false)
    private String mprice;

    @Column(nullable = false)
    private String mpic;

    @Builder
    public Menu(Cafe cafe, String mname,String mprice,String mpic) {
       this.cafe=cafe;
        this.mname=mname;
        this.mprice=mprice;
        this.mpic=mpic;
    }

    public void update(String mname,String mprice,String mpic) {
        this.mname=mname;
        this.mprice=mprice;
        this.mpic=mpic;
    }
}
