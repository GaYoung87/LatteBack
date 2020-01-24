package com.latte.admin.domain.guest;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Guest {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토 인크리먼트
    private Long ggid; // 1, 2, 3, ...

//    @Id  // entity의 pk는 Long 타입의 auto_increment를 추천
    @Column(nullable = false)
    private String gid;

    @Column(nullable = false)
    private String gpass;

    @Column(nullable = false)
    private String gname;

    @Column(nullable = false)
    private String gphone;

    @Column(nullable = false)
    private String gemail;

    @Column(nullable = false)
    private String gnickname;

    // 사진 처음에 입력하지 말고, 로그인 이후에 mypage에서 넣을 수 있도록 하기!!
    /* 프사!!!!!!!!!!!!!!!! */

    @Builder
    public Guest(String gid, String gpass, String gname, String gphone, String gemail, String gnickname) {
        this.gid = gid;
        this.gpass = gpass;
        this.gname = gname;
        this.gphone = gphone;
        this.gemail = gemail;
        this.gnickname = gnickname;
    }

    // 수정할
    public void update(String gpass, String gphone, String gnickname) {
        this.gpass = gpass;
        this.gphone = gphone;
        this.gnickname = gnickname;
    }

}
