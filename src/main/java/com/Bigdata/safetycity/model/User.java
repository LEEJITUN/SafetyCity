package com.Bigdata.safetycity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private long id;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @CreationTimestamp // 시간 자동 입력
    private Timestamp createDate;
}