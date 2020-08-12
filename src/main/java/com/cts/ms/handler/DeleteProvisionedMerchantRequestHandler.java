package com.cts.ms.handler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.ApiGatewayResponse;
import com.cts.ms.model.Merchants;
import com.cts.ms.service.MSMerchantManagementService;
import com.cts.ms.service.MerchantManagementService;

public class DeleteProvisionedMerchantRequestHandler extends MSBaseRequestHandler<String> {

    private MSMerchantManagementService msMerchantManagementService;

    public DeleteProvisionedMerchantRequestHandler() {
        super();
        msMerchantManagementService = new MerchantManagementService();
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> request, Context context) throws MSException {
        final String key = "mid";
        final String mid = parsePathParameters(request, key);
        try {
            boolean flag = msMerchantManagementService.deleteMerchant(mid);
            String message = "";
            if(flag) {
                message = "Merchant with mid = " +  mid + " has been deleted";
            }else {
                message = "Unable to delete Merchant with mid = " +  mid;
            }
            return buildResponse(200, Collections.singletonMap("Powered-By", "Merchant On Boarding System"), message);
        } catch (MSException me) {
            return buildResponse(500, Collections.singletonMap("Powered-By", "Merchant On Boarding System"),
                    me.getMessage());
        }
    }

}
