package com.programmers.calculator.view;

import com.programmers.calculator.dto.ExpressionInputDto;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Menu selectMenu() {
        System.out.print("\n선택: ");
        String menuNumber = scanner.nextLine();

        return Menu.findByNumber(menuNumber);
    }

    @Override
    public ExpressionInputDto readExpression() {
        return new ExpressionInputDto(scanner.nextLine());
    }
}
