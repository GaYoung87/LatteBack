package com.latte.admin.domain.menu;

import com.latte.admin.domain.cafe.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query("select m from Menu m where m.mmid=:mmid")
    Menu findByMmid(@Param("mmid") Long mmid);

    @Query("select m from Menu m where m.cafemenu.ccid=:ccid")
    List<Menu> findAllByCcid(@Param("ccid") Long ccid);
    //이 카페에 대한 모든 메뉴들을 가져와라!

    // mmain변경
    @Modifying
    @Query("update Menu m set m.mmain=:mmain where m.mmid=:mmid")
    void setMain(@Param("mmid") Long mmid,@Param("mmain") int mmain);

    // 메인 메뉴들 리스트로 보여주기
    @Query("select m from Menu m where m.mmain=:mmain")
    List<Cafe> mainStatus(@Param("mmain") int mmain);

}