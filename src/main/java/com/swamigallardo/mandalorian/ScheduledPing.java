package com.swamigallardo.mandalorian;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ScheduledPing {

    @Value("${heroku.prod.url}")
    private String urlHeroku;

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 1200000) // 20 minutes
    public void scheduledPing(){
        restTemplate.getForEntity(urlHeroku, String.class);
    }
}
