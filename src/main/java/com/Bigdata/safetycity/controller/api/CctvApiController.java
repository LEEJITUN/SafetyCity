package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.service.CctvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CctvApiController {
    @Autowired
    private CctvService cctvService;

    @GetMapping(value ="/api/cctv", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<Cctv>> getCctv(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer size,
                                              @RequestParam String area){
        if(page == null) page = 0;
        if(size == null) size = 10000;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());

        Page<Cctv> cctvs = cctvService.getCctvsByArea(pageRequest, area);
        return new ResponseEntity<>(cctvs, HttpStatus.OK);
    }

    // 일단 CCTV 하나만 테스트
    @GetMapping(value = "/api/cctvcnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Count>> datasent(){
        List<Count> cctvCnt = cctvService.getTopCctvCount();

        return new ResponseEntity<>(cctvCnt, HttpStatus.OK);
    }
}