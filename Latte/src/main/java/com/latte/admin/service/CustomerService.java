package com.latte.admin.service;

import com.latte.admin.domain.customer.Customer;
import com.latte.admin.domain.customer.CustomerRepository;
import com.latte.admin.domain.customer.Role;
import com.latte.admin.web.dto.CustomerSaveRequestDto;
import com.latte.admin.web.dto.CustomerUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    // 저장 -> 사장별, 손님별 보기
    @Transactional
    public Long save(int role, CustomerSaveRequestDto customerSaveRequestDto) {
        if (role==1) return customerRepository.save(customerSaveRequestDto.toEntity(Role.HOST)).getUid();
        else return customerRepository.save(customerSaveRequestDto.toEntity(Role.GUEST)).getUid();
    }

    // 업데이트
    @Transactional
    public Long update(Long uid, CustomerUpdateRequestDto customerUpdateRequestDto) {
        Customer members= customerRepository.findById(uid).orElseThrow(()
                -> new IllegalArgumentException("해당 사용자가 없습니다. id="+uid));

        members.update(customerUpdateRequestDto.getPass(), customerUpdateRequestDto.getPhone(),
                customerUpdateRequestDto.getNickname(), customerUpdateRequestDto.getUpicture());

        return uid;
    }

    // 삭제
    @Transactional
    public void delete(Long uid){
        Customer members= customerRepository.findById(uid)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+uid));


        customerRepository.delete(members);
    }

}
