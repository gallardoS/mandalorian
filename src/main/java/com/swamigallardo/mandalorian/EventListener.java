package com.swamigallardo.mandalorian;

import discord4j.core.event.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public interface EventListener <T extends Event>{

    Logger log = LoggerFactory.getLogger(EventListener.class);

    Class<T> getEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError(Throwable error){
        log.error("Error handling event" + getEventType().getSimpleName(), error);
        return Mono.empty();
    }


}
