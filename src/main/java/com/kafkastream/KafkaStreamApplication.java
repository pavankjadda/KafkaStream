package com.kafkastream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class KafkaStreamApplication
{
	public static void main(String[] args)
    {
		SpringApplication.run(KafkaStreamApplication.class, args);
	}

    @PostConstruct
    public void init()
    {

    }
}
