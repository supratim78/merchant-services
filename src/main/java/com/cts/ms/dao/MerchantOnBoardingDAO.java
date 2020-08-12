package com.cts.ms.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.MerchantOnBoardingRequest;

public class MerchantOnBoardingDAO implements MSMerchantOnBoardingDAO {

    private static final String MERCHANTS_ONBOARDING_REQUEST_TABLE_NAME = System
            .getenv("MERCHANTS_ONBOARDING_REQUEST_TABLE_NAME");
    private static DynamoDBAdapter DB_ADAPTER = null;
    private static DynamoDBMapperConfig mapperConfig = null;
    @SuppressWarnings("unused")
    private AmazonDynamoDB client = null;
    private DynamoDBMapper mapper; 

    public MerchantOnBoardingDAO() {
        super();
        mapperConfig = DynamoDBMapperConfig.builder().withTableNameOverride(new DynamoDBMapperConfig
                .TableNameOverride(MERCHANTS_ONBOARDING_REQUEST_TABLE_NAME))
                .build();

        // get the db adapter
        DB_ADAPTER = DynamoDBAdapter.getInstance();
        this.client = DB_ADAPTER.getDbClient();

        // create the mapper with config
        this.mapper = DB_ADAPTER.createDbMapper(mapperConfig);
    }

    @Override
    public void save(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException {
//        logger.info("merchantOnBoardingRequest - save(): " + merchantOnBoardingRequest.toString());
        this.mapper.save(merchantOnBoardingRequest,mapperConfig);
    }
    @Override
    public void update(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException {
//        logger.info("merchantOnBoardingRequest - update(): " + merchantOnBoardingRequest.toString());
//        DynamoDBMapperConfig dynamoDBMapperConfig = new DynamoDBMapperConfig(SaveBehavior.UPDATE);
        this.mapper.save(merchantOnBoardingRequest, mapperConfig);
        
    }

}
