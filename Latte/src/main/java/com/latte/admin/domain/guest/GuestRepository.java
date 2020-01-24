package com.latte.admin.domain.guest;

import com.latte.admin.domain.host.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    @Query("select g from Guest g where g.gid=:gid")
    Optional<Guest>  findByGid(@Param("gid") String gid);

    @Query("select g from Guest g where g.gname=:gname and g.gemail=:gemail")
    Optional<Guest>  findByNameEmail(@Param("gname") String gname, @Param("gemail") String gemail);

    @Query("select g from Guest g where g.gemail=:gemail")
    Optional<Guest>  findByEmail(@Param("gemail") String gemail);


}
