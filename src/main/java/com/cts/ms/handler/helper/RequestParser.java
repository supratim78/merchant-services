package com.cts.ms.handler.helper;

import java.util.Map;

import com.cts.ms.exception.MSException;

public interface RequestParser<T> {

    public T parseRequestBody(Map<String, Object> request, Class<T> type) throws MSException;

    public String parsePathParameters(Map<String, Object> request, String key) throws MSException;
}
