package com.deepakm.kstreams;

import com.deepakm.kstreams.sink.HttpSink;
import com.deepakm.kstreams.sink.Sink;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by deepakmarathe on 12/9/16.
 */
public class StreamingClient {

    private Properties kafkaConfig;
    private Sink sink;
    private String topicName;
    KafkaStreams kafkaStreams;

    public StreamingClient(Properties kafkaConfig, Sink sink, String topicName) {
        this.kafkaConfig = kafkaConfig;
        this.sink = sink;
        this.topicName = topicName;
    }

    public void start() {
        KStreamBuilder builder = new KStreamBuilder();
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();
        KStream<String, String> textLines = builder.stream(stringSerde, stringSerde, topicName);

        textLines.process(() -> new Processor<String, String>() {
            @Override
            public void init(ProcessorContext context) {

            }

            @Override
            public void process(String key, String value) {
                sink.pushMessage(key);
                sink.pushMessage(value);
                System.out.println("PUSHED message");
            }

            @Override
            public void punctuate(long timestamp) {

            }

            @Override
            public void close() {

            }
        });
        kafkaStreams = new KafkaStreams(builder, kafkaConfig);
        kafkaStreams.start();

    }

    public void close() {
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    }

}
