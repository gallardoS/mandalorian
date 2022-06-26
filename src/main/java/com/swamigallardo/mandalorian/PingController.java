package com.swamigallardo.mandalorian;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class PingController {

    @Value("${mandalorian.ping.up}")
    String ping;

    @GetMapping
    public String ping(){
        log.info("Ping received");
        return ping;
    }
}
