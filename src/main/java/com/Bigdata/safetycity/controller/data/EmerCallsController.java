package com.Bigdata.safetycity.controller.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emercall")
public class EmerCallsController {
    @GetMapping({"/", ""})
    public String index(){
        return "dashboard/emerCall/emerCall";
    }

    @GetMapping("chart")
    public String chart(){
        return "dashboard/emerCall/emerCall_charts";
    }

    @GetMapping("table")
    public String table(){
        return "dashboard/emerCall/emerCall_tables";
    }
}
