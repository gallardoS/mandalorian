package com.swamigallardo.mandalorian.commands;

import com.swamigallardo.mandalorian.EventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class JaduhereCommand implements EventListener<MessageCreateEvent> {

    @Value("${prefix}")
    private String prefix;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage());
    }


    public Mono<Void> processCommand(Message eventMessage) {
        return Mono.just(eventMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .filter(message -> message.getContent().equalsIgnoreCase(prefix + "Jaduhere"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("https://tenor.com/view/snoop-dogg-dr-dre-calvin-cordozar-broadus-jr-american-rapper-car-gif-17654008"))
                .then();
    }

}