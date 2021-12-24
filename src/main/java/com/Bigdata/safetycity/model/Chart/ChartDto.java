package com.Bigdata.safetycity.model.Chart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChartDto {
    private String type;
    private InnerData data;


    // 다음과 같은 json으로 반납되는지 테스트 필요!
    //    {
    //        type: "bar",
    //        data: {
    //        labels: ["강남구", "중랑구", "관악구", "서초구", "종로구"],
    //        datasets: [
    //        {
    //            label: "Revenue",
    //            backgroundColor: "rgba(2,117,216,1)",
    //            borderColor: "rgba(2,117,216,1)",
    //            data: [4215, 5312, 6251, 7841, 9821, 14984],
    //        },
    //    ],
    //    },
//    }
}
