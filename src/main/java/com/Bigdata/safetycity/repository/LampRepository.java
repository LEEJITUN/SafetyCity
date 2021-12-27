package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.Count;
import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.datas.StreetLamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LampRepository extends JpaRepository<StreetLamp, Long> {
    @Query(value = "SELECT " +
            "streetlamp.managementOrg as name, COUNT(*) AS cnt " +
            "FROM streetlamp " +
            "group by streetlamp.managementOrg " +
            "order by cnt desc " +
            "limit 5",
            nativeQuery = true
    )
    List<Count> findTop5Lamp();
    List<StreetLamp> findStreetLampByManagementOrg(String area);
}
