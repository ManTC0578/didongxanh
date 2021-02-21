package com.congman.ddd.dto;

import java.io.Serializable;

public class ViolationDTO implements Serializable {
    private String filedName;
    private String message;

    public ViolationDTO() {
    }

    public ViolationDTO(String filedName, String message) {
        this.filedName = filedName;
        this.message = message;
    }

    public static ViolationDTO of(String field, String message) {
        return new ViolationDTO(field, message);
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
