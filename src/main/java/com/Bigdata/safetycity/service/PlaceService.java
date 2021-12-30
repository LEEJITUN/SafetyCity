package com.Bigdata.safetycity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.Bigdata.safetycity.model.datas.Place;
import com.Bigdata.safetycity.repository.PlaceRepository;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    /*
     * 범죄장소 조회
     * Service: getPlaceByName
     * return List<Place>
     */
    @Transactional(readOnly = true)
    public List<Place> getPlaceByName(String name){
        return placeRepository.findPlaceByName(name);
    }

    /*
     * 범죄장소 Top3
     * Service: findTop3PlaceByName
     * return List<Place>
     */
	public List<Place> findTop3PlaceByName(String name) {
		return placeRepository.findTop3ByNameOrderByCountDesc(name);
	}
	

}
