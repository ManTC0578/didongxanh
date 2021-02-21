package com.congman.ddd.dto.wrap;

import com.congman.ddd.common.enums.ErrorCode;
import org.apache.commons.lang3.tuple.Pair;

public class MonoResponse<T> {
    private ErrorCode errorCode;
    private T data;

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> MonoResponse<T> wrap(ErrorCode code, T data) {
        MonoResponse<T> dto = new MonoResponse<>();
        dto.setErrorCode(code);
        dto.setData(data);
        return dto;
    }

    public static <T> MonoResponse<T> wrap(T data) {
        return wrap(ErrorCode.SUCCESS, data);
    }

    public static MonoResponse<?> success() {
        return wrap(Pair.of("message", "Sucess"));
    }
}
