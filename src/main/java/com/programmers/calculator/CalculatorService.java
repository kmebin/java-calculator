package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;
import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.domain.Expression;
import com.programmers.calculator.dto.ExpressionInputDto;

import java.util.List;

public class CalculatorService {
    private final Calculator calculator;
    private final CalculatorRepository calculatorRepository;

    public CalculatorService(Calculator calculator, CalculatorRepository calculatorRepository) {
        this.calculator = calculator;
        this.calculatorRepository = calculatorRepository;
    }

    public CalculationResult calculate(ExpressionInputDto expressionInputDto) {
        Expression expression = new Expression(expressionInputDto.getExpression());
        double result = calculator.calculate(expression.getValue());

        CalculationResult calculationResult = new CalculationResult(expression, result);
        calculatorRepository.save(calculationResult);

        return calculationResult;
    }

    public List<CalculationResult> findCalculationHistory() {
        return calculatorRepository.findAll();
    }
}
