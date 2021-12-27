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
public class StreetLamp {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(length = 30)
    private String name;

    @Column(length = 100, nullable = false)
    private String locationAddress;

    @Column(length = 20, nullable = false)
    private Float wgs_x;

    @Column(length = 20, nullable = false)
    private Float wgs_y;

    @Column(length = 20, nullable = false)
    private String type;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String managementOrg;

    @Column(length = 20, nullable = false)
    private String updatedAt;
}
