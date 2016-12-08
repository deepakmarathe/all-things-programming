package com.deepakm.kstreams;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Arrays;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by deepakmarathe on 12/8/16.
 */

/**
 * $KAFKA_HOME/bin/kafktopics.sh --create --topic TextLinesTopic --partitions 4 --zookeeper $ZK --replication-factor 1
 * <p>
 * $KAFKA_HOME/bin/kafka-topics.sh --create --topic RekeyedIntermediateTopic --partitions 4 --zookeeper $ZK --replication-factor 1
 * <p>
 * $KAFKA_HOME/bin/kafka-topics.sh --create --topic WordsWithCountsTopic --partitions 4 --zookeeper $ZK --replication-factor 1
 * <p>
 * $KAFKA_HOME/bin/kafka-console-producer.sh --topic=TextLinesTopic --broker-list=`broker-list.sh`
 * <p>
 * $KAFKA_HOME/bin/kafka-console-consumer.sh --topic=WordsWithCountsTopic --zookeeper=$ZK --from-beginning --property prkey=true --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
 */
public class WordCountLambdaExample {

    public static final String sourceTopic = "TextLinesTopic";
    public static final String intermediateTopic = "RekeyedIntermediateTopic";
    public static final String sinkTopic = "WordsWithCountsTopic";

    public static void main(String[] args) {

        String applicationId = "wordcount-lambda-example2";
        Properties streamsConfig = new Properties();
        streamsConfig.put(KafkaConfigKeys.KAFKA_APPLICATION_ID, applicationId);
        streamsConfig.put(KafkaConfigKeys.BOOTSTRAP_SERVERS, "172.16.223.152:32777");
        streamsConfig.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, "172.16.223.152:2181");
        streamsConfig.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfig.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, String> textLines = builder.stream(stringSerde, stringSerde, sourceTopic);

        Pattern pattern = Pattern.compile("\\W+", Pattern.UNICODE_CHARACTER_CLASS);

        KStream<String, Long> wordCounts = textLines
                .flatMapValues(value -> Arrays.asList(pattern.split(value.toLowerCase())))
                .map((key, word) -> new KeyValue<>(word, word))
                .through(intermediateTopic)
                .countByKey("Counts")
                .toStream();

        wordCounts.to(stringSerde, longSerde, sinkTopic);

        KafkaStreams kafkaStreams = new KafkaStreams(builder, streamsConfig);
        kafkaStreams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
    }
}
