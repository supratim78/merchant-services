package com.cts.ms.service;

import com.cts.ms.exception.MSException;
import com.cts.ms.model.MerchantOnBoardingRequest;
import com.cts.ms.model.Merchants;

public interface MSMerchantOnBoardingService {

    public String processRequestForMerchantOnBoarding(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException;

    public String validateRequestForMerchantOnBoarding(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException;

    public Merchants createMerchantFromOnBoardingRequest(MerchantOnBoardingRequest merchantOnBoardingRequest) throws MSException;
}
