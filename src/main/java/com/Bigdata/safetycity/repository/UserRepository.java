package com.Bigdata.safetycity.repository;

import com.Bigdata.safetycity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


// DAO
// 자동으로 bean 등록이 된다.
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    Optional<User> findByUsername(String username);
}

// JPA 네이밍 쿼리 전략
// SELECT * FROM user WHERE username = ? AND password = ?
//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//    User login(String username, String password);
