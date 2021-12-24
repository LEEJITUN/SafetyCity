package com.Bigdata.safetycity.model.Chart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InnerData{
    private List<String> labels;
    private Dataset datasets;


}