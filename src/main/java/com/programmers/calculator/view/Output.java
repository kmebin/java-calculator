package com.programmers.calculator.view;

public interface Output {
    void displayMenu();

    <T> void displayResult(T result);
}
