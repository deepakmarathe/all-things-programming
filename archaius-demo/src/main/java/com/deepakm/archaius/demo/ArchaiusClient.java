package com.deepakm.archaius.demo;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.netflix.config.sources.DynamoDbConfigurationSource;
import com.netflix.config.validation.PropertyChangeValidator;
import com.netflix.config.validation.ValidationException;

import com.netflix.config.ConcurrentCompositeConfiguration;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.config.FixedDelayPollingScheduler;

public class ArchaiusClient {

    public static void main(String args[]) throws InterruptedException {

        String dynamoEndpoint = "https://dynamodb.us-west-2.amazonaws.com";
        AmazonDynamoDBClient dynamoClient = new AmazonDynamoDBClient(new ProfileCredentialsProvider("secret"));
        dynamoClient.setEndpoint(dynamoEndpoint);

        DynamoDbConfigurationSource source = new DynamoDbConfigurationSource(dynamoClient);
        ConfigurationManager.getConfigInstance().setProperty("com.netflix.config.dynamo.tableName", "sample-properties");
        ConfigurationManager.getConfigInstance().setProperty("com.netflix.config.dynamo.keyAttributeName", "key");
        ConfigurationManager.getConfigInstance().setProperty("com.netflix.config.dynamo.valueAttributeName", "value");

        FixedDelayPollingScheduler scheduler = new FixedDelayPollingScheduler(0, 100, false);
        DynamicConfiguration dynamicConfig = new DynamicConfiguration(source, scheduler);

        ConcurrentCompositeConfiguration finalConfig = new ConcurrentCompositeConfiguration();

        // add them in this order to make dynamicConfig override currentConfig
        finalConfig.addConfiguration(dynamicConfig);

        if (ConfigurationManager.isConfigurationInstalled())
            ConfigurationManager.loadPropertiesFromConfiguration(finalConfig);
        else
            ConfigurationManager.install(finalConfig);


        final DynamicStringProperty testProperty = DynamicPropertyFactory.getInstance().getStringProperty("test.property.name", "testProperty");
        System.out.println("initial value : " + testProperty.get());
        testProperty.addValidator(new PropertyChangeValidator() {
            public void validate(String s) throws ValidationException {
                if (s.length() < 20) {
                    /**
                     * If exceptions are throwmn inside validation, callback is not successfully executed.
                     */
                    //throw new IllegalArgumentException("Illegal argument");
                    System.out.println("value length < 20");
                }
            }
        });
        testProperty.addCallback(new Runnable() {
            public void run() {
                System.out.println("Property Changed. new value : " + testProperty.get());
            }
        });

        Thread.currentThread().join();

    }

}
