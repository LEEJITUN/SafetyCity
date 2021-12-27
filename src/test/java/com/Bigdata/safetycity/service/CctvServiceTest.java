package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.repository.CctvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CctvServiceTest {
    @Autowired
    private CctvService cctvService;

    @Autowired
    private CctvRepository cctvRepository;

    public CctvServiceTest(CctvRepository cctvRepository){
        this.cctvRepository = cctvRepository;
    }

    @Test
    void getCctvs() {
        cctvRepository.findAll();
    }

    @Test
    void getTopCctvCount() {
        cctvRepository.findTop5Cctv();
    }
}