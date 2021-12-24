package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.repository.CctvRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class HomeServiceTest {
    @Autowired
    private HomeService homeService;

    @Autowired
    private CctvRepository cctvRepository;

    public HomeServiceTest(CctvRepository cctvRepository){
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