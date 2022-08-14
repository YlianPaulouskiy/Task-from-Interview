package edu.itstep.examination.lines;

import edu.itstep.examination.converter.Converter;
import edu.itstep.examination.exception.DifferentNumberSystemException;
import edu.itstep.examination.exception.InvalidFormatSourceLineException;
import edu.itstep.examination.exception.InvalidNumberRangeException;
import edu.itstep.examination.exception.InvalidValuesNumberException;
import edu.itstep.examination.utils.NumberUtils;
import edu.itstep.examination.utils.StringUtils;

public class LineCheck {

    public static boolean check(String line) {
        line = StringUtils.removeSpaces(line);
        String[] numbers = StringUtils.getNumbers(line);
        // проверка на количество мат символов
        if (!checkAmountMathSymbol(line)) {
            throw new InvalidFormatSourceLineException();
        }
        if (numbers.length != 2) {
            throw new InvalidValuesNumberException();
        } else {
            String firstNum = numbers[0];
            String secondNum = numbers[1];
            //проверка что оба числа одинаковой системы счисления
            if (!isArabNumber(firstNum) && isArabNumber(secondNum)) {
                throw new DifferentNumberSystemException();
            } else if (isArabNumber(firstNum) && !isArabNumber(secondNum)) {
                throw new DifferentNumberSystemException();
            }
            //проверка диапозона значений
            if (isArabNumber(firstNum)) {
                //для арабских чисел
                if (!checkNumberRange(firstNum, secondNum)) {
                    throw new InvalidNumberRangeException();
                }
            } else {
                //для римских чисел
                String arabFirstNum = Converter.RimToArab(firstNum);
                String arabSecondNum = Converter.RimToArab(secondNum);
                if (!checkNumberRange(arabFirstNum, arabSecondNum)) {
                    throw new InvalidNumberRangeException();
                }
            }
        }
        return true;
    }


    /**
     * Проверяет явлются ли числа арабскими
     * если закастятся, то да, если нет, то римские
     *
     * @param number число
     * @return true, если арабские
     */
    public static boolean isArabNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    /**
     * Проверка диапозона для чисел от 1 до 10
     *
     * @param firstNumber  первое число в выражении
     * @param secondNumber второе число в выражении
     * @return true, если входят в диапозон
     */
    private static boolean checkNumberRange(String firstNumber, String secondNumber) {
        return (NumberUtils.getNumber(firstNumber) > 0 & NumberUtils.getNumber(firstNumber) <= 10)
                && (NumberUtils.getNumber(secondNumber) > 0 & NumberUtils.getNumber(secondNumber) <= 10);
    }

    private static boolean checkAmountMathSymbol(String line) {
        return line.split("\\d+").length <= 2;
    }
}
