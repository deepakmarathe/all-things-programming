package com.deepakm.dynamo.local;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

public class DynamoTableClientTest {
    private static DynamoTableClient tableClient;

    @BeforeClass
    public static void setUp() {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider("553480906216-Role_Developer"));
        client.setEndpoint("http://localhost:8002");
        tableClient = new DynamoTableClient(client);
    }

    @AfterClass
    public static void tearDown() {
        tableClient = null;
    }

    @Test
    public void shouldCreateIfNotExist() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        tableClient.createTable(uuid, 100L, 100L, "Id", "N");

        List<String> tables = tableClient.listTables();
        Assert.assertEquals(true, tableClient.exists(uuid));
        tableClient.deleteTable(uuid);
        Assert.assertEquals(false, tableClient.exists(uuid));
    }

    @Test(expected = com.amazonaws.services.dynamodbv2.model.ResourceInUseException.class)
    public void shouldNotCreateIfAlreadyExists() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        tableClient.createTable(uuid, 100L, 100L, "Id", "N");
        tableClient.createTable(uuid, 100L, 100L, "Id", "N");
        tableClient.deleteTable(uuid);
    }

}
