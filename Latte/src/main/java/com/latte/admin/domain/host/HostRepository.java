package com.latte.admin.domain.host;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HostRepository extends JpaRepository<Host,Long> {
    @Query("select h from Host h where h.cafename=:cafename")
    Host findByName(@Param("cafename") String cafename);
}
