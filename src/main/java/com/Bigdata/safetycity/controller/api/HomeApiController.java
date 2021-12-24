package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Cctv.Cctv;
import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.service.HomeService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeApiController {
    @Autowired
    private HomeService homeService;

    @GetMapping(value ="/api/cctv", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<Cctv>> getCctv(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer size){
        if(page == null) page = 0;
        if(size == null) size = 10;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Cctv> cctvs = homeService.getCctvs(pageRequest);
        return new ResponseEntity<>(cctvs, HttpStatus.OK);
    }

    @GetMapping(value = "/api/cctv/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Cctv>> getAllCctv(){
        List<Cctv> cctvs = homeService.getAllCctvs();
        return new ResponseEntity<>(cctvs, HttpStatus.OK);
    }
    
    // 일단 CCTV 하나만 테스트
    @GetMapping(value = "/api/cctvcnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Count>> datasent(){
        List<Count> cctvCnt = homeService.getTopCctvCount();

        return new ResponseEntity<>(cctvCnt, HttpStatus.OK);
    }
}