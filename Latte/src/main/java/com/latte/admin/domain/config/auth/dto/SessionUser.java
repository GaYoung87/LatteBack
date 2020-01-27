package com.latte.admin.domain.config.auth.dto;

import com.latte.admin.domain.guest.Guest;
import com.latte.admin.domain.host.Host;
import lombok.Getter;

import java.io.Serializable;

//SessionUser에는 인증된 사용자 정보만 필요합니다. 그 외에 필요한 정보들은 없으니 name, email, picture만 필드로 선언합니다.
@Getter
public class SessionUser implements Serializable {
    private String gname;
    private String gemail;
//    private String gpicture;

    private String hname;
    private String hemail;
//    private String hpicture;

    public SessionUser(Guest guest, Host host){
        this.gname=guest.getGname();
        this.gemail=guest.getGemail();

        this.hname=host.getHname();
        this.hemail=host.getHemail();
    }
}

/*
왜 User 클래스를 사용하면 안되나요?
만약 User 클래스를 그대로 사용했다면 다음과 같은 에러가 발생합니다.
Failed to convert from type [java.lang.Object] to type [byte[]] for value 'com.latteback.admin.domain.user.User@4a43d6'
이는 세션에 저장하기 위해 User 클래스를 세션에 저장하려고 하니, User 클래스에 직렬화를 구현하지 않았다는 의미의 에러입니다.
그럼 오류를 해결하기 위해 User 클래스에 직렬화 코드를 넣으면 어떨까요? 이것도 생각해 볼 것이 많습니다.
그 이유는 User 클래스가 엔티티이기 때문입니다. 엔티티 클래스에는 언제 다른 엔티티와 관계가 형성될지 모릅니다.
예를 들어 @OneToMany, @ManyToMany 등 자식 엔티티를 갖고 있다면 직렬화 대상에 자식들까지 포함되니, 성능 이슈, 부수효과가 발생할 확률이 높습니다.
그래서 직렬화 기능을 가진 세션 Dto를 하나 추가로 만드는 것이 이후 운영 및 유지 보수때 많은 도움이 됩니다.
*/
