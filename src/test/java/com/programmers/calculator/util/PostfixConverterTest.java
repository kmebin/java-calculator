package com.programmers.calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.programmers.calculator.util.PostfixConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PostfixConverterTest {
    @ParameterizedTest
    @DisplayName("후위 표기식 변환을 성공한다.")
    @MethodSource("expressionAndPostfixExpression")
    void 후위_표기식_변환(String expression, String expected) {
        String result = convert(expression);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> expressionAndPostfixExpression() {
        return Stream.of(
                arguments("1 + 3", "1 3 +"),
                arguments("4 - 2", "4 2 -"),
                arguments("15 * 2", "15 2 *"),
                arguments("6 / 4", "6 4 /"),
                arguments("30 + 2 * 4 - 9 / 3", "30 2 4 * + 9 3 / -")
        );
    }
}
