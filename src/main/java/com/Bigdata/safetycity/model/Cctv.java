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
public class Cctv {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(nullable = false, length = 20)
    private String area;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 20)
    private String useage;

    @Column(nullable = false, length = 20)
    private Float wgs_x;

    @Column(nullable = false, length = 20)
    private Float wgs_y;

    @CreationTimestamp // 시간 자동 입력
    private Timestamp modifyDate;
}
