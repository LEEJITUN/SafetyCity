package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.datas.EmergencyCall;
import com.Bigdata.safetycity.service.EmergencyCallService;
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
public class EmerCallsApiController {
    @Autowired
    private EmergencyCallService emergencyCallService;

    @GetMapping(value ="/api/emercall", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<EmergencyCall>> getEmergencyCall(@RequestParam(required = false) Integer page,
                                                       @RequestParam(required = false) Integer size,
                                                       @RequestParam String area){
        if(page == null) page = 0;
        if(size == null) size = 10000;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<EmergencyCall> emercalls = emergencyCallService.getCallsByArea(pageRequest, area);

        return new ResponseEntity<>(emercalls, HttpStatus.OK);
    }

    @GetMapping(value = "/api/emercallcnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Count>> datasent(){
        List<Count> callsCnt = emergencyCallService.getTop5();

        return new ResponseEntity<>(callsCnt, HttpStatus.OK);
    }

    @GetMapping(value = "/api/emercall/areacnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<EmergencyCall>> cctvCntByArea(@RequestParam Double lat, @RequestParam Double lng){
        return new ResponseEntity<>(emergencyCallService.getEmergencyCallBylatlng(lat, lng), HttpStatus.OK);
    }
}
