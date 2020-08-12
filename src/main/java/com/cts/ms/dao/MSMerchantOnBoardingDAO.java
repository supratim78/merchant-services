package com.cts.ms.dao;

import com.cts.ms.exception.MSException;
import com.cts.ms.model.MerchantOnBoardingRequest;

public interface MSMerchantOnBoardingDAO {

    public void save(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException;

    public void update(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException;
}
