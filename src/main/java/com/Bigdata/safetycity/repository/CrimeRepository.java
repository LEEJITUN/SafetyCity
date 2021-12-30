package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
    List<Crime> findCrimesByTimeOrderByCountDesc(String time);
    List<Crime> findTop5ByTimeOrderByCountDesc(String time);
    List<Crime> findCrimesByName(String name);
}
