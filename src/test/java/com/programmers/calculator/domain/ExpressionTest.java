package com.programmers.calculator.domain;

import com.programmers.calculator.exception.InvalidExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ExpressionTest {
    @ParameterizedTest
    @DisplayName("0으로 나누는 경우 예외가 발생한다.")
    @ValueSource(strings = {"2 + 8 / 0"})
    void 나누기_0_예외(String expression) {
        assertThatThrownBy(() -> new Expression(expression))
                .isInstanceOf(InvalidExpressionException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }
}
