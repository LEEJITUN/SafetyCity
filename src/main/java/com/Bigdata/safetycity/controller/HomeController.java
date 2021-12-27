package com.Bigdata.safetycity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mainBoard(){
        return "index";
    }

    @GetMapping("/charts")
    public String chart(){
        return "charts";
    }

    @GetMapping("/tables")
    public String table(){
        return "tables";
    }

    @GetMapping("/cctv")
    public String cctv(){
        return "dashboard/cctv/cctv";
    }

    @GetMapping("/lamp")
    public String lamp(){
        return "dashboard/lamp/lamp";
    }
}
