package com.simplize.notificationservice.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Response<T> implements Serializable {
    private HttpStatus status;
    private String message;
    private Long total;
    private T data;

    public Response() {
    };

    public Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    };

    public Response(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    };

    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK, "Success", data);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>(HttpStatus.BAD_REQUEST, message);
    }
}
