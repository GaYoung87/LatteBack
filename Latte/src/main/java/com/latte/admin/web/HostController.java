package com.latte.admin.web;

import com.latte.admin.domain.host.Host;
import com.latte.admin.service.HostService;
import com.latte.admin.web.dto.host.HostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;

    @GetMapping("/api/showAll")
    public List<Host> showAll(){
        return hostService.
    }

    @GetMapping("api/findByName/{cafename}")
    public HostResponseDto findByName(@PathVariable String cafename){
        return hostService.findByname(cafename);
    }

    @PostMapping("/api/savecafe")
    public Long save(@RequestBody HostSaveRequestDto hostSaveRequestDto) {
        return hostService.save(hostSaveRequestDto);
    }

    // 저장


}
