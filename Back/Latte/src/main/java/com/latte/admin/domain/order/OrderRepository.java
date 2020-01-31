package com.latte.admin.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.ooid=:ooid")
    Order findByOoid(@Param("ooid") Long ooid);

    //이 카페에 대한 모든 메뉴들을 가져와라!
    @Query("select o from Order o where o.cafeorder.ccid=:ccid")
    List<Order> findAllByCcid(@Param("ccid") Long ccid);

    // 손님기준
    @Query("select o from Order o where o.userorder.uuid=:uuid")
    List<Order> findAllByUuid(@Param("uuid") Long uuid);

}
