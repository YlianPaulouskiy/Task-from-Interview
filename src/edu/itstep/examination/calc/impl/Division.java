package edu.itstep.examination.calc.impl;

import edu.itstep.examination.calc.Calculate;

public class Division implements Calculate {

    @Override
    public int getResult(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}
