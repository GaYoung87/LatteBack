package com.latte.admin.domain.cafe;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.latte.admin.domain.BaseTimeEntity;
import com.latte.admin.domain.menu.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@NoArgsConstructor
@Entity
public class Cafe extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccid;

    @Column(nullable = true)
    private String uid;  // fk

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "cafe")
    @JsonManagedReference
    private Collection<Menu> menus=new ArrayList<>();

    // 사장기반로그인 -> 카페입력하기페이지가서 아래것들 입력하기
    @Column(nullable = false)
    private String cname;

    @Column(nullable = false)
    private String cloc;

    @Column(nullable = true)
    private String cphone;

    @Column(nullable = true)
    private String cpic;

    @Column(nullable = false)
    private String copen;

    @Column(nullable = false)
    private String cclose;

    @Column(nullable = false)
    private String cdesc;

    @Column(nullable = false)
    private String cstatus;  // -1:승인X, 0:대기, 1:승인


    public Cafe(Long ccid){
        this.ccid=ccid;
    }

    @Builder
    public Cafe(String cname, String cloc, String cphone, String cpic, String copen, String cdesc, String cclose, String cstatus) {
        this.cname = cname;
        this.cloc = cloc;
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cclose = cclose;
        this.cdesc=cdesc;
        this.cstatus = cstatus;
    }

    public void CafeUpdate(String cphone,String cpic,String copen,String cclose,String cdesc,String cstatus) {
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cclose = cclose;
        this.cdesc=cdesc;
        this.cstatus = cstatus;
    }

    public void addMenu(Menu m){
        Collection<Menu> menus=getMenus();
        menus.add(m);
    }

}
