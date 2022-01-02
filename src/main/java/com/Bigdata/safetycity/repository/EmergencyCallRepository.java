package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.EmergencyCall;
import com.Bigdata.safetycity.model.datas.SafetyHouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyCallRepository extends JpaRepository<EmergencyCall, Long> {
    @Query(value = "SELECT " +
            "emergencycall.managementOrg as name, COUNT(*) AS cnt " +
            "FROM emergencycall " +
            "group by emergencycall.managementOrg " +
            "order by cnt desc " +
            "limit 5",
            nativeQuery = true
    )
    List<Count> findTop5emerCalls();
    Page<EmergencyCall> findByManagementOrg(Pageable pageable, String area);
    @Query(value = "SELECT * " +
            "FROM safetycity.emergencyCall " +
            "where wgs_x > ?1 and wgs_x < ?2 " +
            "and wgs_y > ?3 and wgs_y < ?4",
            nativeQuery = true
    )
    List<EmergencyCall> findEmergencyCallBylatlng(double minX, double maxX, double minY, double maxY);
}
