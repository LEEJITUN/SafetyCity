package com.Bigdata.safetycity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", ""})
    public String mainBoard(){
        return "index";
    }

    @GetMapping("charts")
    public String chart(){
        return "charts";
    }

    @GetMapping("tables")
    public String table(){
        return "tables";
    }

    @GetMapping("graph")
    public String graph(){
        return "black-dashboard/dashboard";
    }




}
