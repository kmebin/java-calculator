package com.programmers.calculator.domain;

public class CalculationResult {
    private String expression;
    private double result;

    public CalculationResult(Expression expression, double result) {
        this.expression = expression.getValue();
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return expression + " = " + result;
    }
}
