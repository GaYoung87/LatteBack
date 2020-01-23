package com.latte.admin.domain.cafe;

import com.latte.admin.domain.member.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(nullable = false)
    private String cafename;

    @Column(nullable = false)
    private String cafeloc;

    @Column(nullable = false)
    private String cafephone;

    @Column(nullable = false)
    private String cafepic;

    @Column(nullable = false)
    private String cafestatus;

    @Column(nullable = false)
    private String cafeopen;

    @Builder
    public Cafe(String cafename, String cafeloc, String cafephone, String cafepic, String cafestatus, String cafeopen) {
        this.cafename = cafename;
        this.cafeloc = cafeloc;
        this.cafephone = cafephone;
        this.cafepic = cafepic;
        this.cafestatus = cafestatus;
        this.cafeopen = cafeopen;
    }
}
