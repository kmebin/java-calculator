package com.programmers.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("사칙연산을 성공한다.")
    @MethodSource("expressionAndResult")
    void 사칙연산(String expression, double expected) {
        double result = calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> expressionAndResult() {
        return Stream.of(
                arguments("1 + 3", 4.0),
                arguments("4 - 2", 2.0),
                arguments("15 * 2", 30.0),
                arguments("6 / 4", 1.5),
                arguments("10 * 3 - 7 * 4", 2.0)
        );
    }
}
