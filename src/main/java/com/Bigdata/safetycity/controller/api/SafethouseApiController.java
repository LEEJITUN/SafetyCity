package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.SafetyHouse;
import com.Bigdata.safetycity.model.datas.StreetLamp;
import com.Bigdata.safetycity.service.LampService;
import com.Bigdata.safetycity.service.SafetyHouseService;
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
public class SafethouseApiController {
    @Autowired
    private SafetyHouseService safetyHouseService;

    @GetMapping(value ="/api/safetyhouse", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Page<SafetyHouse>> getSafetyhouse(@RequestParam(required = false) Integer page,
                                                     @RequestParam(required = false) Integer size,
                                                     @RequestParam String area){
        if(page == null) page = 0;
        if(size == null) size = 10000;

        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<SafetyHouse> safetyhouse = safetyHouseService.getSafetyhouseByArea(pageRequest, area);

        return new ResponseEntity<>(safetyhouse, HttpStatus.OK);
    }

    @GetMapping(value = "/api/safetyhousecnt", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Count>> datasent(){
        return new ResponseEntity<>(safetyHouseService.getTopSafetyhouseCount(), HttpStatus.OK);
    }
}
