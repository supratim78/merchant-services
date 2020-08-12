package com.cts.ms.handler.helper;

import com.cts.ms.exception.MSException;

public interface RequestValidator<M,T> {

    public T validateRequest(M m) throws MSException;
}
