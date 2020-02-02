package com.latte.admin.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {

    @Query("select o from Ordered o where o.ooid=:ooid")
    Ordered findByOoid(@Param("ooid") Long ooid);

    //이 카페에 대한 모든 메뉴들을 가져와라!
    @Query("select o from Ordered o where o.cafeorder.ccid=:ccid")
    List<Ordered> findAllByCcid(@Param("ccid") Long ccid);

    // 손님기준
    @Query("select o from Ordered o where o.userorder.uuid=:uuid")
    List<Ordered> findAllByUuid(@Param("uuid") Long uuid);

}
