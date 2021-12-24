package com.Bigdata.safetycity.model.Chart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dataset{
    private String label;
    private String backgroundColor;
    private String borderColor;
    private List<Integer> data;
}