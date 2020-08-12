package com.cts.ms.handler;

import java.util.Collections;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.ApiGatewayResponse;
import com.cts.ms.model.Merchants;
import com.cts.ms.service.MSMerchantManagementService;
import com.cts.ms.service.MerchantManagementService;

public class GetProvisionedMerchantRequestHandler extends MSBaseRequestHandler<String> {

    private MSMerchantManagementService msMerchantManagementService;

    public GetProvisionedMerchantRequestHandler() {
        super();
        msMerchantManagementService = new MerchantManagementService();
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> request, Context context) throws MSException {
        final String key = "mid";
        final String mid = parsePathParameters(request, key);
        try {
            Merchants merchants = msMerchantManagementService.getProvisionedMerchant(mid);
            return buildResponse(200, Collections.singletonMap("Powered-By", "Merchant On Boarding System"), merchants);
        } catch (MSException me) {
            return buildResponse(500, Collections.singletonMap("Powered-By", "Merchant On Boarding System"),
                    me.getMessage());
        }
    }

}
