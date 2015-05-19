package com.deepakm.dynamo.crud;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.deepakm.dynamo.local.DynamoTableClient;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CatalogDAO {
    private DynamoDBMapper mapper;

    public CatalogDAO(AmazonDynamoDBClient client, String tableName) {
        this.mapper = new DynamoDBMapper(client);

        DynamoTableClient local = new DynamoTableClient(client);
        if (local.exists(tableName)) {
            try {
                local.deleteTable(tableName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        local.createTable(tableName, 100L, 100L, "Id", "N");
    }

    public void save(CatalogItem item) {
        mapper.save(item);
    }

    public void delete(CatalogItem item) {
        mapper.delete(item);
    }

    public List<CatalogItem> list(Integer id) {
        CatalogItem query = new CatalogItem();
        query.setId(id);
        DynamoDBQueryExpression<CatalogItem> queryExpression = new DynamoDBQueryExpression<CatalogItem>().withHashKeyValues(query);
        List<CatalogItem> itemList = mapper.query(CatalogItem.class, queryExpression);
        return itemList;
    }


    public static void main(String[] args) throws InterruptedException {
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider("553480906216-Role_Developer"));
        client.setEndpoint("http://localhost:8002");


        CatalogDAO dao = new CatalogDAO(client, "ProductCatalog");
        CatalogItem item = new CatalogItem();
        item.setId(100);
        item.setTitle("Book 1");
        item.setISBN("222-33333");
        item.setBookAuthors(new HashSet<String>(Arrays.asList("Author 1", "Author 2")));
        item.setSomeProp("Test");
        dao.save(item);

        for (CatalogItem catalogItem : dao.list(100)) {
            System.out.println(catalogItem);
        }

        dao.delete(item);

    }
}
