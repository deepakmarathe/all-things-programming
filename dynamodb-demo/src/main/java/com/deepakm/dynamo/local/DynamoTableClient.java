package com.deepakm.dynamo.local;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;

public class DynamoTableClient {

    private AmazonDynamoDBClient client;

    public DynamoTableClient(AmazonDynamoDBClient client) {
        this.client = client;
    }

    /**
     * @param tableName
     * @param readsPerSecond
     * @param writesPerSecond
     * @param hashKeyName
     * @param hashKeyType
     */
    public void createTable(String tableName, Long readsPerSecond, Long writesPerSecond, final String hashKeyName, final String hashKeyType) {
        CreateTableRequest createTable = new CreateTableRequest().
                withTableName(tableName).
                withKeySchema(new HashSet<KeySchemaElement>() {{
                    add(new KeySchemaElement().withAttributeName(hashKeyName).withKeyType(KeyType.HASH));
                }}).
                withAttributeDefinitions(new HashSet<AttributeDefinition>() {{
                    add(new AttributeDefinition().withAttributeName(hashKeyName).withAttributeType(hashKeyType));
                }}).
                withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(readsPerSecond).withWriteCapacityUnits(writesPerSecond));

        CreateTableResult result = client.createTable(createTable);
    }

    /**
     * @param tableName
     * @param readsPerSecond
     * @param writesPerSecond
     * @param hashKeyName
     * @param hashKeyType
     * @param rangeKeyName
     * @param rangeKeyType
     */
    public void createTable(String tableName, Long readsPerSecond, Long writesPerSecond, final String hashKeyName, final String hashKeyType, final String rangeKeyName, final String rangeKeyType) {
        CreateTableRequest createTable = new CreateTableRequest().
                withTableName(tableName).
                withKeySchema(new HashSet<KeySchemaElement>() {{
                    add(new KeySchemaElement().withAttributeName(hashKeyName).withKeyType(KeyType.HASH));
                    add(new KeySchemaElement().withAttributeName(rangeKeyName).withKeyType(KeyType.RANGE));
                }}).
                withAttributeDefinitions(new HashSet<AttributeDefinition>() {{
                    add(new AttributeDefinition().withAttributeName(hashKeyName).withAttributeType(hashKeyType));
                    add(new AttributeDefinition().withAttributeName(rangeKeyName).withAttributeType(rangeKeyType));
                }}).
                withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(readsPerSecond).withWriteCapacityUnits(writesPerSecond));

        CreateTableResult result = client.createTable(createTable);
    }

    public boolean exists(String tableName){
        ListTablesResult list = client.listTables();
        return list.getTableNames().contains(tableName);
    }

    /**
     * @param outputStream
     * @throws IOException
     */
    public void listTables(OutputStream outputStream, String delimiter) throws IOException {
        ListTablesResult list = client.listTables();
        for (String tableName : list.getTableNames()) {
            outputStream.write(tableName.getBytes());
            outputStream.write(delimiter.getBytes());
        }
    }

    public List<String> listTables(){
        ListTablesResult list = client.listTables();
        return list.getTableNames();
    }

    public void deleteTable(String tableName) throws InterruptedException {
        Table table = new DynamoDB(client).getTable(tableName);
        table.delete();
        table.waitForDelete();
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider("553480906216-Role_Developer"));
        client.setEndpoint("http://localhost:8002");
        DynamoTableClient localClient = new DynamoTableClient(client);

        System.out.println("creating tables... ");
        localClient.createTable("table1", 10L, 20L, "pk", "S");
        localClient.createTable("table2", 10L, 20L, "pk", "S", "income", "N");
        System.out.println("listing tables... ");
        localClient.listTables(System.out, "\n");
        System.out.println("deleting tables... ");
        localClient.deleteTable("table1");
        localClient.deleteTable("table2");
        System.out.println("listing tables... ");
        localClient.listTables(System.out, "\n");

    }
}
