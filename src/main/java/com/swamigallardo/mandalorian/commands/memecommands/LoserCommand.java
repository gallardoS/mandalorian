package com.swamigallardo.mandalorian.commands;

import com.swamigallardo.mandalorian.EventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LoserCommand implements EventListener<MessageCreateEvent> {

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
                .filter(message -> message.getContent().equalsIgnoreCase(prefix + "Loser"))
                .flatMap(Message::getChannel)
                .flatMap(channel -> channel.createMessage("https://cdn.discordapp.com/attachments/759881447535804437/793166765219643393/loser.png"))
                .then();
    }

}