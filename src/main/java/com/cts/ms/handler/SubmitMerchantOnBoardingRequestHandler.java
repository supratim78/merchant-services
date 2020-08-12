package com.cts.ms.handler;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.ms.model.MerchantOnBoardingRequest;
import com.cts.ms.service.MSMerchantOnBoardingService;
import com.cts.ms.service.MerchantOnBoardingService;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.ApiGatewayResponse;

public class SubmitMerchantOnBoardingRequestHandler extends MSBaseRequestHandler<MerchantOnBoardingRequest> {

    private final Logger log = Logger.getLogger(SubmitMerchantOnBoardingRequestHandler.class);
    private MSMerchantOnBoardingService msMerchantOnBoardingService;
    public SubmitMerchantOnBoardingRequestHandler() {
        super();
        msMerchantOnBoardingService = new MerchantOnBoardingService();

    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> request, Context context) {
        log.debug("Handling submitMerchantOnBoardingRequest..");
        MerchantOnBoardingRequest merchantOnBoardingRequest = null;
        try {
            merchantOnBoardingRequest = parseJsonRequestBody(request, MerchantOnBoardingRequest.class);
            String message = msMerchantOnBoardingService.processRequestForMerchantOnBoarding(merchantOnBoardingRequest);
            return buildResponse(200, Collections.singletonMap("Powered-By", "Merchant On Boarding System"),
                    message);
        }catch(MSException me) {
            return buildResponse(500, Collections.singletonMap("Powered-By", "Merchant On Boarding System"),
                    me.getMessage());
        }

    }

}
