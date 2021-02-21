package com.congman.ddd.dto;

import com.congman.ddd.common.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorDTO implements Serializable {
    private ErrorCode code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String exception;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String path;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String debugMessage;

    private List<ViolationDTO> violationDTOS = new ArrayList<>();

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ViolationDTO> getViolationDTOS() {
        return violationDTOS;
    }

    public void setViolationDTOS(List<ViolationDTO> violationDTOS) {
        this.violationDTOS = violationDTOS;
    }

    public static Builder build() {
        return new Builder();
    }

    public static class Builder {
        private final ErrorDTO instance = new ErrorDTO();

        public Builder withCode(ErrorCode code) {
            instance.setCode(code);
            return this;
        }

        public Builder withMessage(String message) {
            instance.setMessage(message);
            return this;
        }

        public Builder withDebugMessage(String debugMessage) {
            instance.setDebugMessage(debugMessage);
            return this;
        }

        public Builder withException(Exception e) {
            instance.setException(e.getClass().getSimpleName());
            return this;
        }

        public Builder withPath(String path) {
            instance.setPath(path);
            return this;
        }

        public Builder withViolations(List<ViolationDTO> violations) {
            instance.setViolationDTOS(violations);
            return this;
        }

        public Builder addViolation(ViolationDTO violation) {
            instance.getViolationDTOS().add(violation);
            return this;
        }

        public ErrorDTO build() {
            return instance;
        }
    }

    public static ErrorDTO defaultServerError(Exception e) {
        return ErrorDTO.build()
                .withCode(ErrorCode.SERVER_ERROR)
                .withMessage("Unexpected error happened")
                .withException(e)
                .withDebugMessage(e.getMessage())
                .build();
    }

    public static ErrorDTO defaultClientError(Exception e) {
        return ErrorDTO.build()
                .withCode(ErrorCode.BAD_REQUEST)
                .withMessage("Unexpected error happened")
                .withException(e)
                .withDebugMessage(e.getMessage())
                .build();
    }

}
