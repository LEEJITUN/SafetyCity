package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.datas.Cctv;
import com.Bigdata.safetycity.model.Count;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Cctv> findCctvByArea(Pageable pageable, String area);

    @Query(value = "SELECT * " +
            "FROM safetycity.cctv " +
            "where wgs_x > ?1 and wgs_x < ?2 " +
            "and wgs_y > ?3 and wgs_y < ?4",
            nativeQuery = true
    )
    List<Cctv> findCctvBylatlng(double minX, double maxX, double minY, double maxY);
}
