package com.Bigdata.safetycity.controller.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/safetyhouse")
public class SafetyHouseController {

    @GetMapping({"/", ""})
    public String safetyHouse(){
        return "dashboard/safetyhouse/safetyhouse";
    }

    @GetMapping("chart")
    public String safetyHouseChart(){
        return "dashboard/safetyhouse/safetyhouse_charts";
    }

    @GetMapping("table")
    public String safetyHouseTable(){
        return "dashboard/safetyhouse/safetyhouse_tables";
    }
}
