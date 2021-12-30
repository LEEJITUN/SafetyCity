package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.model.Crime;
import com.Bigdata.safetycity.model.datas.Place;
import com.Bigdata.safetycity.service.PlaceService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    /* *
     * 전체 범죄 장소 조회
     * Service - getCrimeByPlcae
     * */
    @GetMapping("api/place")
    public ResponseEntity<List<List<Place>>> getPlaceByName(){
        String[] crimeList = {"살인","강도","강간및강제추행","절도","폭력"};
        
        ArrayList<List<Place>> ret = new ArrayList<>();
        
        for(String crime : crimeList){
            List<Place> arr = placeService.getPlaceByName(crime);
            ret.add(arr);
        }
        
        return new ResponseEntity<>(ret, HttpStatus.OK);
    }
    
    /* *
     * 전체 범죄 장소 조회
     * Service - getCrimeByPlcae
     * */
    @GetMapping("api/place/{name}")
    public ResponseEntity<List<Place>> findTop3PlaceByName(@PathVariable String name){
        return new ResponseEntity<>(placeService.findTop3PlaceByName(name), HttpStatus.OK);
    }


}
