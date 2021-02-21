package com.congman.ddd.util;

public class ReponseRest<T> {
    private int code;
    private String status;
    private T content;

    public ReponseRest(int code, String status, T content) {
        this.code = code;
        this.status = status;
        this.content = content;
    }

    public ReponseRest() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
