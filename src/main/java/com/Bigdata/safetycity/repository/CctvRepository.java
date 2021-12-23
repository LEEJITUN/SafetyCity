package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.Cctv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CctvRepository extends JpaRepository<Cctv, Long> {
}
