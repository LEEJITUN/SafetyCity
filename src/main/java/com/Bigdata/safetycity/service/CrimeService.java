package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.model.Crime;
import com.Bigdata.safetycity.repository.CrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CrimeService {
    @Autowired
    private CrimeRepository crimeRepository;

    @Transactional(readOnly = true)
    public List<Crime> getCrimeByTime(String time){
        return crimeRepository.findTop5ByTimeOrderByCountDesc(time);
    }

    @Transactional(readOnly = true)
    public List<Crime> getCrimeByName(String name){
        return crimeRepository.findCrimesByName(name);
    }
}
