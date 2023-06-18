package com.programmers.calculator.view;

import com.programmers.calculator.dto.ExpressionInputDto;

public interface Input {
    Menu selectMenu();

    ExpressionInputDto readExpression();
}
