package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.datas.StreetLamp;
import com.Bigdata.safetycity.service.CctvService;
import com.Bigdata.safetycity.service.LampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LampApiController {
    @Autowired
    private LampService lampService;

    @GetMapping(value ="/api/lamp", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<StreetLamp>> getLamp(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Integer size){
        if(page == null) page = 0;
        if(size == null) size = 10000;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<StreetLamp> lamps = lampService.getLamps(pageRequest);

        return new ResponseEntity<>(lamps, HttpStatus.OK);
    }

    @GetMapping(value ="/api/lamp/{area}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<StreetLamp>> getLampByArea(
            @PathVariable String area){
        List<StreetLamp> lamps = lampService.getLampsByArea(area);
        return new ResponseEntity<>(lamps, HttpStatus.OK);
    }

    @GetMapping(value = "/api/lamp/all", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<StreetLamp>> getAllLamp(){
        List<StreetLamp> lamps = lampService.getAllLamps();
        return new ResponseEntity<>(lamps, HttpStatus.OK);
    }

    // 일단 CCTV 하나만 테스트
    @GetMapping(value = "/api/lampcnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Count>> datasent(){
        List<Count> lampCnt = lampService.getTopLampCount();

        return new ResponseEntity<>(lampCnt, HttpStatus.OK);
    }
}
