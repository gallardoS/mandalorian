package com.swamigallardo.mandalorian;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PingController {

    @Value("${mandalorian.ping.up}")
    String ping;

    @GetMapping
    public String ping(){
        return ping;
    }
}
