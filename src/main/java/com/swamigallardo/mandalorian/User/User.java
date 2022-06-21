package com.swamigallardo.mandalorian.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public record User(Long id, String name, String surnames, @JsonFormat(pattern = "dd-MMM-yyyy HH:mm:ss z") Date createdAt) {

    public User(String name, String surnames) {
        this(new Random().nextLong(1,100),
                name,
                surnames,
                Date.from(Instant.now())
        );
    }
}
