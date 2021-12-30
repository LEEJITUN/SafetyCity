package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Crime;
import com.Bigdata.safetycity.service.CrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("api/crime")
    public ResponseEntity<List<List<Crime>>> getCrime(){
        String[] crimeList = {"살인기수", "살인미수등", "강도", "강간", "유사강간", "기타 강간·강제추행등", "체포감금", "약취유인"};
        ArrayList<List<Crime>> ret = new ArrayList<>();
        for(String crime : crimeList){
            List<Crime> arr = crimeService.getCrimeByName(crime);
            ret.add(arr);
        }
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
}
