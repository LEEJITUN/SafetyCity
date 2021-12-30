package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Crime;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CrimeController {
    @Autowired
    private CrimeService crimeService;

    @GetMapping("api/crime/time/{time}")
    public ResponseEntity<List<Crime>> getCrimeByTime(@PathVariable String time){
        return new ResponseEntity<>(crimeService.getCrimeByTime(time), HttpStatus.OK);
    }

    @GetMapping("api/crime/name/{name}")
    public ResponseEntity<List<Crime>> getCrimeByName(@PathVariable String name){
        return new ResponseEntity<>(crimeService.getCrimeByName(name), HttpStatus.OK);
    }
}
