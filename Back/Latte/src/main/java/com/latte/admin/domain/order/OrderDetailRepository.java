package com.latte.admin.domain.order;

import com.latte.admin.domain.cafe.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    // orderSimple별로 orderDetail 다 보여주기
    @Query("select od from OrderDetail od order by od.ordered.ooid desc")
    List<Cafe> findAllDesc();

    // order하나에 여러개의 orderDetail가지고오기
    @Query("select od from OrderDetail od where od.ordered.ooid=:ooid")
    List<OrderDetail> findAllByOoid(@Param("ooid") Long ooid);
}
