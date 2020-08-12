package com.cts.ms.handler.helper;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.cts.ms.exception.MSException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DefaultJsonRequestParser<T> implements RequestParser<T> {

    private final String MS_REQUEST_BODY_JSON_KEY = "body";
    private final String MS_REQUEST_PATH_PARAMETERS_KEY = "pathParameters";
    private final Logger log = Logger.getLogger(this.getClass());

    public DefaultJsonRequestParser() {
        super();
    }

    @Override
    public T parseRequestBody(Map<String, Object> request, Class<T> type) throws MSException {

        log.debug("Start Of parseJsonRequestBody().........");
        String jsonBody = (String) request.get(MS_REQUEST_BODY_JSON_KEY);
        log.debug("jsonBody =========>\n\n");
        log.debug(jsonBody);
        ObjectMapper objectMapper = new ObjectMapper();
        log.debug("objectMapper ====>\n\n");
        log.debug(objectMapper.toString());
        T t = null;

            try {
                t = objectMapper.readValue(jsonBody,type);
            } catch (JsonParseException e) {
                MSException moe = new MSException("Error occourred while parsing json request",e);
                throw moe;
            } catch (JsonMappingException e) {
                MSException moe = new MSException("Error occourred while mapping json request",e);
                throw moe;
            } catch (IOException e) {
                MSException moe = new MSException("Error occourred while reading the input data",e);
                throw moe;
            }
        return t;

    }

    @Override
    public String parsePathParameters(Map<String, Object> request, String key) throws MSException {
        Map<String, String> pathParametersMap = (Map<String, String>) request
                .get(MS_REQUEST_PATH_PARAMETERS_KEY);
        String parameter = (String) pathParametersMap.get(key);
        return parameter;
    }

}
