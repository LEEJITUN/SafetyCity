package com.Bigdata.safetycity.service;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.datas.EmergencyCall;
import com.Bigdata.safetycity.repository.EmergencyCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmergencyCallService {
    @Autowired
    private EmergencyCallRepository emergencyCallRepository;

    @Transactional(readOnly = true)
    public Page<EmergencyCall> getCallsByArea(Pageable pageable, String area){
        return emergencyCallRepository.findByManagementOrg(pageable, area);
    }

    @Transactional(readOnly = true)
    public List<Count> getTop5(){
        List<Count> emerCalls = emergencyCallRepository.findTop5emerCalls();
        return emerCalls;
    }

    @Transactional(readOnly = true)
    public List<EmergencyCall> getEmergencyCallBylatlng(Double lat, Double lng){
        double minX = lat - 0.01;
        double maxX = lat + 0.01;
        double minY = lng - 0.01;
        double maxY = lng + 0.01;
        return emergencyCallRepository.findEmergencyCallBylatlng(minX, maxX, minY, maxY);
    }
}
