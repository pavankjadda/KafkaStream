package com.kafkastream.service;

import com.kafkastream.event.GreetingsEvent;
import com.kafkastream.stream.GreetingsStreams;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GreetingsListener
{
    @StreamListener
    public void handleGreetings(@Input(GreetingsStreams.INPUT)   KStream<String,GreetingsEvent>    greetingsEventKStream)
    {
        log.info("Received greetings: {}", greetingsEventKStream);
    }
}
