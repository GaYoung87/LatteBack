package com.latte.admin.domain.host;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HostRepository extends JpaRepository<Host,Long> {
    @Query("select h from Host h where h.cname=:cname")
    Host findByName(@Param("cname") String cname);

    @Query("SELECT h FROM Host h ORDER BY h.hhid DESC")
    List<Host> findAllDesc();
}
