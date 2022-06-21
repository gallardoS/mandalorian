package com.swamigallardo.mandalorian.User;

import java.time.LocalDateTime;
import java.util.Random;

public record User(Long id, String name, String surnames, LocalDateTime createdAt) {

    public User(String name, String surnames) {
        this(new Random().nextLong(1,100),
                name,
                surnames,
                LocalDateTime.now()
        );
    }
}
