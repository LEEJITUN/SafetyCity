package com.Bigdata.safetycity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data

public class ChartDto {
    private String bar;
    private List<String> labels;

    class datasets{
        String label;
        String backgroundColor;
        String borderColor;
        List<Integer> data;
    }

//    {
//        type: "bar",
//                data: {
//        labels: ["강남구", "중랑구", "관악구", "서초구", "종로구"],
//        datasets: [
//        {
//            label: "Revenue",
//                    backgroundColor: "rgba(2,117,216,1)",
//                borderColor: "rgba(2,117,216,1)",
//                data: [4215, 5312, 6251, 7841, 9821, 14984],
//        },
//    ],
//    },
//    }
}
