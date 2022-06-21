package com.swamigallardo.mandalorian.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping(value = "/random")
    public User getRandomUser(){
        User user = new User( "Swami", "Gallardo");
        log.info("Get random user with id: {}" , user.id());
        return user;
    }


}
