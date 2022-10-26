package com.example.airbnb.model;

import lombok.Data;

@Data
public class Response<T> {
    public T t;

    public String message;
}
