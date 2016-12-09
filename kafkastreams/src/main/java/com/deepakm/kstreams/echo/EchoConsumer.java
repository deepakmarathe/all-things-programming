package com.deepakm.kstreams.echo;

import com.deepakm.kstreams.ConfigKeys;
import com.deepakm.kstreams.StreamingClient;
import com.deepakm.kstreams.sink.HttpSink;
import com.deepakm.kstreams.sink.Sink;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * Created by deepakmarathe on 12/9/16.
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
 * $KAFKA_HOME/bin/kafka-console-consumer.sh --topic=WordsWithCountsTopic --zookeeper=$ZK --from-beginning --property print.key=true --property value.deserializer=org.apache.kafka.common.serialization.StringDeserializer
 */
public class EchoConsumer {
    private static final Logger logger = Logger.getLogger(EchoConsumer.class);

    public static void main(String[] args) {

        String sourceTopic = System.getenv().get(ConfigKeys.SOURCE_TOPIC);
        String intermediateTopic = System.getenv().get(ConfigKeys.INTERMEDIATE_TOPIC);
        String sinkTopic = System.getenv().get(ConfigKeys.SINK_TOPIC);
        String bootstrapServers = System.getenv().get(ConfigKeys.BOOTSTRAP_SERVERS_VALUE);
        String zookeeperConnectValue = System.getenv().get(ConfigKeys.ZOOKEEPER_CONNECT_CONFIG_VALUE);
        String applicationId = System.getenv().get(ConfigKeys.APPLICATION_ID);

        logger.log(Level.DEBUG, "apploicationId : " + applicationId);
        logger.log(Level.DEBUG, "zookeeper config value : " + zookeeperConnectValue);
        logger.log(Level.DEBUG, "bootstrap servers : " + bootstrapServers);
        logger.log(Level.DEBUG, "sink topic : " + sinkTopic);
        logger.log(Level.DEBUG, "intermediate topic : " + intermediateTopic);
        logger.log(Level.DEBUG, "source topic : " + sourceTopic);

        Properties streamsConfig = new Properties();
        streamsConfig.put(ConfigKeys.KAFKA_APPLICATION_ID, applicationId);
        streamsConfig.put(ConfigKeys.BOOTSTRAP_SERVERS_KEY, bootstrapServers);
        streamsConfig.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, zookeeperConnectValue);
        streamsConfig.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfig.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        Sink sink = new HttpSink("http://localhost:8080/bookinglog");
        StreamingClient client = new StreamingClient(streamsConfig, sink, sourceTopic);
        client.start();
        client.close();
    }
}
