package com.Bigdata.safetycity.controller.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lamp")
public class LampController {
    @GetMapping({"/", ""})
    public String index(){
        return "dashboard/lamp/lamp";
    }

    @GetMapping("chart")
    public String chart(){
        return "dashboard/lamp/lamp_charts";
    }

    @GetMapping("table")
    public String table(){
        return "dashboard/lamp/lamp_tables";
    }
}
