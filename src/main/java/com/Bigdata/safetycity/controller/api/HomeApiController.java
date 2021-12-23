package com.Bigdata.safetycity.controller.api;

import com.Bigdata.safetycity.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApiController {
    @Autowired
    private HomeService homeService;


}
