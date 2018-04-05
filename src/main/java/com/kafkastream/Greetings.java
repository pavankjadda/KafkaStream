package com.kafkastream;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

@Service

public class Greetings
{

    public void sendEvent()
    {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-greetings");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String,String>  source=builder.stream("greetings-input");
        source.to("greetings-output");
        //we can replace above 2 lines with
        // builder.stream("greetings-input").to("greetings-output");

        Topology    topology=builder.build();
        System.out.println("Topoly description: "+topology.describe());
        KafkaStreams    kafkaStreams=new KafkaStreams(topology,props);
        CountDownLatch  countDownLatch=new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook")
        {
            @Override
            public void run()
            {
                kafkaStreams.close();
                countDownLatch.countDown();
            }
        });

        try
        {
            kafkaStreams.start();
            countDownLatch.await();
        }

        catch (Throwable e)
        {
            System.exit(1);
        }
        System.exit(0);
    }


}
