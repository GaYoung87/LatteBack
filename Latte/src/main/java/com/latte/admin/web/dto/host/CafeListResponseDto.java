package com.latte.admin.web.dto.host;

import com.latte.admin.domain.host.Host;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CafeListResponseDto {
    private Long ccid;
    private String cname;
    private String cloc;
    private String cphone;
    private String cpic;
    private String copen;
    private String cclose;
    private String cdesc;
    private String cstatus;
    private LocalDateTime createdDate;

    public CafeListResponseDto(Host entity) {
        this.ccid=entity.getCcid();
        this.cname=entity.getCname();
        this.cloc=entity.getCloc();
        this.cphone=entity.getCphone();
        this.cpic=entity.getCpic();
        this.copen=entity.getCopen();
        this.cclose=entity.getCclose();
        this.cdesc=entity.getCdesc();
        this.cstatus=entity.getCstatus();
        this.createdDate=entity.getCreatedDate();
    }
}
