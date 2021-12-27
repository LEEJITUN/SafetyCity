package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CctvRepository extends JpaRepository<Cctv, Long> {
    @Query(value = "SELECT " +
            "cctv.area as name, COUNT(*) AS cnt " +
            "FROM cctv " +
            "group by cctv.area " +
            "order by cnt desc " +
            "limit 5",
            nativeQuery = true
    )
    List<Count> findTop5Cctv();
}
