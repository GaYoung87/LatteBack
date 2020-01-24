package com.latte.admin.domain.host;

import com.latte.admin.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Host extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ccid;

//    @Id  // entity의 pk는 Long 타입의 auto_increment를 추천
    @Column(nullable = false)
    private String hid;

    @Column(nullable = false)
    private String hpass;

    @Column(nullable = false)
    private String hname;

    @Column(nullable = false)
    private String hphone;

    @Column(nullable = false)
    private String hemail;

    @Column(nullable = false)
    private String hnickname;

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

    @Builder
    public Host(String hid,String hpass,String hname,String hphone,String hemail,String hnickname,
                String cname,String cloc,String cphone,String cpic,String copen,String cdesc,String cclose,String cstatus) {
        this.hid = hid;
        this.hpass = hpass;
        this.hname = hname;
        this.hphone = hphone;
        this.hemail = hemail;
        this.hnickname = hnickname;
        this.cname = cname;
        this.cloc = cloc;
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cclose = cclose;
        this.cdesc=cdesc;
        this.cstatus = cstatus;
    }

    public void HostUpdate(String hpass,String hphone,String hnickname) {
        this.hpass = hpass;
        this.hphone = hphone;
        this.hnickname = hnickname;
    }

    public void CafeUpdate(String cphone,String cpic,String copen,String cclose,String cdesc,String cstatus) {
        this.cphone = cphone;
        this.cpic = cpic;
        this.copen = copen;
        this.cclose = cclose;
        this.cdesc=cdesc;
        this.cstatus = cstatus;
    }
}
