package com.latte.admin.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토 인크리먼트
    private Long uuid; // 1, 2, 3, ...

    //    @Id  // entity의 pk는 Long 타입의 auto_increment를 추천
        @Column(nullable = false)
        private String uid;

        @Column(nullable = false)
        private String upass;

        @Column(nullable = false)
        private String uname;

        @Column(nullable = false)
        private String uphone;

        @Column(nullable = false)
        private String uemail;

        @Column(nullable = false)
        private String unickname;

        @Column(nullable = true)
        private String upicture;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Role role;

    // 사진 처음에 입력하지 말고, 로그인 이후에 mypage에서 넣을 수 있도록 하기!!
    /* 프사!!!!!!!!!!!!!!!! */

    @Builder
    public User(String uid, String upass, String uname, String uphone, String uemail, String unickname, String upicture, Role role) {
        this.uid = uid;
        this.upass = upass;
        this.uname = uname;
        this.uphone = uphone;
        this.uemail = uemail;
        this.unickname = unickname;
        this.upicture = upicture;
        this.role = role;
    }

    // 수정할
    public void update(String upass, String uphone, String unickname, String upicture) {
        this.upass = upass;
        this.uphone = uphone;
        this.unickname = unickname;
        this.upicture = upicture;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
