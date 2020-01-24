package com.latte.admin.domain.host;

import com.latte.admin.domain.guest.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HostRepository extends JpaRepository<Host,Long> {
    @Query("select c from Host c order by c.createdDate desc")
    List<Host> findAllDesc();

    @Query("select c from Host c where c.ccid=:ccid")
    Optional<Host> findByCcid(@Param("ccid") Long ccid);
}
