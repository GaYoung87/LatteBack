package com.latte.admin.domain.guest;

import com.latte.admin.domain.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    @Query("select g from Guest g where g.gid=:gid")
    Guest findByGid(@Param("gid") String gid);
}
