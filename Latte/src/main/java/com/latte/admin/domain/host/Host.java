package com.latte.admin.domain.host;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hid;

    @Column(nullable = true)
    private String cafename;

    @Column(nullable = true)
    private String cafeloc;

    @Column(nullable = true)
    private String cafephone;

    @Column(nullable = true)
    private String cafepic;

    @Column(nullable = false)
    private String cafestatus;  // -1:승인X, 0:대기, 1:승인

    @Column(nullable = false)
    private String cafeopen;

    @Builder
    public Host(String cafename, String cafeloc, String cafephone, String cafepic, String cafestatus, String cafeopen) {
        this.cafename = cafename;
        this.cafeloc = cafeloc;
        this.cafephone = cafephone;
        this.cafepic = cafepic;
        this.cafestatus = cafestatus;
        this.cafeopen = cafeopen;
    }

    public void update(String cafepic, String cafestatus, String cafeopen) {
        this.cafepic = cafepic;
        this.cafestatus = cafestatus;
        this.cafeopen = cafeopen;
    }
}
