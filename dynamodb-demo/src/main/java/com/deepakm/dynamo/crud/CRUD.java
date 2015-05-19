package com.deepakm.dynamo.crud;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.model.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class CRUD {

    static AmazonDynamoDBClient client;

    static {
        client = new AmazonDynamoDBClient(new ProfileCredentialsProvider("553480906216-Role_Developer"));
        client.setEndpoint("http://localhost:8002");
        CreateTableRequest createTable = new CreateTableRequest().
                withTableName("CatalogItem").
                withKeySchema(new HashSet<KeySchemaElement>() {{
                    add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH));
                }}).
                withAttributeDefinitions(new HashSet<AttributeDefinition>() {{
                    add(new AttributeDefinition().withAttributeName("Id").withAttributeType(ScalarAttributeType.N));
                }}).
                withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(1000L).withWriteCapacityUnits(1000L));

        CreateTableResult result = client.createTable(createTable);

    }

    public static void main(String[] args) throws IOException {
        testCRUDOperations();
        System.out.println("Example complete!");
    }


    private static void testCRUDOperations() {

        CatalogItem item = new CatalogItem();
        item.setId(601);
        item.setTitle("Book 601");
        item.setISBN("611-1111111111");
        item.setBookAuthors(new HashSet<String>(Arrays.asList("Author1", "Author2")));

        // Save the item (book).
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        mapper.save(item);

        // Retrieve the item.
        CatalogItem itemRetrieved = mapper.load(CatalogItem.class, 601);
        System.out.println("Item retrieved:");
        System.out.println(itemRetrieved);

        // Update the item.
        itemRetrieved.setISBN("622-2222222222");
        itemRetrieved.setBookAuthors(new HashSet<String>(Arrays.asList("Author1", "Author3")));
        mapper.save(itemRetrieved);
        System.out.println("Item updated:");
        System.out.println(itemRetrieved);

        // Retrieve the updated item.
        DynamoDBMapperConfig config = new DynamoDBMapperConfig(DynamoDBMapperConfig.ConsistentReads.CONSISTENT);
        CatalogItem updatedItem = mapper.load(CatalogItem.class, 601, config);
        System.out.println("Retrieved the previously updated item:");
        System.out.println(updatedItem);

        // Delete the item.
        mapper.delete(updatedItem);

        // Try to retrieve deleted item.
        CatalogItem deletedItem = mapper.load(CatalogItem.class, updatedItem.getId(), config);
        if (deletedItem == null) {
            System.out.println("Done - Sample item is deleted.");
        }


    }
}