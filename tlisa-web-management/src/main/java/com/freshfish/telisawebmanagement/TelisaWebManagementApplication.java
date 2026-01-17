package com.freshfish.telisawebmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TelisaWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelisaWebManagementApplication.class, args);
    }

}
