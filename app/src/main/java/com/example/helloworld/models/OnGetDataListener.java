package com.example.helloworld.models;

public interface OnGetDataListener<T> {
    void onSuccess(T dataResponse);
    void onFailure();
}