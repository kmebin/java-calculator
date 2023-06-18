package com.programmers.calculator;

import com.programmers.calculator.domain.CalculationResult;
import com.programmers.calculator.dto.ExpressionInputDto;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Menu;
import com.programmers.calculator.view.Output;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CalculatorController implements Runnable {
    private final Input input;
    private final Output output;
    private final CalculatorService calculatorService;

    public CalculatorController(Input input, Output output, CalculatorService calculatorService) {
        this.input = input;
        this.output = output;
        this.calculatorService = calculatorService;
    }

    @Override
    public void run() {
        AtomicBoolean running = new AtomicBoolean(true);

        while (running.get()) {
            output.displayMenu();
            Menu menu = input.selectMenu();

            switch (menu) {
                case HISTORY -> {
                    getHistory().forEach(output::displayResult);
                }
                case CALCULATE -> {
                    CalculationResult result = calculate(input.readExpression());
                    output.displayResult(result.getResult());
                }
                case EXIT -> running.set(false);
            }
        }
    }

    private List<CalculationResult> getHistory() {
        return calculatorService.findCalculationHistory();
    }

    private CalculationResult calculate(ExpressionInputDto expressionInputDto) {
        return calculatorService.calculate(expressionInputDto);
    }
}
