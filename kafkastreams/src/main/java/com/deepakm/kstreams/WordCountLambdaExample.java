package com.deepakm.kstreams;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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

    public static void main(String[] args) {

        String sourceTopic = System.getenv().get(ConfigKeys.SOURCE_TOPIC);
        String intermediateTopic = System.getenv().get(ConfigKeys.INTERMEDIATE_TOPIC);
        String sinkTopic = System.getenv().get(ConfigKeys.SINK_TOPIC);
        String bootstrapServers = System.getenv().get(ConfigKeys.BOOTSTRAP_SERVERS_VALUE);
        String zookeeperConnectValue = System.getenv().get(ConfigKeys.ZOOKEEPER_CONNECT_CONFIG_VALUE);
        String applicationId = System.getenv().get(ConfigKeys.APPLICATION_ID);

        System.out.println("apploicationId : " + applicationId);
        System.out.println("zookeeper config value : " + zookeeperConnectValue);
        System.out.println("bootstrap servers : " + bootstrapServers);
        System.out.println("sink topic : " + sinkTopic);
        System.out.println("intermediate topic : " + intermediateTopic);
        System.out.println("source topic : " + sourceTopic);

        Properties streamsConfig = new Properties();
        streamsConfig.put(ConfigKeys.KAFKA_APPLICATION_ID, applicationId);
        streamsConfig.put(ConfigKeys.BOOTSTRAP_SERVERS_KEY, bootstrapServers);
        streamsConfig.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeeperConnectValue);
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
