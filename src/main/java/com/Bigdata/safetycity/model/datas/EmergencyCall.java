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
public class EmergencyCall {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(length = 50)
    private String identifier;

    @Column(length = 20)
    private String purpose;

    @Column(length = 20)
    private String locationType;

    @Column(length = 50)
    private String location;

    @Column(length = 100)
    private String streetAddress;

    @Column(length = 100)
    private String locationAddress;

    @Column(length = 20)
    private Double wgs_x;

    @Column(length = 20)
    private Double wgs_y;

    @Column(length = 20)
    private String link;

    @Column(length = 20)
    private String policeCon;

    @Column(length = 20)
    private String securityCon;

    @Column(length = 20)
    private String managementCon;

    @Column(length = 20)
    private String addon;

    @Column(length = 20)
    private Integer startedYear;

    @Column(length = 20)
    private String lastInspectionDate;

    @Column(length = 20)
    private String InspectionResult;

    @Column(length = 30)
    private String managementOrg;

    @Column(length = 30)
    private String phoneNumber;

    @Column(length = 20)
    private String date;
}
