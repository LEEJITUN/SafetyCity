package com.Bigdata.safetycity.model.datas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class SafetyHouse {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(length = 20)
    private String store;

    @Column(length = 20)
    private String city;

    @Column(length = 20)
    private String area;

    @Column(length = 20)
    private Integer cityCode;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String location;

    @Column(length = 20)
    private Float wgs_x;

    @Column(length = 20)
    private Float wgs_y;

    @Column(length = 30)
    private String phoneNumber;

    @Column(length = 20)
    private String police;

    @Column(length = 20)
    private String isOP;

    @Column(length = 20)
    private String dateTime;
}
