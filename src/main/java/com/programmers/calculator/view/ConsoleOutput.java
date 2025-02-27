package com.programmers.calculator.view;

import java.util.Arrays;

public class ConsoleOutput implements Output {
    @Override
    public void displayMenu() {
        System.out.println();
        Arrays.stream(Menu.values())
                .forEach(menu -> System.out.println(menu.getMenuNumber() + ". " + menu.getText()));
    }

    @Override
    public <T> void displayResult(T result) {
        System.out.println(result);
    }
}
