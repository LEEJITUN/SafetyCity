package com.Bigdata.safetycity;

import com.Bigdata.safetycity.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class SafetyCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyCityApplication.class, args);
    }

}