package com.augmentum.oes.exception;

import java.util.HashMap;
import java.util.Map;

public class VerificationException extends Exception {

    private static final long serialVersionUID = 498607906704378279L;
    private Map<String, String> exceptionMap;

    public VerificationException() {
        super();
    }

    public void add(String fieldName, String exceptionMessage) {

        if (exceptionMap == null) {
            exceptionMap = new HashMap<String, String>();
        }
        exceptionMap.put(fieldName, exceptionMessage);
    }

    public Map<String, String> getExceptionMap() {
        return exceptionMap;
    }

    public void setExceptionMap(Map<String, String> exceptionMap) {
        this.exceptionMap = exceptionMap;
    }

}
