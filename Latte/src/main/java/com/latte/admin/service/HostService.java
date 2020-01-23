package com.latte.admin.service;

import com.latte.admin.domain.host.Host;
import com.latte.admin.domain.host.HostRepository;
import com.latte.admin.web.dto.HostSaveRequestDto;
import com.latte.admin.web.dto.HostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    @Transactional
    public List<Host> findAll(){
        return hostRepository.findAll();
    }


    @Transactional
    public HostResponseDto findByname(String cafename){
        Host h=hostRepository.findByname(cafename);
        HostResonseDto newhost.builder()
                .asdsdf().build();

    return newhost())
    }

    // 저장
    @Transactional
    public Long save(HostSaveRequestDto hostSaveRequestDto) {
        return hostRepository.save(hostSaveRequestDto.toEntity()).getHid();
}

    // 업데이트
    @Transactional
    public Long update(Long hid, HostUpdateRequestDto hostUpdateRequestDto) {
        Host cafes= hostRepository.findById(hid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. id="+hid));

        cafes.update(hostUpdateRequestDto.getCafepic(), hostUpdateRequestDto.getCafestatus(), hostUpdateRequestDto.getCafeopen());

        return hid;
    }

    // 삭제
    @Transactional
    public void delete(Long hid){
        Host cafes= hostRepository.findById(hid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. id="+hid));


        hostRepository.delete(cafes);
    }
}
