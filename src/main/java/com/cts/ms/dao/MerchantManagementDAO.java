package com.cts.ms.dao;

import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.Merchants;

public class MerchantManagementDAO implements MSMerchantManagementDAO {

    private static final String MERCHANTS_TABLE_NAME = System
            .getenv("MERCHANTS_TABLE_NAME");
    private static DynamoDBAdapter DB_ADAPTER = null;
    private static DynamoDBMapperConfig mapperConfig = null;
    @SuppressWarnings("unused")
    private AmazonDynamoDB client = null;
    private DynamoDBMapper mapper; 

    public MerchantManagementDAO() {
        super();
        mapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(new DynamoDBMapperConfig
                .TableNameOverride(MERCHANTS_TABLE_NAME))
                .build();

        // get the db adapter
        DB_ADAPTER = DynamoDBAdapter.getInstance();
        this.client = DB_ADAPTER.getDbClient();

        // create the mapper with config
        this.mapper = DB_ADAPTER.createDbMapper(mapperConfig);
    }

    @Override
    public void save(Merchants merchants) throws MSException {
//        logger.info("merchants - save(): " + merchants.toString());
        this.mapper.save(merchants);

    }

    @Override
    public Merchants getProvisionedMerchant(final String mid) throws MSException {
        Merchants merchant = null;
        Long merchantId = Long.valueOf(mid);

        HashMap<String, AttributeValue> av = new HashMap<String, AttributeValue>();
        av.put(":v1", new AttributeValue().withN(mid));

        DynamoDBQueryExpression<Merchants> queryExp = new DynamoDBQueryExpression<Merchants>()
            .withKeyConditionExpression("mid = :v1")
            .withExpressionAttributeValues(av);

        PaginatedQueryList<Merchants> result = this.mapper.query(Merchants.class, queryExp);
        if (result.size() > 0) {
          merchant = result.get(0);
//          logger.info("Products - get(): product - " + merchant.toString());
        } else {
//          logger.info("Products - get(): product - Not Found.");
        }
        return merchant;
    }

    public List<Merchants> listAllProvisionedMerchants() throws MSException {
        DynamoDBScanExpression scanExp = new DynamoDBScanExpression();
        List<Merchants> results = null;
        try {
            results = this.mapper.scan(Merchants.class, scanExp);
        }catch(Exception e) {
            MSException mse = new MSException("Unable to do i/o operations wth dynamo db",e);
            throw mse;
        }
        
        return results;
      }

    public Boolean deleteMerchant(final String mid) throws MSException {
        Merchants merchant = null;

        // get merchant if exists
        merchant = getProvisionedMerchant(mid);
        if (merchant != null) {
//          logger.info("Products - delete(): " + product.toString());
          this.mapper.delete(merchant);
        } else {
//          logger.info("Products - delete(): product - does not exist.");
          return false;
        }
        return true;
    }

}
