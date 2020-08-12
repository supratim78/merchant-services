package com.cts.ms.handler;

import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.cts.ms.model.ApiGatewayResponse;
import com.cts.ms.exception.MSException;
import com.cts.ms.handler.helper.DefaultApiGatewayResponseBuilder;
import com.cts.ms.handler.helper.DefaultJsonRequestParser;
import com.cts.ms.handler.helper.RequestParser;
import com.cts.ms.handler.helper.ResponseBuilder;

public abstract class MSBaseRequestHandler<T> implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private final Logger log = Logger.getLogger(this.getClass());
    public MSBaseRequestHandler() {
        super();
    }

    public abstract ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) throws MSException;

    public T parseJsonRequestBody(Map<String, Object> request, Class<T> type) throws MSException {
        log.debug("Start parsing json from request body..");
        T t = null;
        try {
            RequestParser<T> jsonRequestParser = new DefaultJsonRequestParser<T>();
            t = jsonRequestParser.parseRequestBody(request, type);
        }catch(MSException me) {
            log.error(me.getMessage());
            throw me;
        }
        return t;
    }

    public String parsePathParameters(Map<String, Object> request, String key) throws MSException {
        log.debug("Start parsing path parameters..");
        RequestParser<T> jsonRequestParser = new DefaultJsonRequestParser<T>();
        String parameter = jsonRequestParser.parsePathParameters(request, key);
        return parameter;
    }

    public ApiGatewayResponse buildResponse(int statusCode, Map<String, String> header, Object body)
            throws MSException {
        ResponseBuilder<ApiGatewayResponse> apiGatewayResponseBuilder = new DefaultApiGatewayResponseBuilder();
        return apiGatewayResponseBuilder.buildResponse(statusCode, header, body);
    }

}
