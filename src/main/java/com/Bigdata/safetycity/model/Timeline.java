package com.Bigdata.safetycity.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "crime")
public class Timeline {
    @Id
    private String id;
    private String name;

}
