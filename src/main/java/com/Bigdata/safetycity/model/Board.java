package com.Bigdata.safetycity.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Board {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;
    
    // CCTV, 경찰소 등 등 카테고리
    @Column(length = 20, nullable = false)
    private String caetegory;
    
    // 설명란
    @Column(length = 200, nullable = false)
    private String description;
    
    // 맵데이터 들고오기
    @Lob
    private String mapData;
}
