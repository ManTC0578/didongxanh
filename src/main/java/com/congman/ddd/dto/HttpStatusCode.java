package com.congman.ddd.util;

public enum HttpStatusCode {
    continuee(100,"continue"),
    ok(101,"ok"),
    length_required(411, "length required"),
    object_not_found(201,"Object not found"),
    item_empty(202,"Item is empty"),
    created(200,"created");

    private int code;
    private String des;
    private String text;

    HttpStatusCode(int code, String des) {
        this.code = code;
        this.des = des;
        this.text = Integer.toString(code);
    }

    public int getCode() {
        return code;
    }

    public String getDes() {
        return des;
    }

    public String getText() {
        return text;
    }
}
