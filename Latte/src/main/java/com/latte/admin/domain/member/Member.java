package com.latte.admin.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

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

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String id, String pass, String name, String phone, String email, String nickname, Role role) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
