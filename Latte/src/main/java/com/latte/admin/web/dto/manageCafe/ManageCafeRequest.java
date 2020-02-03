package com.latte.admin.web.dto.manageCafe;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ManageCafeRequest {
    private Long ccid;
    private int cstatus;

    @Builder
    public ManageCafeRequest(Long ccid, int cstatus){
        this.ccid=ccid;
        this.cstatus=cstatus;
    }
}
