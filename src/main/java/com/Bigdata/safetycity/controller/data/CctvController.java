package com.Bigdata.safetycity.controller.data;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cctv")
public class CctvController {
    @GetMapping({"/", ""})
    public String cctv(){
        return "/dashboard/cctv/cctv";
    }

    @GetMapping("/chart")
    public String cctvChart(){
        return "/dashboard/cctv/cctv_charts";
    }

    @GetMapping("/table")
    public String cctvTable(){
        return "/dashboard/cctv/cctv_tables";
    }
}
