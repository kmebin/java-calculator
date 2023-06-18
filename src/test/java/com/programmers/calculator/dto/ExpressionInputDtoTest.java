package com.programmers.calculator.dto;

import com.programmers.calculator.exception.InvalidExpressionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ExpressionInputDtoTest {
    @ParameterizedTest
    @DisplayName("수식 포맷팅에 성공한다.")
    @CsvSource({"2 +   30/3 , 2 + 30 / 3", "  4+1*10, 4 + 1 * 10"})
    void 수식_포맷팅(String input, String expected) {
        ExpressionInputDto result = new ExpressionInputDto(input);
        assertThat(result.getExpression()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("잘못된 수식인 경우 예외가 발생한다.")
    @ValueSource(strings = {"2 + - 8 / ", ". a ㄱ"})
    void 잘못된_수식_형식_예외(String input) {
        assertThatThrownBy(() -> new ExpressionInputDto(input))
                .isInstanceOf(InvalidExpressionException.class)
                .hasMessage("올바르지 않은 수식입니다.");
    }
}
