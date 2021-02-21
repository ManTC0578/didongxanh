package com.congman.ddd.exception;

import java.util.HashMap;
import java.util.Map;

public class ResourceNotFoundException extends RuntimeException {
    private final Map<String, Object> criteria = new HashMap<>();

    private final Class<?> target;
    public ResourceNotFoundException(Class<?> target, String key, Object value) {
        super(String.format("%s not found with {%s=%s}", target.getSimpleName(), key, value));
        this.target = target;
        this.criteria.put(key, value);
    }
}
