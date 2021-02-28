package com.congman.ddd.common.specifications;

public enum CriteriaOperation {
    JOIN,
    JOIN_FETCH,
    EQUAL,
    EQUAL_TO_MANY,
    EQUAL_TO_ONE,
    LIKE,
    IS_NULL,
    IS_NOT_NULL,
    IN,
    LESS_THAN,
    LESS_THAN_OR_EQUAL_TO,
    GREATER_THAN,
    GREATER_THAN_OR_EQUAL_TO;
}
