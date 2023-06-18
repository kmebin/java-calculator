package com.programmers;

import com.programmers.calculator.CalculatorController;
import com.programmers.calculator.CalculatorRepository;
import com.programmers.calculator.CalculatorService;
import com.programmers.calculator.MemoryCalculatorRepository;
import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.view.ConsoleInput;
import com.programmers.calculator.view.ConsoleOutput;
import com.programmers.calculator.view.Input;
import com.programmers.calculator.view.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        Calculator calculator = new Calculator();
        CalculatorRepository calculatorRepository = new MemoryCalculatorRepository();
        CalculatorService calculatorService = new CalculatorService(calculator, calculatorRepository);

        CalculatorController calculatorController = new CalculatorController(input, output, calculatorService);
        calculatorController.run();
    }
}
