package com.example.tobby.templateCallback;

public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
