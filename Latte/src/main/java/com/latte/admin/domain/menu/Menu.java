package com.latte.admin.domain.menu;

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

    @Column(nullable = false)
    private Long ccid;  //fk

    @Column(nullable = false)
    private String mname;

    @Column(nullable = false)
    private String mprice;

    @Column(nullable = false)
    private String mpic;

    @Builder
    public Menu(Long ccid,String mname,String mprice,String mpic) {
        this.ccid=ccid;
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
