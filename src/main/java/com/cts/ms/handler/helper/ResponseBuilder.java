package com.cts.ms.handler.helper;

import java.util.Map;

import com.cts.ms.exception.MSException;

public interface ResponseBuilder<T> {

    public T buildResponse(int statusCode, Map<String, String> header, Object body) throws MSException;
}
