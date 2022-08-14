package edu.itstep.examination.calc.impl;

import edu.itstep.examination.calc.Calculate;

public class Sum implements Calculate {

    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}
