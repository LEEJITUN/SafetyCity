package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.repository.CctvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class CctvService {
    @Autowired
    private CctvRepository cctvRepository;

    @Transactional(readOnly = true)
    public Page<Cctv> getCctvsByArea(Pageable pageable,String area){
        return cctvRepository.findCctvByArea(pageable, area);
    }

    @Transactional(readOnly = true)
    public List<Count> getTopCctvCount(){
        return cctvRepository.findTop5Cctv();
    }

    @Transactional(readOnly = true)
    public List<Cctv> getCctvBylatlng(Double lat, Double lng){
        double minX = lat - 0.01;
        double maxX = lat + 0.01;
        double minY = lng - 0.01;
        double maxY = lng + 0.01;
        return cctvRepository.findCctvBylatlng(minX, maxX, minY, maxY);
    }
}
