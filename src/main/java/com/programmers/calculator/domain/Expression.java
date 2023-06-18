package com.programmers.calculator.domain;

import com.programmers.calculator.constant.ErrorMessage;
import com.programmers.calculator.exception.InvalidExpressionException;

public class Expression {
    private final String value;

    public Expression(String value) {
        this.value = value;
        validateDivisionByZero();
    }

    public String getValue() {
        return value;
    }

    private void validateDivisionByZero() {
        if (value.contains("/ 0")) {
            throw new InvalidExpressionException(ErrorMessage.DIVISION_BY_ZERO);
        }
    }
}
