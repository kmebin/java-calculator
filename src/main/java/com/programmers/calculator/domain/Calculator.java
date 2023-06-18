package com.programmers.calculator.domain;

import com.programmers.calculator.util.PostfixConverter;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {
    public double calculate(Expression expression) {
        String postfixExpression = PostfixConverter.convert(expression.getValue());
        Deque<Double> operandStack = new ArrayDeque<>();

        Arrays.stream(postfixExpression.split(" "))
                .forEach(token -> {
                    if (Character.isDigit(token.charAt(0))) {
                        pushOperand(operandStack, token);
                    }
                    if (Operator.isOperator(token)) {
                        pushCalculatedOperand(operandStack, token);
                    }
                });

        return operandStack.pop();
    }

    private void pushOperand(Deque<Double> operandStack, String digit) {
        operandStack.push(Double.parseDouble(digit));
    }

    private void pushCalculatedOperand(Deque<Double> operandStack, String symbol) {
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();

        Operator operator = Operator.findBySymbol(symbol);
        double result = operator.calculate(operand1, operand2);

        operandStack.push(result);
    }
}
