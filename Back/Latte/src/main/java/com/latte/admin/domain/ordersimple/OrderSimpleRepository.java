package com.latte.admin.domain.ordersimple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderSimpleRepository extends JpaRepository<OrderSimple, Long> {

    @Query("select o from OrderSimple o where o.ooid=:ooid")
    OrderSimple findByOoid(@Param("ooid") Long ooid);

    //이 카페에 대한 모든 메뉴들을 가져와라!
    @Query("select o from OrderSimple o where o.cafeorder.ccid=:ccid")
    List<OrderSimple> findAllByCcid(@Param("ccid") Long ccid);

    // 손님기준
    @Query("select o from OrderSimple o where o.userorder.uuid=:uuid")
    List<OrderSimple> findAllByUuid(@Param("uuid") Long uuid);

}
