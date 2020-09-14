package com.latteback.admin.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//보통 MyBatis 에서 Dao 라고 불리는 DB Layer 접근자입니다.
//JPA에선 Repository라고 부르며 인터페이스로 생성합니다.
//단순히 인터페이스를 생성 후, JpaRepository<Entity 클래스,PK 타입>를 상속하면 기본적인 CRUD 메소드가
//자동으로 생성됩니다.
//@Repository를 추가할 필요도 없습니다. 다만 여기서 주의하실 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다는 점입니다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p order by p.id desc")
    List<Posts> findAllDesc();
    //위와 같이 SpringDataJpa에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 되는 것을 알 수 있습니다.
    //실제로 위의 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있습니다.
    //하지만 @Query가 훨씬 가독성이 좋으니 선택해서 사용하면 됩니다.
    //규모가 있는 프로젝트에서의 데이터 조회는 FK의 조인, 복잡한 조건 등으로 인해 이런 Entity 클래스만으로 처리하기 어려워
    //조회용 프레임워크를 추가로 사용합니다. 대표적으로 querydsl, jooq, MyBatis 등이 있습니다. 조회는 위 3가지 프레임 워크 중 하나를 통해 조회하고
    //등록/수정/삭제 등은 SpringDataJpa를 통해 진행합니다. 개인적으로는 querydsl을 추천합니다.
    //그 이유는 다음과 같습니다.
    //1. 타입 안정성이 보장됩니다.
    //단순한 문자열로 쿼리를 생성하는 것이 아니라, 메소드를 기반으로 쿼리를 생성하기 때문에 오타나 존재하지 않는 컬럼명을 명시할 경우 IDE에서
    //자동으로 검출됩니다. 이 장점은 Jooq에서도 지원하는 장점이지만, MyBatis에서는 지원하지 않습니다.

    //2. 국내 많은 회사에서 사용 중입니다.
    //쿠팡, 배민 등 JPA를 적극적으로 사용하는 회사에서는 Querydsl를 적극적으로 사용중입니다.

    //3. 레퍼런스가 많습니다.
    //앞 2번의 장점에서 이어지는 것인데, 많은 회사와 개발자들이 사용하다보니 그만큼 국내 자료가 많습니다.
    //어떤 문제가 발생했을 때 여러 커뮤니티에 질문하고 그에 대한 답변을 들을 수 있다는 것은 큰 장점입니다.
}
