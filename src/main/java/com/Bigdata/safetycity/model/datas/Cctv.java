package com.Bigdata.safetycity.model.datas;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cctv {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(length = 20)
    private String area;

    @Column(length = 100)
    private String address;

    @Column( length = 20)
    private String useage;

    @Column(length = 20)
    private Float wgs_x;

    @Column(length = 20)
    private Float wgs_y;

    @Column(length = 20)
    private String modifyDate;
}
