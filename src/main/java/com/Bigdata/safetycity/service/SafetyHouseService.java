package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.SafetyHouse;
import com.Bigdata.safetycity.model.datas.StreetLamp;
import com.Bigdata.safetycity.repository.SafetyHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SafetyHouseService {
    @Autowired
    private SafetyHouseRepository safetyHouseRepository;

    @Transactional(readOnly = true)
    public Page<SafetyHouse> getSafetyhouseByArea(Pageable pageable, String area){
        return safetyHouseRepository.findByArea(pageable, area);
    }

    @Transactional(readOnly = true)
    public List<Count> getTopSafetyhouseCount(){
        List<Count> safetyhouse = safetyHouseRepository.findTop5Safetyhouse();
        return safetyhouse;
    }
}
