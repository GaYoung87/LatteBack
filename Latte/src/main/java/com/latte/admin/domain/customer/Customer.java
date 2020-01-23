package com.latte.admin.domain.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

//    @Id  // entity의 pk는 Long 타입의 auto_increment를 추천
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    // 사진 mypage에서 넣을 수 있도록!
    @Column(nullable = true)
    private String upicture;


    @Builder
    public Customer(String id, String pass, String name, String phone, String email, String nickname, String upicture, Role role) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.upicture = upicture;
    }

    public void update(String pass, String phone, String nickname, String upicture) {
        this.pass = pass;
        this.phone = phone;
        this.nickname = nickname;
        this.upicture = upicture;
    }

}
