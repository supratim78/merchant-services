package com.cts.ms.handler.helper;

import java.util.Map;

import com.cts.ms.exception.MSException;
import com.cts.ms.model.ApiGatewayResponse;

public class DefaultApiGatewayResponseBuilder implements ResponseBuilder<ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse buildResponse(int statusCode, Map<String, String> header, Object body) throws MSException {
        return ApiGatewayResponse.builder().setStatusCode(statusCode).setObjectBody(body)
                .setHeaders(header).build();
    }

}
