package com.cts.ms.handler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.cts.ms.exception.MSException;
import com.cts.ms.model.ApiGatewayResponse;
import com.cts.ms.model.Merchants;
import com.cts.ms.service.MSMerchantManagementService;
import com.cts.ms.service.MerchantManagementService;

public class ListAllProvisionedMerchantRequestHandler extends MSBaseRequestHandler<String> {

    private final Logger log = Logger.getLogger(this.getClass());
    private MSMerchantManagementService msMerchantManagementService;

    public ListAllProvisionedMerchantRequestHandler() {
        super();
        msMerchantManagementService = new MerchantManagementService();
    }

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> request, Context context) throws MSException {
        log.debug("Start execution of ListAllProvisionedMerchantRequestHandler...");
        try {
            List<Merchants> merchants = msMerchantManagementService.listAllProvisionedMerchants();
            return buildResponse(200, Collections.singletonMap("Powered-By", "Merchant On Boarding System"), merchants);
        } catch (MSException me) {
            return buildResponse(500, Collections.singletonMap("Powered-By", "Merchant On Boarding System"),
                    me.getMessage());
        }
    }

}
