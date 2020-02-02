package com.latte.admin.web.dto.order;

import com.latte.admin.domain.cafe.Cafe;
import com.latte.admin.domain.order.Ordered;
import com.latte.admin.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderedRequestDto {

    public Ordered toEntity(Long ccid, Long uuid) {
        return Ordered.builder()
                .cafeorder(new Cafe(ccid))
                .userorder(new User(uuid))
                .build();
    }

}
