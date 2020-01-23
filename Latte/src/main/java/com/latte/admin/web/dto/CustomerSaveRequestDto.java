package com.latte.admin.web.dto;

import com.latte.admin.domain.customer.Customer;
import com.latte.admin.domain.customer.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CustomerSaveRequestDto {
    private String id;
    private String pass;
    private String name;
    private String phone;
    private String email;
    private String nickname;
    private String upicture;
    private Role role;

    @Builder
    public CustomerSaveRequestDto(String id, String pass, String name, String phone, String email, String nickname, String upicture, Role role) {
        this.id=id;
        this.name=name;
        this.pass=pass;
        this.phone=phone;
        this.email=email;
        this.nickname=nickname;
        this.upicture=upicture;
        this.role=role;
    }

    public Customer toEntity(Role role) {
        return Customer.builder()
                .id(id)
                .pass(pass)
                .name(name)
                .phone(phone)
                .email(email)
                .nickname(nickname)
                .upicture(upicture)
                .role(role)
                .build();
    }
}
